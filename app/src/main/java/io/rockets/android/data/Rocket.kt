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
        var active: Boolean = false, // true
        @SerializedName("boosters")
        var boosters: Int = 0, // 0
        @SerializedName("company")
        var company: String = "", // SpaceX
        @SerializedName("cost_per_launch")
        var costPerLaunch: Int = 0, // 50000000
        @SerializedName("country")
        var country: String = "", // United States
        @SerializedName("description")
        var description: String = "", // Falcon 9 is a two-stage rocket designed and manufactured by SpaceX for the reliable and safe transport of satellites and the Dragon spacecraft into orbit.
        @SerializedName("first_flight")
        var firstFlight: Date? = null, // 2010-06-04
        @SerializedName("flickr_images")
        var flickrImages: Array<String> = emptyArray(),
        @SerializedName("id")
        var id: Int = 0, // 2
        @SerializedName("rocket_id")
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "rocket_id")
        var rocketId: String = "", // falcon9
        @SerializedName("rocket_name")
        var rocketName: String = "", // Falcon 9
        @SerializedName("rocket_type")
        var rocketType: String? = null, // rocket
        @SerializedName("stages")
        var stages: Int = 0, // 2
        @SerializedName("success_rate_pct")
        var successRatePct: Int? = null, // 97
        @SerializedName("engines")
        @Embedded
        var engines: Engine = Engine()
) {
//    @Relation(entity = Launch::class, parentColumn = "id", entityColumn = "rocketId", projection = ["rocketId"])
//    var launches: List<Launch> = emptyList()
}