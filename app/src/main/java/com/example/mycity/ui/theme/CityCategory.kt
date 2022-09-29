package com.example.mycity.ui.theme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CityCategory(
     val imagecategoryCity: List<Int> = listOf(),
     val titlecategoryCity: List<Int> = listOf(),
     val categorySelected: String = "",
     val titleAppBar: String = "",
     val detailsCard: Activity? = null
)