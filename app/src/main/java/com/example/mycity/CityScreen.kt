package com.example.mycity

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.data.CategoryDataSource.category_title
import com.example.mycity.ui.test.*
import com.example.mycity.ui.test.utils.CityContentnType
import com.example.mycity.CityAppAppBar as CityAppAppBar

enum class CityScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Categories(title = R.string.category),
    SelectCard(title = R.string.select_Card),
    Coffe(title = R.string.coffe_shops),
    Restaurants(title = R.string.restaurants),
    Kid(title = R.string.kid_friendly),
    Parks(title = R.string.parks),
    Shopping(title = R.string.shopping_centers),
    DetailsCard(title = R.string.select_Card),
    InformationCard(title = R.string.information_card),
    Transport(title = R.string.transport)
}

//App Bar function
@Composable
fun CityAppAppBar(
    currentScreenTitle: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colorScheme.onPrimary, //colors.secondaryVariant,
        title = { Text(currentScreenTitle, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onBackground) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

//City App function
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    viewModel: CityViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val uiState by viewModel.uiState.collectAsState()
    val currentScreen = CityScreen.valueOf(
        backStackEntry?.destination?.route ?: CityScreen.Start.name
    )
    var remeberPage by remember {
        mutableStateOf(viewModel)
    }
    var title_card =
        if (stringResource(id = currentScreen.title) == CityScreen.SelectCard.name) uiState.titleAppBar
        else stringResource(
            id = currentScreen.title
        )
    /*val contentType: CityContentnType
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            contentType = CityContentnType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            contentType = CityContentnType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded -> {
            contentType = CityContentnType.LIST_AND_DETAIL
        }
        else -> {
            contentType = CityContentnType.LIST_ONLY
        }
    }*/

    Scaffold(
        topBar = {
            //Calling the function CityAppAppBar
            CityAppAppBar(
                currentScreenTitle = title_card,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },
    )
    { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = CityScreen.Start.name,
            modifier = modifier.padding(innerPadding)
        ) {
            //Composable leading to the home screen
            composable(route = CityScreen.Start.name) {
                //Calling the function CityHome
                CityHome(
                    onNextButtonClicked = { navController.navigate(CityScreen.Categories.name) }
                )
            }
            //Composable that leads to the category screen (starting from the home screen)
            composable(route = CityScreen.Categories.name) {
                //Calling the function SelectCategory
                SelectCategory(
                    categoryTitleList = category_title,
                    onNextButtonClicked = {
                        viewModel.updateCategorySelected(it)
                        viewModel.updateTitleAppBar(it)
                        navController.navigate(CityScreen.SelectCard.name)
                    }
                )
            }
            //Composable that leads to the card screen of the chosen category (starting from the category screen)
            composable(route = CityScreen.SelectCard.name) {
                //Calling the function SelectCard
                SelectCard(
                    title_card = title_card,
                    onCardClicked = {
                        viewModel.updateActivitiesDetailsCard(it)
                        //viewModel.updateTitleAppBar(it.Title)
                        navController.navigate(CityScreen.DetailsCard.name)

                    }
                )
            }
            //Composable that leads to the detail screen of the chosen card (starting from the card screen of a category)
            composable(route = CityScreen.DetailsCard.name) {
                uiState.detailsCard?.let { item ->
                    //Calling the function DetailsCard
                    DetailsCard(
                        Activity = item,
                        modifier = modifier
                    )
                }
            }
        }
    }
}