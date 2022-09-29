package com.example.mycity.ui.test

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.mycity.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.example.mycity.data.ActivitiesCardDataSource.activities
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SelectCard(
    title_card: String,
    onBackButtonClicked: () -> Unit = {},
    onCardClicked: (Activity) -> Unit = {}
) {
    val activitiesCategory = activities.filter { stringResource(id = it.category) == title_card }
    HorizontalPager(
        count = activitiesCategory.size,
        contentPadding = PaddingValues(horizontal = 80.dp),
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxHeight()
            .fillMaxWidth()
    ) { page ->
        Card(
            onClick = { onCardClicked(activitiesCategory[page]) },
            modifier = Modifier
                .width(350.dp).testTag("CARD")
                .height(300.dp)
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                },
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            shape = MaterialTheme.shapes.large
        ) {
            activitiesCard(
                Activity = activitiesCategory[page]
            )
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun activitiesCard(
    Activity: Activity
) {
        Card(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                //.height(200.dp)
                //.width(250.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp),
            elevation = 20.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(bottom = 10.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(top = 5.dp))
                Text(text = Activity.Title, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.background)
                Spacer(modifier = Modifier.padding(bottom = 5.dp))
                Image(
                    painter = painterResource(id = Activity.Image),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.padding(top = 5.dp))
                Image(
                    painter = painterResource(id = R.drawable.icons8_indirizzo_50),
                    contentDescription = null,
                )
                Text(
                    text = Activity.address,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.background
                )
            }
        }
}