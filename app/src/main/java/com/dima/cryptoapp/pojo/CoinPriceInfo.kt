package com.dima.cryptoapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dima.cryptoapp.api.ApiFactory.BASE_IMAGE_URL
import com.dima.cryptoapp.utils.convertTimestampToTime
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName = "full_price_list")
data class CoinPriceInfo(

    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromsymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    val tosymbol: String?,

    @SerializedName("PRICE")
    @Expose
    val price: Double?,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastupdate: Long?,

    @SerializedName("HIGHDAY")
    @Expose
    val highday: Double?,

    @SerializedName("LOWDAY")
    @Expose
    val lowday: Double?,

    @SerializedName("LASTMARKET")
    @Expose
    val lastmarket: String?,

    @SerializedName("IMAGEURL")
    @Expose
    val imageurl: String?

) {
    fun getFormattedTime(): String {
        return convertTimestampToTime(lastupdate)
    }

    fun getFullImageUrl(): String {
        return BASE_IMAGE_URL + imageurl
    }
}