package com.example.deezer_test

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
/**
 * Le ViewModel ici sert gérer et garder en mémoire le darkmode entre les écrans
 *
 */
class StateViewModel : ViewModel() {
    var isDarkTheme = mutableStateOf(false)


    fun setTheme(darkTheme: Boolean) {
        isDarkTheme.value = darkTheme
    }

}