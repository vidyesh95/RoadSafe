package com.vinitchuri.roadsafe.feature_roadsafe.presentation.home

import android.content.ContentValues.TAG
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.Switch
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import kotlinx.coroutines.launch

private const val TAG = "MapSampleActivity"

@ExperimentalMaterial3Api
@ExperimentalPagerApi
@Composable
fun HomeScreen() {
    val pagerState: PagerState = rememberPagerState()
    //var isMapLoaded by remember { mutableStateOf(false) }
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        if (maxWidth < maxHeight) {
            Surface(
                color = MaterialTheme.colorScheme.background
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        /*GoogleMapView(
                            modifier = Modifier.matchParentSize(),
                            onMapLoaded = {
                                isMapLoaded = true
                            }
                        )
                        if (!isMapLoaded) {
                            this@Column.AnimatedVisibility(
                                modifier = Modifier
                                    .matchParentSize(),
                                visible = !isMapLoaded,
                                enter = EnterTransition.None,
                                exit = fadeOut()
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .background(MaterialTheme.colorScheme.background)
                                        .wrapContentSize()
                                )
                            }
                        }*/
                    }
                    Box(
                        modifier = Modifier
                            .aspectRatio(16 / 9f)
                            .background(color = Color.Magenta)
                    ) {

                    }
                }
            }
        } else {
            Surface(
                color = MaterialTheme.colorScheme.background
            ) {
                HorizontalPager(count = 2, state = pagerState) { page ->
                    when (page) {
                        0 -> CameraScreen()
                        1 -> MapScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun CameraScreen() {
    Box(
        modifier = Modifier
            .aspectRatio(16 / 9f)
            .background(color = Color.Green)
    ) {

    }
}

@Composable
fun MapScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue)
    ) {

    }
}

@Composable
private fun GoogleMapView(modifier: Modifier, onMapLoaded: () -> Unit) {
    val singapore = LatLng(1.35, 103.87)
    // Observing and controlling the camera's state can be done with a CameraPositionState
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 11f)
    }

    var mapProperties by remember {
        mutableStateOf(MapProperties(mapType = MapType.NORMAL))
    }
    var uiSettings by remember { mutableStateOf(MapUiSettings(compassEnabled = false)) }
    var shouldAnimateZoom by remember { mutableStateOf(true) }
    var ticker by remember { mutableStateOf(0) }

    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState,
        properties = mapProperties,
        uiSettings = uiSettings,
        onMapLoaded = onMapLoaded,
        googleMapOptionsFactory = {
            GoogleMapOptions().camera(CameraPosition.fromLatLngZoom(singapore, 11f))
        },
        onPOIClick = {
            Log.d(TAG, "POI clicked: ${it.name}")
        }
    ) {
        // Drawing on the map is accomplished with a child-based API
        Marker(
            position = singapore,
            title = "Zoom in has been tapped $ticker times.",
            onClick = {
                println("${it.title} was clicked")
                false
            }
        )
        Circle(
            center = singapore,
            fillColor = MaterialTheme.colorScheme.secondary,
            strokeColor = MaterialTheme.colorScheme.secondaryContainer,
            radius = 1000.0,
        )
    }

    Column {
        MapTypeControls(onMapTypeClick = {
            Log.d("GoogleMap", "Selected map type $it")
            mapProperties = mapProperties.copy(mapType = it)
        })
        val coroutineScope = rememberCoroutineScope()
        ZoomControls(
            shouldAnimateZoom,
            uiSettings.zoomControlsEnabled,
            onZoomOut = {
                if (shouldAnimateZoom) {
                    coroutineScope.launch {
                        cameraPositionState.animate(CameraUpdateFactory.zoomOut())
                    }
                } else {
                    cameraPositionState.move(CameraUpdateFactory.zoomOut())
                }
            },
            onZoomIn = {
                if (shouldAnimateZoom) {
                    coroutineScope.launch {
                        cameraPositionState.animate(CameraUpdateFactory.zoomIn())
                    }
                } else {
                    cameraPositionState.move(CameraUpdateFactory.zoomIn())
                }
                ticker++
            },
            onCameraAnimationCheckedChange = {
                shouldAnimateZoom = it
            },
            onZoomControlsCheckedChange = {
                uiSettings = uiSettings.copy(zoomControlsEnabled = it)
            }
        )
        DebugView(cameraPositionState)
    }
}

@Composable
private fun MapTypeControls(
    onMapTypeClick: (MapType) -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .horizontalScroll(state = ScrollState(0)),
        horizontalArrangement = Arrangement.Center
    ) {
        MapType.values().forEach {
            MapTypeButton(type = it) { onMapTypeClick(it) }
        }
    }
}

@Composable
private fun MapTypeButton(type: MapType, onClick: () -> Unit) {
    Button(
        modifier = Modifier.padding(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
            contentColor = MaterialTheme.colorScheme.primary
        ),
        onClick = onClick
    ) {
        Text(text = type.toString(), style = MaterialTheme.typography.labelMedium)
    }
}

@Composable
private fun ZoomControls(
    isCameraAnimationChecked: Boolean,
    isZoomControlsEnabledChecked: Boolean,
    onZoomOut: () -> Unit,
    onZoomIn: () -> Unit,
    onCameraAnimationCheckedChange: (Boolean) -> Unit,
    onZoomControlsCheckedChange: (Boolean) -> Unit,
) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        MapButton("-", onClick = { onZoomOut() })
        MapButton("+", onClick = { onZoomIn() })
        Column(verticalArrangement = Arrangement.Center) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text(text = "Camera Animations On?")
                Switch(isCameraAnimationChecked, onCheckedChange = onCameraAnimationCheckedChange)
            }
            Row(horizontalArrangement = Arrangement.Center) {
                Text(text = "Zoom Controls On?")
                Switch(isZoomControlsEnabledChecked, onCheckedChange = onZoomControlsCheckedChange)
            }
        }
    }
}

@Composable
private fun MapButton(text: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier.padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
            contentColor = MaterialTheme.colorScheme.primary
        ),
        onClick = onClick
    ) {
        Text(text = text, style = MaterialTheme.typography.labelMedium)
    }
}

@Composable
private fun DebugView(cameraPositionState: CameraPositionState) {
    Column(
        Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        val moving = if (cameraPositionState.isMoving) "moving" else "not moving"
        Text(text = "Camera is $moving")
        Text(text = "Camera position is ${cameraPositionState.position}")
    }
}

@Preview(
    name = "Day mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(
    name = "Light mode - Tablet",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:pixel_c"
)
@ExperimentalMaterial3Api
@ExperimentalPagerApi
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}