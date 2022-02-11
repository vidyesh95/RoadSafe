package com.vinitchuri.roadsafe.feature_roadsafe.presentation.util

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LibraryMusic
import androidx.compose.ui.graphics.vector.ImageVector
import com.vinitchuri.roadsafe.R

sealed class Screen(
    val route: String,
    @StringRes val label: Int,
    val icon_outlined: ImageVector,
    val icon_filled: ImageVector
) {
    object HomeScreen : Screen(
        route = "home_screen",
        label = R.string.home,
        icon_outlined = Icons.Outlined.Home,
        icon_filled = Icons.Filled.Home
    )

    object MusicScreen : Screen(
        route = "music_screen",
        label = R.string.music,
        icon_outlined = Icons.Outlined.LibraryMusic,
        icon_filled = Icons.Filled.LibraryMusic
    )

    object ProfileScreen : Screen(
        route = "profile_screen",
        label = R.string.profile,
        icon_outlined = Icons.Outlined.AccountCircle,
        icon_filled = Icons.Filled.AccountCircle
    )
}