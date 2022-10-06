package com.example.mycity.ui.test

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//Data class containing the parameters of the category elements (what the cards are)
data class Activity(
    val Title: String,
    @DrawableRes val Image: Int,
    val Description: String,
    @StringRes val category: Int,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val link: String
)
