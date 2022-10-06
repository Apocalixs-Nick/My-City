package com.example.mycity.ui.test

//Data class containing parameters for status update
data class CityCategory(
     val imagecategoryCity: List<Int> = listOf(),
     val titlecategoryCity: List<Int> = listOf(),
     val categorySelected: String = "",
     val titleAppBar: String = "",
     val detailsCard: Activity? = null
)