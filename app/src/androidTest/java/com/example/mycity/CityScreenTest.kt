package com.example.mycity

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.mycity.ui.test.CityViewModel
import com.example.mycity.ui.test.onNodeWithStringId
import org.junit.Assert.assertEquals
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

    //Test device window settings
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

    //Test start-up screen with different window
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
        assertEquals(viewModel.uiState.value.titleAppBar, CityScreen.Start.name)
        //navController.setCurrentDestination(CityScreen.Start.name)
    }

    @Test
    @TestExpandedWidth
    fun expandedCityNavHost_verifyStartDestination() {
        setWindowWidthSizeExpanded()
        assertEquals(viewModel.uiState.value.titleAppBar, CityScreen.Start.name)
        //navController.setCurrentDestination(CityScreen.Start.name)
    }

    //Test operation of back navigation
    @Test
    fun cityNavHost_verifyBackNavigationNotShownOnStartOrderScreen() {
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).assertDoesNotExist()
    }

    //Back navigation operation test with different window
    @Test
    @TestCompactWidth
    fun compactCityNavHost_verifyBackNavigationShownOnCategoryScreen() {
        setWindowWidthSizeCompact()
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithTag("START")
            .performClick()
        composeTestRule.onNodeWithContentDescription(backText).assertIsDisplayed()
    }

    @Test
    @TestMediumWidth
    fun mediumCityNavHost_verifyBackNavigationShownOnCategoryScreen() {
        setWindowWidthSizeMedium()
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithTag("START")
            .performClick()
        composeTestRule.onNodeWithContentDescription(backText).assertIsDisplayed()
    }

    @Test
    @TestExpandedWidth
    fun expandedCityNavHost_verifyBackNavigationShownOnCategoryScreen() {
        setWindowWidthSizeExpanded()
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithTag("START")
            .performClick()
        composeTestRule.onNodeWithContentDescription(backText).assertIsDisplayed()
    }

    //Test navigation operation for category selection with different window
    @Test
    @TestCompactWidth
    fun compactCityNavHost_clickStart_navigatesToSelectCategoryScreen() {
        setWindowWidthSizeCompact()
        composeTestRule.onNodeWithTag("START")
            .performClick()
        composeTestRule.onNodeWithStringId(R.string.shopping_centers)
            .performClick()
        //composeTestRule.onNodeWithContentDescription(viewModel.uiState.value.titleAppBar).assertIsDisplayed()
        //assertEquals(R.string.shopping_centers, viewModel.uiState.value.titleAppBar)
    }

    @Test
    @TestMediumWidth
    fun mediumCityNavHost_clickStart_navigatesToSelectCategoryScreen() {
        setWindowWidthSizeMedium()
        composeTestRule.onNodeWithTag("START")
            .performClick()
        composeTestRule.onNodeWithStringId(R.string.shopping_centers)
            .performClick()
        //composeTestRule.onNodeWithContentDescription(viewModel.uiState.value.titleAppBar).assertIsDisplayed()
        //assertEquals(R.string.shopping_centers, viewModel.uiState.value.titleAppBar)
    }

    @Test
    @TestExpandedWidth
    fun expandedCityNavHost_clickStart_navigatesToSelectCategoryScreen() {
        setWindowWidthSizeExpanded()
        composeTestRule.onNodeWithTag("START")
            .performClick()
        composeTestRule.onNodeWithStringId(R.string.shopping_centers)
            .performClick()
        //composeTestRule.onNodeWithContentDescription(viewModel.uiState.value.titleAppBar).assertIsDisplayed()
        //assertEquals(R.string.shopping_centers, viewModel.uiState.value.titleAppBar)
    }

    //Rewatch
    /*@Test
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
    }*/
}