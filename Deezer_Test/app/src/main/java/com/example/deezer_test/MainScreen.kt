package com.example.deezer_test

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun DeezerApp(navController: NavController) {
    val StateViewModel: StateViewModel = viewModel()
    MaterialTheme(
        colorScheme = if (StateViewModel.isDarkTheme.value) darkColorScheme() else lightColorScheme()
    ) {
    }

    Scaffold {
            paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(dimensionResource(id = R.dimen.padding_small))
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            Text(
                text = stringResource(R.string.title_preference),
                color = Color.Gray,
                textAlign = TextAlign.Left
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF5F0F5))
            ) {

                NavigationButton(
                    label = stringResource(R.string.navigation_button_account),
                    icon = Icons.Default.Person,
                    route = "display",
                    navController = navController
                )
                NavigationButton(
                    label = stringResource(R.string.navigation_button_display),
                    icon = Icons.Default.Build,
                    route = "display",
                    navController = navController
                )
            }

        }
    }
}


/**
 * Boutons de navigation vers les autres écrans
 */
@Composable
fun NavigationButton(label: String, icon: ImageVector, route: String, navController: NavController) {
    TextButton(
        onClick = {navController.navigate(route)  },
        modifier = Modifier

        ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            label,
            color = Color.Black,
            textAlign = TextAlign.End
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp)
            )
        }


    }
}



@Preview(showBackground = true)
@Composable
fun DeezerAppPreview() {

}