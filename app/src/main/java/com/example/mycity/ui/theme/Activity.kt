package com.example.mycity.ui.theme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Activity(
    val Title: String,
    @DrawableRes val Image: Int,
    val Description: String,
    @StringRes val category: Int,
    val address: String,
    val latitude: Double,
    val longitude: Double
)
