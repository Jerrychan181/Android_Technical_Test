package com.example.deezer_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.deezer_test.ui.theme.Deezer_TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val stateViewModel: StateViewModel = viewModel()
            Deezer_TestTheme(stateViewModel.isDarkTheme.value) {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onPrimary) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "main"
                    ) {
                        composable("main") {
                            DeezerApp(navController)
                        }
                        composable("display") {
                            DisplayScreen(navController, stateViewModel)
                        }
                        composable("profil") {
                            ProfilScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
