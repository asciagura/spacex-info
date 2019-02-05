package io.rockets.android.data

import com.google.gson.annotations.SerializedName


data class Engine(
        @SerializedName("engine_loss_max")
        var engineLossMax: Int = 0, // 2
        @SerializedName("layout")
        var layout: String? = null, // octaweb
        @SerializedName("number")
//        @PrimaryKey(autoGenerate = false)
        var number: Int = 0, // 9
        @SerializedName("propellant_1")
        var propellant1: String = "", // liquid oxygen
        @SerializedName("propellant_2")
        var propellant2: String = "", // RP-1 kerosene
        @SerializedName("thrust_to_weight")
        var thrustToWeight: Double = .0, // 180.1
        @SerializedName("type")
        var type: String = "", // merlin
        @SerializedName("version")
        var version: String = "" // 1D+
)