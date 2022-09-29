package com.example.mycity.ui.test

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import androidx.compose.foundation.layout.Spacer as Spacer

@Composable
fun DetailsCard(
    Activity: Activity,
    modifier: Modifier
) {
    var uiSettings by remember { mutableStateOf(MapUiSettings()) }
    var properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.SATELLITE))
    }
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
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(id = Activity.Image), contentDescription = null)
            Spacer(modifier = Modifier.padding(top = 5.dp))
            Text(
                text = Activity.Title,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.padding(top = 2.dp))
            Text(
                text = Activity.Description,
                style = MaterialTheme.typography.titleMedium
            )

        }
        val positionCardElement = LatLng(Activity.latitude, Activity.longitude)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(positionCardElement, 12f)
        }
        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(position = positionCardElement),
                title = Activity.Title,
                //snippet = "Marker in " + Activity.Title
            )
        }

        Box(Modifier.fillMaxSize()) {
            GoogleMap(
                modifier = Modifier.matchParentSize(),
                properties = properties,
                uiSettings = uiSettings
            )
            /*Switch(
                checked = uiSettings.zoomControlsEnabled,
                onCheckedChange = {
                    uiSettings = uiSettings.copy(zoomControlsEnabled = it)
                }
            )*/
        }

        val intentContext = LocalContext.current
        ShareDetailsCard(
            Activity = Activity(Activity.Title,Activity.Image,Activity.Description,Activity.category,Activity.address,Activity.latitude,Activity.longitude,Activity.link),
            onShareButtonClicked = {
                shareCityCardInformation(
                    intentContext = intentContext,
                    Activity = Activity(Activity.Title,Activity.Image,Activity.Description,Activity.category,Activity.address,Activity.latitude,Activity.longitude,Activity.link)
                )
            }
        )
    }
}

@Composable
fun ShareDetailsCard(
    onShareButtonClicked: () -> Unit,
    Activity: Activity,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Spacer(modifier = Modifier.height(1.dp))
            Button(
                colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.background, backgroundColor = MaterialTheme.colorScheme.primary),
                onClick = onShareButtonClicked,
                shape = RoundedCornerShape(50,50,50,50),
                modifier = modifier
                    .padding(20.dp)
                    .width(400.dp)
                    .height(50.dp),
                //.background(MaterialTheme.colorScheme.background)
            ) {
                Text(text = "Share position " + Activity.Title, style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.background)
            }
    }
}

@SuppressLint("ResourceType")
private fun shareCityCardInformation(intentContext: Context,Activity: Activity) {
    val sendIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(
            Intent.EXTRA_TEXT,
            ("Hello! Look at this place:\n" + Activity.link + "\nfrom the My City app by Nicola Piccirillo.\n" + "For other jobs, visit https://github.com/Apocalixs-Nick")
        )
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent, null)

    try {
        ContextCompat.startActivity(intentContext, shareIntent, null)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(
            intentContext,
            ("ERROR"),
            Toast.LENGTH_LONG
        ).show()
    }
}