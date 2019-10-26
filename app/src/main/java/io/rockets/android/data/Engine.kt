package io.rockets.android.data

import com.google.gson.annotations.SerializedName


data class Engine(
        @SerializedName("engine_loss_max")
        val engineLossMax: Int = 0, // 2
        @SerializedName("layout")
        val layout: String? = null, // octaweb
        @SerializedName("number")
//        @PrimaryKey(autoGenerate = false)
        val number: Int = 0, // 9
        @SerializedName("propellant_1")
        val propellant1: String = "", // liquid oxygen
        @SerializedName("propellant_2")
        val propellant2: String = "", // RP-1 kerosene
        @SerializedName("thrust_to_weight")
        val thrustToWeight: Double = .0, // 180.1
        @SerializedName("type")
        val type: String = "", // merlin
        @SerializedName("version")
        val version: String = "" // 1D+
)