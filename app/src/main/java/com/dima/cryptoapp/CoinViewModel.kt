package com.dima.cryptoapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dima.cryptoapp.api.ApiFactory
import com.dima.cryptoapp.database.AppDatabase
import com.dima.cryptoapp.pojo.CoinPriceInfo
import com.dima.cryptoapp.pojo.CoinPriceInfoRawData
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()

    val priceList = db.coinPriceInfoDao().getPriceList()

    fun getDetailInfo(fSymb: String) : LiveData<CoinPriceInfo>{
        return db.coinPriceInfoDao().getPriceInfoAboutCoin(fSymb)
    }

    init {
        loadData()
    }

    private fun loadData() {
        val disposable = ApiFactory.apiService.getTopCoinsInfo(limit = 50)
            .map { it.data?.map { it.coinInfo?.name }?.joinToString(",") }
            .flatMap { ApiFactory.apiService.getFullPriceList(fSyms = it) }
            .map { getPriceListFromRawData(it) }
            .delaySubscription(10, TimeUnit.SECONDS)//раз в 10 секунд
            .repeat() // постоянно выполняет загрузку если все прошло успешно
            .retry() //постоянно выполняет загрузку если все прошло не успешно
            .subscribeOn(Schedulers.io())
            .subscribe({
                db.coinPriceInfoDao().insertPriceList(it)
                Log.d("Test_loading_data", "Success: $it")
            }, {
                Log.d("Test_loading_data", "Fail: $it")
            })
    }

    private fun getPriceListFromRawData(coinPriceInfoRawData: CoinPriceInfoRawData): List<CoinPriceInfo> {
        val result = ArrayList<CoinPriceInfo>()
        val jsonObject = coinPriceInfoRawData.coinPriceInfoJsonObject ?: return result
        val coinKeySet = jsonObject.keySet() //получаем ключи js обьекта
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinPriceInfo::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}