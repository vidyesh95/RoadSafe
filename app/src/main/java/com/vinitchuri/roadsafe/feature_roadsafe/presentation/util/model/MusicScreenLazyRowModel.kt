package com.vinitchuri.roadsafe.feature_roadsafe.presentation.util.model

import androidx.annotation.DrawableRes

data class MusicScreenLazyRowModel(
    @DrawableRes val painterInt: Int,
    val contentDescription: String,
    val musicText: String,
    val artistText: String
)
