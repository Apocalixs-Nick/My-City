package com.example.mycity.ui.test
//https://console.cloud.google.com/
//https://developers.google.com/maps/documentation/android-sdk
import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

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
                modifier = Modifier.background(MaterialTheme.colorScheme.background),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.background, backgroundColor = MaterialTheme.colorScheme.primary),
                    modifier = modifier
                        .padding(20.dp)
                        .width(250.dp)
                        .height(50.dp),
                    onClick = { onNextButtonClicked(Stringitem) },
                shape = RoundedCornerShape(50,50,50,50)
                ) {
                    //
                    Text(Stringitem, style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    }
}