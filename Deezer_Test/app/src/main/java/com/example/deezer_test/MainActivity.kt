package com.example.deezer_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.deezer_test.ui.screens.DeezerApp
import com.example.deezer_test.ui.screens.DisplayScreen
import com.example.deezer_test.ui.screens.ProfilScreen
import com.example.deezer_test.ui.theme.Deezer_TestTheme

class MainActivity : ComponentActivity() {
    private val stateViewModel: StateViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Deezer_TestTheme(stateViewModel.isDarkTheme.value) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavHostModel(navController = rememberNavController(), stateViewModel = stateViewModel)
                }
            }
        }
    }
}

