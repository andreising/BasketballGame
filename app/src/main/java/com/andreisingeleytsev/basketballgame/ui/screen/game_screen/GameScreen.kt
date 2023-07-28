package com.andreisingeleytsev.basketballgame.ui.screen.game_screen

import android.util.Log
import android.view.MotionEvent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andreisingeleytsev.basketballgame.R
import com.andreisingeleytsev.basketballgame.ui.screen.records_screen.ListItem
import com.andreisingeleytsev.basketballgame.ui.theme.MainColor
import com.andreisingeleytsev.basketballgame.ui.utils.Fonts
import com.andreisingeleytsev.ukfootballapp.ui.utils.Routes

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun GameScreen(navHostController: NavHostController, viewModel: GameScreenViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.game_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
    BoxWithConstraints(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .width(maxWidth / 2),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.main_button),
                contentDescription = null,
                modifier = Modifier.size(62.dp).clickable {
                    navHostController.popBackStack()
                }
            )
            Box(modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.Center){
                Image(
                    painter = painterResource(id = R.drawable.score_table),
                    contentDescription = null,
                    modifier = Modifier.width(130.dp),
                    contentScale = ContentScale.FillWidth
                )
                Text(text = viewModel.score.value.toString(), style = TextStyle(
                    fontFamily = Fonts.tableFont,
                    fontSize = 40.sp,
                    color = Color.Black
                ), modifier = Modifier.padding(top = 20.dp)
                )
            }
        }
    }
    BoxWithConstraints(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {
        viewModel.width = maxWidth
        viewModel.height = maxHeight
        Image(
            painter = painterResource(id = viewModel.img.value),
            contentDescription = null,
            modifier = Modifier
                .width(105.94.dp)
                .offset(x = 60.dp, y = 0.dp),
            contentScale = ContentScale.FillWidth
        )
        val density = LocalContext.current.resources.displayMetrics.density
        val kx = density*((165.94 - 14.18).dp).value
        val ky = (-(207 - 14.18).dp).value * density
        viewModel.centerWidthFloatY = kx
        viewModel.centerWidthFloatX = ky
        Image(
            painter = painterResource(id = R.drawable.ball),
            contentDescription = null,
            modifier = Modifier
                .size(28.37.dp)
                .offset(x = viewModel.xOffset.value, y = viewModel.yOffset.value)
                .pointerInteropFilter { event ->
                    when (event.action) {
                        MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                            Log.d("down", "check")
                            viewModel.onEvent(GameScreenEvent.OnRotateChange(event.x, event.y))
                            true
                        }

                        MotionEvent.ACTION_UP -> {
                            Log.d("up", "check")
                            viewModel.onEvent(GameScreenEvent.OnPushTheBall)
                            true
                        }

                        else -> false
                    }
                }
        )
        Image(
            painter = painterResource(id = R.drawable.basket),
            contentDescription = null,
            modifier = Modifier
                .width(80.dp)
                .offset(x = maxWidth - 120.dp, y = 140.dp - maxHeight),
            contentScale = ContentScale.FillWidth
        )
    }
}