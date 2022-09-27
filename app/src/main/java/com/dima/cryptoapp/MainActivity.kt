package com.dima.cryptoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dima.cryptoapp.adapters.CoinInfoAdapter
import com.dima.cryptoapp.pojo.CoinPriceInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener{
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
               val intent = Intent(this@MainActivity,CoinDetailActivity::class.java)
                intent.putExtra(CoinDetailActivity.EXTRA_FROM_SYMBOL,coinPriceInfo.fromsymbol)
                startActivity(intent)
            }
        }
        rvCoinPriceList.adapter = adapter
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.priceList.observe(this,Observer{
            adapter.coinInfoList = it
        })
    }
}