package com.andreisingeleytsev.basketballgame.ui.screen.game_screen

sealed class GameScreenEvent{
    data class OnRotateChange(val x: Float, val y: Float): GameScreenEvent()
    object OnPushTheBall: GameScreenEvent()
    object ToMenu: GameScreenEvent()
}
