package com.example.beerace.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RaceDurationResponse(
    val timeInSeconds: Int
) : Parcelable