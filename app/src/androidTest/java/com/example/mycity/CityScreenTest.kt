package com.example.mycity

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.espresso.action.ViewActions.click
import com.example.mycity.data.ActivitiesCardDataSource
import com.example.mycity.data.ActivitiesCardDataSource.activities
import com.example.mycity.ui.theme.Activity
import com.example.mycity.ui.theme.CityViewModel
import com.example.mycity.ui.theme.onNodeWithStringId
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

annotation class TestCompactWidth
annotation class TestMediumWidth
annotation class TestExpandedWidth

private lateinit var navController: TestNavHostController
private var viewModel = CityViewModel()
private var windowSize = WindowSizeClass

class CityScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    fun setWindowWidthSizeCompact() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            CityApp(navController = navController, windowSize = WindowWidthSizeClass.Compact)
        }
    }

    fun setWindowWidthSizeMedium() {
        composeTestRule.setContent {
            CityApp(navController = navController, windowSize = WindowWidthSizeClass.Medium)
        }
    }

    fun setWindowWidthSizeExpanded() {
        composeTestRule.setContent {
            CityApp(navController = navController, windowSize = WindowWidthSizeClass.Expanded)
        }
    }

    @Test
    @TestCompactWidth
    fun compactCityNavHost_verifyStartDestination() {
        setWindowWidthSizeCompact()
        assertEquals(viewModel.uiState.value.titleAppBar, CityScreen.Start.name)
    }

    @Test
    @TestMediumWidth
    fun mediumCityNavHost_verifyStartDestination() {
        setWindowWidthSizeMedium()
        //navController.setCurrentDestination(CityScreen.Start.name)
    }

    @Test
    @TestExpandedWidth
    fun expandedCityNavHost_verifyStartDestination() {
        setWindowWidthSizeExpanded()
        //navController.setCurrentDestination(CityScreen.Start.name)
    }

    @Test
    fun cupcakeNavHost_verifyBackNavigationNotShownOnStartOrderScreen() {
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).assertDoesNotExist()
    }

    @Test
    fun cityNavHost_verifyBackNavigationShownOnCategoryScreen() {
        setWindowWidthSizeCompact()
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithTag("START")
            .performClick()
        composeTestRule.onNodeWithContentDescription(backText).assertIsDisplayed()
    }

    @Test
    fun cityNavHost_clickStart_navigatesToSelectCategoryScreen() {
        setWindowWidthSizeCompact()
        composeTestRule.onNodeWithTag("START")
            .performClick()
        composeTestRule.onNodeWithStringId(R.string.shopping_centers)
            .performClick()
        //composeTestRule.onNodeWithContentDescription(viewModel.uiState.value.titleAppBar).assertIsDisplayed()
        //assertEquals(R.string.shopping_centers, viewModel.uiState.value.titleAppBar)
    }

    //Rewatch
    @Test
    fun cityNavHost_clickShopping_navigatesToSelectShoppingCardScreen() {
        setWindowWidthSizeCompact()
        composeTestRule.onNodeWithTag("START")
            .performClick()
        composeTestRule.onNodeWithStringId(R.string.shopping_centers)
            .performClick()
        /*composeTestRule.onNodeWithStringId(R.string.information_card)
            .performClick()
        composeTestRule.onNodeWithStringId(R.string.details_Card)
            .performClick()*/
        composeTestRule.onNodeWithTag("CARD")
            .performClick()
        //assertEquals(R.string.select_Card, viewModel.uiState.value.titleAppBar)
        //navController.setCurrentDestination(CityScreen.Shopping.name)
    }
}