package com.example.mycity.ui.theme

import android.icu.text.CaseMap
import androidx.lifecycle.ViewModel
import com.example.mycity.data.ActivitiesCardDataSource
import com.example.mycity.data.CategoryDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CityCategory(CategoryDataSource.category_image,CategoryDataSource.category_title))
    val uiState: StateFlow<CityCategory> = _uiState.asStateFlow()

    fun updateCategorySelected(selectedCategory: String){
        _uiState.update { currentState ->
            currentState.copy(
                categorySelected = selectedCategory
            )
        }
    }
    fun updateTitleAppBar(title: String) {
        _uiState.update { currentTitleState ->
            currentTitleState.copy(
                titleAppBar = title
            )
        }
    }
    fun updateActivitiesDetailsCard(activity: Activity) {
        _uiState.update { currentDetailsCard ->
            currentDetailsCard.copy(
                detailsCard = activity
            )
        }
    }
}
/*
data class CityUiState(
    val cityList: List<Activity> = emptyList(),
    val currentCard: List<Activity> = ActivitiesCardDataSource.activities,
    val isShowingListPage: Boolean = true
)*/