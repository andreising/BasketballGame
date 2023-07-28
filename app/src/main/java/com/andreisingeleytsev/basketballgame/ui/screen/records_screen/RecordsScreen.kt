package com.andreisingeleytsev.basketballgame.ui.screen.records_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.basketballgame.R
import com.andreisingeleytsev.basketballgame.ui.theme.MainColor
import com.andreisingeleytsev.basketballgame.ui.utils.Fonts
import com.andreisingeleytsev.ukfootballapp.ui.utils.Routes

@Composable
fun RecordsScreen(navHostController: NavHostController) {
    val list1 = listOf<Triple<Int?, String, Int>>(
        Triple(null, "You:", 0),
        Triple(1, "JOHN:", 440),
        Triple(2, "SLIDE:", 425),
        Triple(3, "KINDO:", 390),
        Triple(4, "KILLO:", 350),
    )
    val list2 = listOf<Triple<Int?, String, Int>>(
        Triple(5, "SLAK:", 330),
        Triple(6, "JOHN:", 321),
        Triple(7, "SLIDE:", 311),
        Triple(8, "KINDO:", 310),
        Triple(9, "KILLO:", 290),
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainColor),
        contentAlignment = Alignment.Center
    ) {
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
                    modifier = Modifier.size(62.dp).clickable {
                        navHostController.navigate(Routes.GAME_SCREEN)
                    }
                )
                Box(modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.records),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .width(122.dp)

                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.rating_button),
                    contentDescription = null,
                    modifier = Modifier.size(62.dp).clickable {
                        navHostController.popBackStack()
                    }
                )
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
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(top = 50.dp)
        ) {
            LazyColumn() {
                items(list1) {
                    ListItem(triple = it)
                }
            }
            Spacer(modifier = Modifier.width(40.dp))
            LazyColumn(){
                items(list2){
                    ListItem(triple = it)
                }
            }
        }
    }
}

@Composable
fun ListItem(triple: Triple<Int?, String, Int>) {
    Column(modifier = Modifier.wrapContentSize()) {
        Card(
            modifier = Modifier
                .width(200.dp),
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(
                containerColor = MainColor
            ),
            border = BorderStroke(2.dp, Color.White)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(9.dp)
                    .fillMaxWidth()
            ) {
                Row() {
                    if (triple.first != null) {
                        Text(
                            text = triple.first.toString() + " ", style = TextStyle(
                                fontFamily = Fonts.customFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        )
                    }
                    Text(
                        text = triple.second, style = TextStyle(
                            fontFamily = Fonts.customFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White
                        ))
                }
                Row() {
                    Text(
                        text = triple.third.toString(), style = TextStyle(
                            fontFamily = Fonts.customFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    )

                    Text(
                        text = " POINTS", style = TextStyle(
                            fontFamily = Fonts.customFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }

}
