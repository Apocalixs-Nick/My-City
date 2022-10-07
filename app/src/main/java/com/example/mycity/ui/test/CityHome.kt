package com.example.mycity.ui.test

import android.content.Context
import android.content.Intent
import android.media.MediaDrm
import android.net.Uri
import android.view.View
import android.widget.PopupWindow
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.isPopupLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.example.mycity.CityScreen
import com.example.mycity.R
import java.io.IOException
import java.security.AllPermission

//City Home function(first page)
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
        //Calling the function CityButton
        CityButton(
            onClick = onNextButtonClicked
        )
    }
}

//City Home Button function
@Composable
fun CityButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val url by remember {
        mutableStateOf("https://www.comune.caserta.it/")
    }
    val site = LocalContext.current
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse(url)
    Button(
        onClick = onClick,
        modifier = modifier
            .widthIn(min = 250.dp)
            .testTag("START")
        //.background(MaterialTheme.colorScheme.background)
    ) {
        Text("Start", style = MaterialTheme.typography.titleMedium)
    }
    Spacer(modifier = Modifier.height(45.dp))
    var catch: Exception? = null
    TextButton(
        {
            try {
                startActivity(site, intent, null)
            } catch (Exception: Exception) {
                catch = Exception
        }
        },
        modifier = modifier
            .widthIn(min = 250.dp)
        //.background(MaterialTheme.colorScheme.background)
    ) {
        Text("Town Hall site", style = MaterialTheme.typography.titleMedium)
    }

    catch?.let { AlertDialogSample(it) }
}

//City Home function(Preview)
@Preview
@Composable
fun CityHomePreview() {
    CityHome(onNextButtonClicked = {})
}