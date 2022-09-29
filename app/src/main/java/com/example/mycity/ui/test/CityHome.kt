package com.example.mycity.ui.test

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.R

@Composable
fun CityHome(onNextButtonClicked: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Image(
            painter = painterResource(id = R.drawable.stemma_caserta),
            contentDescription = null,
            modifier = Modifier.width(150.dp)
        )
        Text(text = stringResource(R.string.name_city), style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(120.dp))
        CityButton(
            onClick = onNextButtonClicked
        )
    }
}

@Composable
fun CityButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = 250.dp).testTag("START")
        //.background(MaterialTheme.colorScheme.background)
    ) {
        Text("Start", style = MaterialTheme.typography.titleMedium)
    }
}

/*@Composable
fun CityButtonGit(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = 250.dp).testTag("START")
        //.background(MaterialTheme.colorScheme.background)
    ) {
        Text("https://github.com/Apocalixs-Nick", style = MaterialTheme.typography.titleMedium)
    }
}*/

@Preview
@Composable
fun CityHomePreview() {
    CityHome(onNextButtonClicked = {})
}