package com.andreisingeleytsev.basketballgame.ui.screen.game_screen

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.basketballgame.R
import com.andreisingeleytsev.ukfootballapp.ui.utils.UIEvents
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

class GameScreenViewModel: ViewModel() {
    private val _uiEvent = Channel<UIEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: GameScreenEvent){
        when(event) {
            is GameScreenEvent.OnRotateChange -> {
                changeAngle(event.x,event.y)
            }
            is GameScreenEvent.OnPushTheBall -> {
                pushBall()
            }

            else -> {}
        }

    }

    private fun sendUIEvent(event: UIEvents){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    val xOffset = mutableStateOf((165.94 - 28.37).dp)
    val yOffset = mutableStateOf(-(207 - 28.37).dp)
    var rotate = 0f
    var width = 0.dp
    var height = 0.dp
    private fun changeAngle(x: Float, y: Float) {
        val angle = atan2(centerWidthFloatX-x, y-centerWidthFloatY )
        val floatAngle = angle*(180F / PI).toFloat()
        rotate = floatAngle-180f
        Log.d("tag", rotate.toString())
        ySpeed = sin(Math.toRadians(rotate.toDouble())) * (-30).dp
    }
    var centerWidthFloatX = 0f
    var centerWidthFloatY = 0f
    var ySpeed = (-30).dp
    val score = mutableStateOf(0)
    private val ballTimer = object : CountDownTimer(10000, 80){
        override fun onTick(p0: Long) {
            val radians = Math.toRadians(rotate.toDouble())

            xOffset.value += cos(radians) * 30.dp
            ySpeed +=1.dp
            yOffset.value += ySpeed
            checkRicochet(radians)
        }

        override fun onFinish() {

        }

    }
    private fun checkRicochet(radians: Double) {
        val newX = xOffset.value - cos(radians) * 60.dp
        val newY = yOffset.value +ySpeed
        if (checkOutField(newX, newY)) {
            img.value = R.drawable.with_ball
            ballTimer.cancel()
            xOffset.value = (165.94 - 28.37).dp
            yOffset.value = (-(207 - 28.37)).dp
            score.value = 0
            return
        }
        if (newY in -height+40.dp..-height+100.dp && newX in width-160.dp..width-100.dp) {
            img.value = R.drawable.with_ball
            ballTimer.cancel()
            xOffset.value = (165.94 - 28.37).dp
            yOffset.value = (-(207 - 28.37)).dp
            score.value++
            return
        }
    }
    private fun pushBall(){
        img.value = R.drawable.without_ball
        ballTimer.start()
    }
    private fun checkOutField(newX: Dp, newY: Dp): Boolean {
        return newX !in 0.dp..width || newY !in -height..0.dp
    }
    val img = mutableStateOf(R.drawable.with_ball)
}