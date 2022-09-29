package com.example.mycity.ui.theme
//https://console.cloud.google.com/
//https://developers.google.com/maps/documentation/android-sdk
import android.annotation.SuppressLint
import android.icu.util.ULocale
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.navOptions
import java.util.*

@Composable
fun SelectCategory(
    categoryImageList: List<Int>,
    @StringRes categoryTitleList: List<Int>,
    onSelectionChanged: (String) -> Unit = {},
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }
    Column(modifier = modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(16.dp)
        .fillMaxWidth()
        .fillMaxHeight()
        .verticalScroll(rememberScrollState()),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        categoryTitleList.forEach { item ->
            val Stringitem = stringResource(id = item)
            //Image(painter = painterResource(id = categoryImageList[item]) , contentDescription = null)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    modifier = modifier
                        .padding(20.dp)
                        .width(200.dp)
                        .height(50.dp),
                    onClick = { onNextButtonClicked(Stringitem) }) {
                    //
                    Text(Stringitem, style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    }
}