package io.rockets.android.data

import com.google.gson.annotations.SerializedName

data class Links(
        @SerializedName("article_link")
        val articleLink: String? = null, // https://spaceflightnow.com/2018/04/19/all-sky-surveyor-launched-from-cape-canaveral-on-the-hunt-for-exoplanets/
        @SerializedName("flickr_images")
        val flickrImages: Array<String>? = null,
        @SerializedName("mission_patch")
        val missionPatch: String? = null, // https://images2.imgbox.com/7d/2c/pYXpOVCz_o.png
        @SerializedName("mission_patch_small")
        val missionPatchSmall: String? = null // https://images2.imgbox.com/ca/54/EEGqRRto_o.png
)