package com.vinitchuri.roadsafe.feature_roadsafe.presentation.profile.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.util.model.ProfileListModel

@Composable
fun ProfileListItem(profileListModel: ProfileListModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(
                onClick = {
                    /*todo("perform different actions based upon item clicked")*/
                }
            )
            /*.clickable { selectedItem(profileListModel) }*/
            .padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = profileListModel.imageVector,
            contentDescription = stringResource(id = profileListModel.contentDescription),
            tint = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(end = 16.dp)
        )
        Text(
            modifier = Modifier.wrapContentSize(),
            text = stringResource(id = profileListModel.text)
        )
    }
}