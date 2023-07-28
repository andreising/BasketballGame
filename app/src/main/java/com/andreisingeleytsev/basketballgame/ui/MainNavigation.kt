package com.andreisingeleytsev.basketballgame.ui

import android.media.MediaPlayer
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.basketballgame.ui.screen.game_screen.GameScreen
import com.andreisingeleytsev.basketballgame.ui.screen.main_screen.MainScreen
import com.andreisingeleytsev.basketballgame.ui.screen.rules_screen.RulesScreen
import com.andreisingeleytsev.basketballgame.ui.screen.settings_screen.SettingsScreen
import com.andreisingeleytsev.ukfootballapp.ui.utils.Routes

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MENU_SCREEN) {
        composable(Routes.MENU_SCREEN){
            MainScreen(navController)
        }
        composable(Routes.SETTINGS_SCREEN){
            SettingsScreen(navHostController = navController)
        }
        composable(Routes.RULES_SCREEN){
            RulesScreen(navHostController = navController)
        }
        composable(Routes.RECORDS_SCREEN){
            RulesScreen(navHostController = navController)
        }
        composable(Routes.GAME_SCREEN){
            GameScreen(navHostController = navController)
        }
    }
}