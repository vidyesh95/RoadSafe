package com.vinitchuri.roadsafe.feature_roadsafe.presentation.home

import android.Manifest
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Layers
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.vinitchuri.roadsafe.BuildConfig
import com.vinitchuri.roadsafe.R

@ExperimentalMaterial3Api
@ExperimentalPagerApi
@ExperimentalPermissionsApi
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
                        MapScreenElements()
                    }
                    CameraScreen()
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

@ExperimentalMaterial3Api
@ExperimentalPermissionsApi
@Composable
fun CameraScreen() {
    Box(
        modifier = Modifier
            .aspectRatio(16 / 9f)
    ) {
        CameraPermission()
    }
}

@ExperimentalMaterial3Api
@ExperimentalPermissionsApi
@Composable
fun MapScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ) {
        MapScreenElements()
    }
}

@ExperimentalMaterial3Api
@ExperimentalPermissionsApi
@Composable
fun MapScreenElements() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.End
    ) {
        SmallFloatingActionButton(
            onClick = {},
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
            shape = RoundedCornerShape(percent = 50)
        ) {
            Icon(imageVector = Icons.Outlined.Layers, contentDescription = "Map type")
        }
        SmallFloatingActionButton(
            onClick = {},
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
            shape = RoundedCornerShape(percent = 50)
        ) {
            Icon(imageVector = Icons.Default.Explore, contentDescription = "North")
        }
        FloatingActionButton(
            onClick = {},
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            shape = RoundedCornerShape(percent = 50)
        ) {
            Icon(imageVector = Icons.Default.MyLocation, contentDescription = "Location")
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(all = 16.dp),
            shape = RoundedCornerShape(percent = 50),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.search),
                    modifier = Modifier.padding(all = 16.dp)
                )
                Text(text = "Search for destination")
            }
        }
    }
}

@Composable
fun CameraUi() {
    Box(modifier = Modifier.fillMaxSize()) {

    }
}

@ExperimentalMaterial3Api
@ExperimentalPermissionsApi
@Composable
fun CameraPermission() {
    /* Camera permission state.*/
    val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

    val context = LocalContext.current
    val intent = Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", BuildConfig.APPLICATION_ID, null)
    )

    when (cameraPermissionState.status) {

        /* If the camera permission is granted, then show screen with the feature enabled.*/
        PermissionStatus.Granted -> {
            CameraUi()
        }

        is PermissionStatus.Denied -> {
            /*
            * This is a rationale explaining why we need the camera permission.
            * We are displaying this because the user has denied the permission once.
            * */
            if (cameraPermissionState.status.shouldShowRationale) {
                /*
                * If the user has denied the permission but the rationale can be shown, then gently
                * explain why the app requires this permission
                * */
                Column {
                    Text(text = "The camera is important for this app. Please grant the permission.")
                    Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
                        Text("Grant permission")
                    }
                }
            } else {
                /*
                * If it's the first time the user lands on this feature, or the user doesn't want to
                * be asked again for this permission, explain that the permission is required
                * */
                Column {
                    Text(text = "Camera permission required for this feature to be available. Please grant the permission")
                    Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
                        Text("Grant permission")
                    }

                    Text(text = "Camera permission denied twice. Please grant the permission. Set allow while using this app or allow all the time according to your requirement.")
                    Button(
                        onClick = {
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            context.startActivity(intent)
                        }
                    ) {
                        Text("Open settings to grant permission.")
                    }
                }
            }
        }
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
@ExperimentalPermissionsApi
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}