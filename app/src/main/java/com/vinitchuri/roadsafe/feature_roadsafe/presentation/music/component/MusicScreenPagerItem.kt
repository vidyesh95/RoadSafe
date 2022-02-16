package com.vinitchuri.roadsafe.feature_roadsafe.presentation.music.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.util.model.MusicScreenPagerModel

@ExperimentalMaterial3Api
@Composable
fun MusicScreenPagerItem(musicScreenPagerModel: MusicScreenPagerModel) {
    Card(
        modifier = Modifier
            .fillMaxSize(),
        interactionSource = null,
        shape = RoundedCornerShape(size = 0.dp),
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Image(
            painter = painterResource(id = musicScreenPagerModel.painterInt),
            contentDescription = musicScreenPagerModel.contentDescription,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

/*
class MusicScreenPagerProvider : PreviewParameterProvider<MusicScreenPagerModel> {
    override val values = sequenceOf(
        MusicScreenPagerModel(
            painterInt = R.drawable.pager1,
            contentDescription = ""
        ),
        MusicScreenPagerModel(
            painterInt = R.drawable.pager2,
            contentDescription = ""
        ),
        MusicScreenPagerModel(
            painterInt = R.drawable.pager3,
            contentDescription = ""
        ),
        MusicScreenPagerModel(
            painterInt = R.drawable.pager4,
            contentDescription = ""
        ),
        MusicScreenPagerModel(
            painterInt = R.drawable.pager5,
            contentDescription = ""
        ),
        MusicScreenPagerModel(
            painterInt = R.drawable.pager6,
            contentDescription = ""
        ),
        MusicScreenPagerModel(
            painterInt = R.drawable.pager7,
            contentDescription = ""
        )
    )
}

@ExperimentalMaterial3Api
@Preview(
    showBackground = true, name = "Light mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(
    showBackground = true, name = "Night mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun MusicScreenPagerItemPreview(@PreviewParameter(MusicScreenPagerProvider::class) musicScreenPagerModel: MusicScreenPagerModel) {
    MusicScreenPagerItem(musicScreenPagerModel)
}*/
