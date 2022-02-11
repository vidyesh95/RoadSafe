package com.vinitchuri.roadsafe.feature_roadsafe.presentation.music

import android.content.res.Configuration
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.music.component.MusicScreenPagerItem
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.util.repository.MusicScreenPagerRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@ExperimentalPagerApi
@Composable
fun MusicScreen() {
    val pagerState: PagerState = rememberPagerState()
    val musicScreenPagerRepository = MusicScreenPagerRepository()
    val getAllData = musicScreenPagerRepository.getAllData()
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        if (maxWidth < maxHeight) {
            Surface(color = MaterialTheme.colorScheme.background) {
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
        } else {
            Surface(color = MaterialTheme.colorScheme.background) {

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