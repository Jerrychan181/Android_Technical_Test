package com.example.deezer_test

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.deezer_test.ui.screens.DeezerApp
import com.example.deezer_test.ui.screens.DisplayScreen
import com.example.deezer_test.ui.screens.ProfilScreen

/**
 * Le navController ici permet de gérer la navigation entre les écrans. Ici mainScreen,
 * DisplayScreen et ProfilScreen
 */

@Composable
fun NavHostModel(navController: NavHostController, stateViewModel: StateViewModel) {
    NavHost(
        navController = navController,
        startDestination = "mainScreen"
    ) {
        composable("mainScreen") {
            DeezerApp(navController, stateViewModel)
        }
        composable("display") {
            DisplayScreen(navController, stateViewModel)
        }
        composable("profil") {
            ProfilScreen(navController, stateViewModel)
        }
    }
}
