package com.example.beerace.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Bee(
    val color: String,
    val name: String
) : Parcelable