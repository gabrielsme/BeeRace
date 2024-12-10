package com.example.beerace.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.example.beerace.data.model.Bee
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val BeeType = object : NavType<Bee>(isNullableAllowed = false) {
    override fun put(bundle: Bundle, key: String, value: Bee) {
        bundle.putParcelable(key, value)
    }

    override fun get(bundle: Bundle, key: String): Bee? {
        return bundle.getParcelable(key)
    }

    override fun serializeAsValue(value: Bee): String {
        return Uri.encode(Json.encodeToString(value))
    }

    override fun parseValue(value: String): Bee {
        return Json.decodeFromString<Bee>(value)
    }
}