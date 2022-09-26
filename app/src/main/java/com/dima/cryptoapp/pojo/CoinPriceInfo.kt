package com.dima.cryptoapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_price_list")
data class CoinPriceInfo(
    @SerializedName("TYPE")
    @Expose
    private val type: String?,

    @SerializedName("MARKET")
    @Expose
    private val market: String?,

    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    private val fromsymbol: String?,

    @SerializedName("TOSYMBOL")
    @Expose
    private val tosymbol: String?,

    @SerializedName("FLAGS")
    @Expose
    private val flags: String?,

    @SerializedName("PRICE")
    @Expose
    private val price: Int?,

    @SerializedName("LASTUPDATE")
    @Expose
    private val lastupdate: Int?,

    @SerializedName("LASTVOLUME")
    @Expose
    private val lastvolume: Double?,

    @SerializedName("LASTVOLUMETO")
    @Expose
    private val lastvolumeto: Double?,

    @SerializedName("LASTTRADEID")
    @Expose
    private val lasttradeid: String?,

    @SerializedName("VOLUMEDAY")
    @Expose
    private val volumeday: Double?,

    @SerializedName("VOLUMEDAYTO")
    @Expose
    private val volumedayto: Double?,

    @SerializedName("VOLUME24HOUR")
    @Expose
    private val volume24hour: Double?,

    @SerializedName("VOLUME24HOURTO")
    @Expose
    private val volume24hourto: Double?,

    @SerializedName("OPENDAY")
    @Expose
    private val openday: Double?,

    @SerializedName("HIGHDAY")
    @Expose
    private val highday: Double?,

    @SerializedName("LOWDAY")
    @Expose
    private val lowday: Double?,

    @SerializedName("OPEN24HOUR")
    @Expose
    private val open24hour: Double?,

    @SerializedName("HIGH24HOUR")
    @Expose
    private val high24hour: Double?,

    @SerializedName("LOW24HOUR")
    @Expose
    private val low24hour: Double?,

    @SerializedName("LASTMARKET")
    @Expose
    private val lastmarket: String?,

    @SerializedName("VOLUMEHOUR")
    @Expose
    private val volumehour: Double?,

    @SerializedName("VOLUMEHOURTO")
    @Expose
    private val volumehourto: Double?,

    @SerializedName("OPENHOUR")
    @Expose
    private val openhour: Double?,

    @SerializedName("HIGHHOUR")
    @Expose
    private val highhour: Double?,

    @SerializedName("LOWHOUR")
    @Expose
    private val lowhour: Double?,

    @SerializedName("TOPTIERVOLUME24HOUR")
    @Expose
    private val toptiervolume24hour: Double?,

    @SerializedName("TOPTIERVOLUME24HOURTO")
    @Expose
    private val toptiervolume24hourto: Double?,

    @SerializedName("CHANGE24HOUR")
    @Expose
    private val change24hour: Double?,

    @SerializedName("CHANGEPCT24HOUR")
    @Expose
    private val changepct24hour: Double?,

    @SerializedName("CHANGEDAY")
    @Expose
    private val changeday: Double?,

    @SerializedName("CHANGEPCTDAY")
    @Expose
    private val changepctday: Double?,

    @SerializedName("SUPPLY")
    @Expose
    private val supply: Int?,

    @SerializedName("MKTCAP")
    @Expose
    private val mktcap: Double?,

    @SerializedName("TOTALVOLUME24H")
    @Expose
    private val totalvolume24h: Double?,

    @SerializedName("TOTALVOLUME24HTO")
    @Expose
    private val totalvolume24hto: Double?,

    @SerializedName("TOTALTOPTIERVOLUME24H")
    @Expose
    private val totaltoptiervolume24h: Double?,

    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    @Expose
    private val totaltoptiervolume24hto: Double?,

    @SerializedName("IMAGEURL")
    @Expose
    private val imageurl: String?,
)