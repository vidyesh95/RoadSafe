package com.vinitchuri.roadsafe.feature_roadsafe.presentation.util.repository

import com.vinitchuri.roadsafe.R
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.util.model.MusicScreenPagerModel

class MusicScreenPagerRepository {
    fun getAllData(): List<MusicScreenPagerModel> {
        return listOf(
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
}