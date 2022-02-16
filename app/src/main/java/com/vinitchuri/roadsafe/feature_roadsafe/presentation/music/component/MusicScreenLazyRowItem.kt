package com.vinitchuri.roadsafe.feature_roadsafe.presentation.music.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.util.model.MusicScreenLazyRowModel

@ExperimentalMaterial3Api
@Composable
fun MusicScreenLazyRowItem(musicScreenLazyRowModel: MusicScreenLazyRowModel) {
    Column(modifier = Modifier.wrapContentSize()) {
        Card(
            modifier = Modifier
                .height(height = 120.dp)
                .width(width = 120.dp)
                .padding(all = 8.dp),
            shape = RoundedCornerShape(size = 16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
        ) {
            Image(
                painter = painterResource(id = musicScreenLazyRowModel.painterInt),
                contentDescription = musicScreenLazyRowModel.contentDescription,
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = musicScreenLazyRowModel.musicText,
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis,
            softWrap = true,
            maxLines = 2,
            modifier = Modifier
                .wrapContentHeight()
                .width(120.dp)
                .padding(horizontal = 8.dp),
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = musicScreenLazyRowModel.artistText,
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis,
            softWrap = true,
            maxLines = 2,
            modifier = Modifier
                .wrapContentHeight()
                .width(120.dp)
                .padding(horizontal = 8.dp),
            style = MaterialTheme.typography.labelMedium
        )
    }
}