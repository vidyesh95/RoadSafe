package com.vinitchuri.roadsafe.feature_roadsafe.presentation.profile

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Switch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ModeNight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        item {
            ProfileCard()
        }
        item {
            NightLight()
        }
        itemsIndexed(items = getAllData) { index, profileListModel ->
            ProfileListItem(profileListModel = profileListModel,)
        }
    }
}

@Composable
fun NightLight() {
    val checkedState = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(onClick = { checkedState.value = !checkedState.value })
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.wrapContentSize(), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.ModeNight,
                contentDescription = stringResource(id = R.string.night_light),
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                modifier = Modifier.wrapContentSize(),
                text = stringResource(id = R.string.night_light)
            )
        }
        Switch(checked = checkedState.value, onCheckedChange = { checkedState.value = it })
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
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Click to login")
                Image(
                    painter = painterResource(id = R.drawable.avatar),
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
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Level 0")
                Card(
                    modifier = Modifier.wrapContentSize(),
                    shape = RoundedCornerShape(size = 16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                ) {
                    Text(
                        text = "Check in",
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                    )
                }
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
                    Text(text = "0")
                    Text(text = "Social reputation")
                }
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(1f)
                ) {
                    Text(text = "0", modifier = Modifier.fillMaxWidth())
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
/*@Preview(
    showBackground = true, name = "Night mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)*/
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}