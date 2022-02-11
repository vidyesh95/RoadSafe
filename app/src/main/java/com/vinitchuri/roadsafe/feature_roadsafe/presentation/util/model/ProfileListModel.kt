package com.vinitchuri.roadsafe.feature_roadsafe.presentation.util.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class ProfileListModel(
    val imageVector: ImageVector,
    @StringRes val contentDescription: Int,
    @StringRes val text: Int
)
