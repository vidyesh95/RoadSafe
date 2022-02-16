package com.vinitchuri.roadsafe.feature_roadsafe.presentation.music

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.vinitchuri.roadsafe.R
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.music.component.MusicScreenLazyRowItem
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.music.component.MusicScreenPagerItem
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.util.repository.MusicScreenLazyRowRepository
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.util.repository.MusicScreenPagerRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@ExperimentalPagerApi
@Composable
fun MusicScreen() {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        if (maxWidth < maxHeight) {
            Surface(color = MaterialTheme.colorScheme.background) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()) {
                    //Banner()
                    MusicScreenLazyColumn()
                }
            }
        } else {
            Surface(color = MaterialTheme.colorScheme.background) {
                MusicScreenLazyColumn()
            }
        }
    }
}

@ExperimentalMaterial3Api
@ExperimentalPagerApi
@Composable
fun MusicScreenLazyColumn() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        item {
            NavButtons()
        }
        item {
            MusicRow()
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun MusicRow() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Based on your activity",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "ArrowRight",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
        MusicScreenLazyRow()
    }
}

@ExperimentalMaterial3Api
@Composable
fun MusicScreenLazyRow() {
    val musicScreenLazyRowRepository = MusicScreenLazyRowRepository()
    val getAllData = musicScreenLazyRowRepository.getAllData()
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        item {
            Spacer(
                modifier = Modifier
                    .width(width = 8.dp)
                    .wrapContentHeight()
            )
        }
        items(items = getAllData) { music ->
            MusicScreenLazyRowItem(musicScreenLazyRowModel = music)
        }
        item {
            Spacer(
                modifier = Modifier
                    .width(width = 8.dp)
                    .wrapContentHeight()
            )
        }
    }
}

@Composable
fun NavButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_genre),
                contentDescription = ""
            )
            Text(text = "Genre", modifier = Modifier.padding(top = 4.dp))
        }
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_new),
                contentDescription = ""
            )
            Text(text = "Daily", modifier = Modifier.padding(top = 4.dp))
        }
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_favorite),
                contentDescription = ""
            )
            Text(text = "Favorite", modifier = Modifier.padding(top = 4.dp))
        }
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_popular),
                contentDescription = ""
            )
            Text(text = "Ranking", modifier = Modifier.padding(top = 4.dp))
        }
    }
}

@ExperimentalMaterial3Api
@ExperimentalPagerApi
@Composable
fun Banner() {
    val pagerState: PagerState = rememberPagerState()
    val musicScreenPagerRepository = MusicScreenPagerRepository()
    val getAllData = musicScreenPagerRepository.getAllData()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(4 / 3f),
        contentAlignment = Alignment.BottomCenter
    ) {
        HorizontalPager(count = getAllData.size, state = pagerState) { page ->
            MusicScreenPagerItem(musicScreenPagerModel = getAllData[page])
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier.padding(all = 16.dp),
            activeColor = MaterialTheme.colorScheme.primaryContainer,
            inactiveColor = MaterialTheme.colorScheme.secondary
        )
        LaunchedEffect(key1 = pagerState.currentPage) {
            launch {
                delay(3000)
                with(pagerState) {
                    val target = if (currentPage < pageCount - 1) currentPage + 1 else 0
                    animateScrollToPage(page = target)
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@ExperimentalPagerApi
@Preview(
    showBackground = true, name = "Light mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
/*@Preview(
    name = "Light mode - Tablet",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:pixel_c"
)*/
@Composable
fun MusicScreenPreview() {
    MusicScreen()
}