package com.example.mycity.ui.test

import com.example.mycity.R
import com.example.mycity.data.ActivitiesCardDataSource.activities
import org.junit.Assert.*
import org.junit.Test

private val viewModel = CityViewModel()
private val activity : Activity = Activity(
    Title = "Century Park Caserta",
    Image = R.drawable.century_parck,
    Description = "Un posto dove passare le giornate con i propri figli",
    category = R.string.kid_friendly,
    address = "Via degli Ulivi, 7, 81100 Caserta CE",
    latitude = 41.068920598341975,
    longitude = 14.358270153685107,
    link = "https://goo.gl/maps/PFV8jNTPWBJAmS1R7"
)

class CityViewModelTest {
    var currentCityUiState = viewModel.uiState.value

    @Test
    fun testUpdateCategorySelected() {
        viewModel.updateCategorySelected(currentCityUiState.categorySelected)
    }
    @Test
    fun testUpdateTitleAppBar() {
        viewModel.updateTitleAppBar(currentCityUiState.titleAppBar)
    }
    @Test
    fun testUpdateActivitiesDetailsCard() {
        viewModel.updateActivitiesDetailsCard(activity)
    }
}