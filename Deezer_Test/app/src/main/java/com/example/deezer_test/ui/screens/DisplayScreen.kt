package com.example.deezer_test.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.deezer_test.R
import com.example.deezer_test.StateViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayAppBar(
    canNavigateBack: () -> Unit
) {
    Column {
        CenterAlignedTopAppBar(
            title = { Text(stringResource(R.string.title_display)) },
            navigationIcon = {
                IconButton(onClick = canNavigateBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        )
        HorizontalDivider(thickness = 1.dp,
            modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun DisplayScreen(
    navController: NavController,
    stateViewModel: StateViewModel
) {
    MaterialTheme(
        colorScheme = if (stateViewModel.isDarkTheme.value) darkColorScheme() else lightColorScheme()
    ) {
        Scaffold(
            topBar = {
                DisplayAppBar(canNavigateBack = { navController.popBackStack() })
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(dimensionResource(id = R.dimen.padding_small))
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFF5F0F5))
                    ) {
                        SwitchMinimal(
                            stringResource(R.string.placeholder_darkMode),
                            darkTheme = stateViewModel.isDarkTheme.value,
                            onThemeChange = { stateViewModel.setTheme(it) }

                        )
                    }
                }
            }
        )
    }
}


@Composable
fun SwitchMinimal(label: String, darkTheme: Boolean, onThemeChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = Color.Black,
            modifier = Modifier
                .weight(1f),
        )
        Switch(
            checked = darkTheme,
            onCheckedChange = onThemeChange
        )
    }
}

@Preview(showBackground = true)
    @Composable
    fun DisplayScreenPreview() {
        DisplayScreen(navController = rememberNavController(), StateViewModel())

    }
