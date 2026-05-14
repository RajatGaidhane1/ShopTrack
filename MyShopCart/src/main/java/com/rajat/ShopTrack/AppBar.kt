package com.rajat.myshopcart

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.rajat.ShopTrack.R
//import com.rajat.mywishlistapp.R

@Composable

fun AppBarView(
    title: String,
    onBackNavClicked: () -> Unit= {}       //This is the back button in an app (<-)
)
{
    val navigationIcon : (@Composable () -> Unit)? =
        if(!title.contains("Shopping list")){
            // Day 13, 209.
            {
                IconButton(onClick = { onBackNavClicked() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        tint = Color.White,
                        contentDescription = null
                    )
                }
            }
            }else{
                null
                }


    TopAppBar(title = {
        androidx.compose.material.Text(
            "Shopping List",
            color = colorResource(id = R.color.white),
            modifier = Modifier
                .padding(start = 4.dp)
                .heightIn(max = 24.dp)
        )
    },
        elevation = 3.dp,
        backgroundColor = colorResource(id = R.color.app_bar_color),
        navigationIcon = navigationIcon
        )


}