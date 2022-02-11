package com.vinitchuri.roadsafe.feature_roadsafe.presentation.profile

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vinitchuri.roadsafe.R
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.profile.component.ProfileListItem
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.util.repository.ProfileListRepository

@ExperimentalMaterial3Api
@Composable
fun ProfileScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Surface(color = MaterialTheme.colorScheme.background) {
            ProfileList()
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun ProfileList() {
    val profileListRepository = ProfileListRepository()
    val getAllData = profileListRepository.getAllData()
    LazyColumn() {
        item {
            ProfileCard()
        }
        items(items = getAllData) { profileListModel ->
            ProfileListItem(profileListModel = profileListModel)
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun ProfileCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(all = 16.dp),
        shape = RoundedCornerShape(size = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier.padding(all = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "Username")
                    Text(text = "Lv1")
                    Text(text = "Prime active")
                }
                Image(
                    painter = painterResource(id = R.drawable.bill),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(size = 72.dp)
                        .clip(shape = CircleShape)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(1f)
                ) {
                    Text(text = "1020")
                    Text(text = "Social reputation")
                }
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(1f)
                ) {
                    Text(text = "1010", modifier = Modifier.fillMaxWidth())
                    Text(text = "Credit score", modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(
    showBackground = true, name = "Light mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(
    showBackground = true, name = "Night mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}