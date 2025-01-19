package com.example.deezer_test

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class StateViewModel : ViewModel() {
    var isDarkTheme = mutableStateOf(false)


    fun setTheme(darkTheme: Boolean) {
        isDarkTheme.value = darkTheme
    }

    fun changeTheme() {
        isDarkTheme.value = !isDarkTheme.value
    }
}