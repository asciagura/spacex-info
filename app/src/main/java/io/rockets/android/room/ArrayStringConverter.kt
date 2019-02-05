package io.rockets.android.room

import androidx.room.TypeConverter
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class ArrayStringConverter {
    private val gson = GsonBuilder().create()
    @TypeConverter
    fun listFromJson(value: String?): Array<String>? {
        return value?.let { gson.fromJson(it, TypeToken.getArray(String::class.java).type) }
    }

    @TypeConverter
    fun listToJson(list: Array<String>?): String? {
        return list?.let {
            gson.toJson(it)
        }
    }
}