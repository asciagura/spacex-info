package io.rockets.android.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "launches")
data class Launch(
        @SerializedName("details")
        val details: String? = null, // Part of the Explorers program, this space telescope is intended for wide-field search of exoplanets transiting nearby stars. It is the first NASA high priority science mission launched by SpaceX. It was the first time SpaceX launched a scientific satellite not primarily intended for Earth observations. The second stage placed it into a high-Earth elliptical orbit, after which the satellite's own booster will perform complex maneuvers including a lunar flyby, and over the course of two months, reach a stable, 2:1 resonant orbit with the Moon. In January 2018, SpaceX received NASA's Launch Services Program Category 2 certification of its Falcon 9 'Full Thrust', certification which is required for launching medium risk missions like TESS. It was the last launch of a new Block 4 booster, and marked the 24th successful recovery of the booster. An experimental water landing was performed in order to attempt fairing recovery.
        @SerializedName("flight_number")
        @PrimaryKey
        val flightNumber: Int = 0, // 60
        @SerializedName("is_tentative")
        val isTentative: Boolean? = null, // false
        @SerializedName("launch_date_utc")
        val launchDateUtc: Date? = null, // 2018-04-18T22:51:00.000Z
        @SerializedName("links")
        @Embedded
        val links: Links = Links(),
        @SerializedName("launch_success")
        val launchSuccess: Boolean = false, // true
        @SerializedName("launch_window")
        val launchWindow: Int? = null, // 30
        @SerializedName("launch_year")
        val launchYear: String? = null, // 2018
        @SerializedName("mission_id")
        val missionId: Array<String> = emptyArray(),
        @SerializedName("mission_name")
        val missionName: String = "", // TESS
        @ColumnInfo(name = "rocket_id")
        val rocketId: String? = null,
        @SerializedName("static_fire_date_utc")
        val staticFireDateUtc: Date? = null, // 2018-04-11T18:30:00.000Z
        @SerializedName("tbd")
        val tbd: Boolean? = null, // false
        @SerializedName("tentative_max_precision")
        val tentativeMaxPrecision: String? = null, // hour
        @SerializedName("upcoming")
        val upcoming: Boolean? = null // false
)