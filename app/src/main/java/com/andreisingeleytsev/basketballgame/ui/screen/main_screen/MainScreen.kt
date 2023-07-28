package com.andreisingeleytsev.basketballgame.ui.screen.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.basketballgame.R
import com.andreisingeleytsev.basketballgame.ui.theme.MainColor
import com.andreisingeleytsev.ukfootballapp.ui.utils.Routes

@Composable
fun MainScreen(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.main_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.main_button),
            contentDescription = null,
            modifier = Modifier.size(200.dp).clickable {
                navHostController.navigate(Routes.GAME_SCREEN)
            }
        )
    }
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Row(
            modifier = Modifier
                .width(maxWidth / 3)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.rating_button),
                contentDescription = null,
                modifier = Modifier.size(76.dp).clickable {
                    navHostController.navigate(Routes.RECORDS_SCREEN)
                }
            )
            Column(Modifier.padding(top = 24.dp, bottom = 24.dp, end = 30.dp).fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
                Image(
                    painter = painterResource(id = R.drawable.settings_button),
                    contentDescription = null,
                    modifier = Modifier.size(63.dp).clickable {
                        navHostController.navigate(Routes.SETTINGS_SCREEN)
                    }
                )
                Image(
                    painter = painterResource(id = R.drawable.rules_button),
                    contentDescription = null,
                    modifier = Modifier.size(63.dp).clickable {
                        navHostController.navigate(Routes.RULES_SCREEN)
                    }
                )
            }
        }
    }
}