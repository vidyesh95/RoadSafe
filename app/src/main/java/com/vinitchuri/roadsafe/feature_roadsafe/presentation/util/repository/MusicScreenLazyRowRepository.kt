package com.vinitchuri.roadsafe.feature_roadsafe.presentation.util.repository

import com.vinitchuri.roadsafe.R
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.util.model.MusicScreenLazyRowModel

class MusicScreenLazyRowRepository {
    fun getAllData(): List<MusicScreenLazyRowModel> {
        return listOf(
            MusicScreenLazyRowModel(
                painterInt = R.drawable.song9420,
                contentDescription = "9420",
                musicText = "9420",
                artistText = "Mai Xiao Dou (麦小兜)"
            ),
            MusicScreenLazyRowModel(
                painterInt = R.drawable.ava_max,
                contentDescription = "Salt",
                musicText = "Salt",
                artistText = "Ava Max"
            ),
            MusicScreenLazyRowModel(
                painterInt = R.drawable.beautiful_piano_music,
                contentDescription = "What If I",
                musicText = "What If I",
                artistText = "Elysian Composer"
            ),
            MusicScreenLazyRowModel(
                painterInt = R.drawable.star_sky,
                contentDescription = "Star Sky",
                musicText = "Star Sky",
                artistText = "Two Steps From Hell"
            ),
            MusicScreenLazyRowModel(
                painterInt = R.drawable.pager4,
                contentDescription = "adffsd",
                musicText = "afds",
                artistText = "afdsf"
            ),
            MusicScreenLazyRowModel(
                painterInt = R.drawable.pager5,
                contentDescription = "adsffs",
                musicText = "adfssd",
                artistText = "afsd"
            ),
            MusicScreenLazyRowModel(
                painterInt = R.drawable.pager6,
                contentDescription = "adfsf",
                musicText = "afds",
                artistText = "asdf"
            ),
            MusicScreenLazyRowModel(
                painterInt = R.drawable.pager7,
                contentDescription = "adfs",
                musicText = "asfdf",
                artistText = "adsff"
            ),
            MusicScreenLazyRowModel(
                painterInt = R.drawable.music_cover,
                contentDescription = "asdff",
                musicText = "adfsf",
                artistText = "afdsfsd"
            )
        )
    }
}