package com.andreisingeleytsev.basketballgame.ui.screen.settings_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun SettingsScreen(navHostController: NavHostController) {
    val sound = remember {
        mutableStateOf(false)
    }
    val music = remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MainColor)){
        Image(
            painter = painterResource(id = R.drawable.secondary_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(
                    start = 40.dp,
                    top = 24.dp,
                    end = 40.dp,
                    bottom = 24.dp
                )
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.main_button),
                    contentDescription = null,
                    modifier = Modifier
                        .size(62.dp)
                        .clickable {
                            navHostController.navigate(Routes.GAME_SCREEN)
                        }
                )
                Box(modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.settings),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .width(122.dp)

                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.rating_button),
                    contentDescription = null,
                    modifier = Modifier
                        .size(62.dp)
                        .clickable {
                            navHostController.navigate(Routes.RECORDS_SCREEN)
                        }
                )
            }
            Row(
                modifier = Modifier.width(200.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sound),
                        contentDescription = null,
                        modifier = Modifier.width(70.dp),
                        contentScale = ContentScale.FillWidth
                    )
                    Switch(
                        checked = sound.value, onCheckedChange = {
                            sound.value = !sound.value
                        }, colors = SwitchDefaults.colors(
                            uncheckedTrackColor = Color.White,
                            checkedTrackColor = Color.Black,
                            uncheckedThumbColor = MainColor,
                            checkedThumbColor = MainColor
                        )
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
                    Image(
                        painter = painterResource(id = R.drawable.music),
                        contentDescription = null,
                        modifier = Modifier.width(70.dp),
                        contentScale = ContentScale.FillWidth
                    )
                    Switch(
                        checked = music.value, onCheckedChange = {
                            music.value = !music.value
                        }, colors = SwitchDefaults.colors(
                            uncheckedTrackColor = Color.White,
                            checkedTrackColor = Color.Black,
                            uncheckedThumbColor = MainColor,
                            checkedThumbColor = MainColor
                        )
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.settings_button),
                    contentDescription = null,
                    modifier = Modifier.size(63.dp).clickable {
                        navHostController.popBackStack()
                    }
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.language),
                        contentDescription = null,
                        modifier = Modifier.width(100.dp),
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row() {
                        Image(
                            painter = painterResource(id = R.drawable.russian),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp)
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Image(
                            painter = painterResource(id = R.drawable.port),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp)
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Image(
                            painter = painterResource(id = R.drawable.english),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp)
                        )
                    }
                }
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