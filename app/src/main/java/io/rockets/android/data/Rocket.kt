package io.rockets.android.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "rockets")
data class Rocket(
        @SerializedName("active")
        val active: Boolean = false, // true
        @SerializedName("boosters")
        val boosters: Int = 0, // 0
        @SerializedName("company")
        val company: String = "", // SpaceX
        @SerializedName("cost_per_launch")
        val costPerLaunch: Int = 0, // 50000000
        @SerializedName("country")
        val country: String = "", // United States
        @SerializedName("description")
        val description: String = "", // Falcon 9 is a two-stage rocket designed and manufactured by SpaceX for the reliable and safe transport of satellites and the Dragon spacecraft into orbit.
        @SerializedName("first_flight")
        val firstFlight: Date? = null, // 2010-06-04
        @SerializedName("flickr_images")
        val flickrImages: Array<String> = emptyArray(),
        @SerializedName("id")
        val id: Int = 0, // 2
        @SerializedName("rocket_id")
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "rocket_id")
        val rocketId: String = "", // falcon9
        @SerializedName("rocket_name")
        val rocketName: String = "", // Falcon 9
        @SerializedName("rocket_type")
        val rocketType: String? = null, // rocket
        @SerializedName("stages")
        val stages: Int = 0, // 2
        @SerializedName("success_rate_pct")
        val successRatePct: Int? = null, // 97
        @SerializedName("engines")
        @Embedded
        val engines: Engine = Engine()
) {
//    @Relation(entity = Launch::class, parentColumn = "id", entityColumn = "rocketId", projection = ["rocketId"])
//    var launches: List<Launch> = emptyList()
}