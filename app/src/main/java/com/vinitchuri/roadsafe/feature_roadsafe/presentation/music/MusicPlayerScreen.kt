package com.vinitchuri.roadsafe.feature_roadsafe.presentation.music

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vinitchuri.roadsafe.R

@ExperimentalMaterial3Api
@Composable
fun MusicPlayerScreen() {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        if (maxWidth < maxHeight) {
            Surface(color = MaterialTheme.colorScheme.background) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(all = 16.dp)
                                .height(24.dp)
                                .width(24.dp),
                            imageVector = Icons.Default.ExpandMore,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.outline
                        )
                        Row {
                            Icon(
                                modifier = Modifier
                                    .padding(all = 16.dp)
                                    .height(24.dp)
                                    .width(24.dp),
                                imageVector = Icons.Default.Share,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.outline
                            )
                            Icon(
                                modifier = Modifier
                                    .padding(all = 16.dp)
                                    .height(24.dp)
                                    .width(24.dp),
                                imageVector = Icons.Default.MusicNote,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.outline
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp)
                            .aspectRatio(1f)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.song9420),
                            contentScale = ContentScale.Crop,
                            contentDescription = ""
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height = 48.dp)
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 16.dp),
                        text = "9420",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 16.dp),
                        text = "Mai Xiao Dou (麦小兜)",
                        color = MaterialTheme.colorScheme.outline,
                        textAlign = TextAlign.Center
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height = 48.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp),
                            imageVector = Icons.Default.Shuffle,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.outline
                        )
                        Icon(
                            modifier = Modifier
                                .height(40.dp)
                                .width(40.dp),
                            imageVector = Icons.Default.SkipPrevious,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Icon(
                            modifier = Modifier
                                .height(80.dp)
                                .width(80.dp),
                            imageVector = Icons.Default.PlayCircle,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Icon(
                            modifier = Modifier
                                .height(40.dp)
                                .width(40.dp),
                            imageVector = Icons.Default.SkipNext,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Icon(
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp),
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.outline
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height = 48.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp),
                            imageVector = Icons.Default.FileDownload,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.outline
                        )
                        Icon(
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp),
                            imageVector = Icons.Default.Chat,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.outline
                        )
                        Icon(
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp),
                            imageVector = Icons.Default.QueueMusic,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.outline
                        )
                        Icon(
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp),
                            imageVector = Icons.Default.MoreHoriz,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.outline
                        )
                    }
                }
            }
        } else {
            Surface(color = MaterialTheme.colorScheme.background) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(all = 16.dp)
                                .height(24.dp)
                                .width(24.dp),
                            imageVector = Icons.Default.ExpandMore,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.outline
                        )
                        Row {
                            Icon(
                                modifier = Modifier
                                    .padding(all = 16.dp)
                                    .height(24.dp)
                                    .width(24.dp),
                                imageVector = Icons.Default.Share,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.outline
                            )
                            Icon(
                                modifier = Modifier
                                    .padding(all = 16.dp)
                                    .height(24.dp)
                                    .width(24.dp),
                                imageVector = Icons.Default.MusicNote,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.outline
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 56.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .fillMaxHeight()
                                .aspectRatio(1f)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.song9420),
                                contentScale = ContentScale.Crop,
                                contentDescription = ""
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 56.dp),
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                                    .padding(horizontal = 16.dp),
                                text = "9420",
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                                    .padding(horizontal = 16.dp),
                                text = "Mai Xiao Dou (麦小兜)",
                                color = MaterialTheme.colorScheme.outline,
                                textAlign = TextAlign.Center
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                                    .padding(horizontal = 16.dp),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .height(24.dp)
                                        .width(24.dp),
                                    imageVector = Icons.Default.Shuffle,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.outline
                                )
                                Icon(
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(40.dp),
                                    imageVector = Icons.Default.SkipPrevious,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Icon(
                                    modifier = Modifier
                                        .height(80.dp)
                                        .width(80.dp),
                                    imageVector = Icons.Default.PlayCircle,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Icon(
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(40.dp),
                                    imageVector = Icons.Default.SkipNext,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Icon(
                                    modifier = Modifier
                                        .height(24.dp)
                                        .width(24.dp),
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.outline
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight(),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .height(24.dp)
                                        .width(24.dp),
                                    imageVector = Icons.Default.FileDownload,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.outline
                                )
                                Icon(
                                    modifier = Modifier
                                        .height(24.dp)
                                        .width(24.dp),
                                    imageVector = Icons.Default.Chat,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.outline
                                )
                                Icon(
                                    modifier = Modifier
                                        .height(24.dp)
                                        .width(24.dp),
                                    imageVector = Icons.Default.QueueMusic,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.outline
                                )
                                Icon(
                                    modifier = Modifier
                                        .height(24.dp)
                                        .width(24.dp),
                                    imageVector = Icons.Default.MoreHoriz,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.outline
                                )
                            }
                        }
                    }
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
    name = "Light mode - Tablet",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:pixel_c"
)*/
@Composable
fun MusicPlayerScreenPreview() {
    MusicPlayerScreen()
}