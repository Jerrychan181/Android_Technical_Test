package com.example.deezer_test.ui.screens

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
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Build
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
import androidx.navigation.NavController
import com.example.deezer_test.R
import com.example.deezer_test.StateViewModel
import com.example.deezer_test.ui.theme.Gray40

/**
 * Ecran principal de navigation.
 *
 */

@Composable
fun DeezerApp(navController: NavController, stateViewModel: StateViewModel) {
    MaterialTheme(
        colorScheme = if (stateViewModel.isDarkTheme.value) darkColorScheme() else lightColorScheme()
    ) {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
            ) {
                Text(
                    text = stringResource(R.string.title_preference),
                    color = Gray40,
                    textAlign = TextAlign.Left,
                            modifier = Modifier
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF5F0F5))
                ) {
                    NavigationButton(
                        label = stringResource(R.string.navigation_button_account),
                        icon = Icons.Default.Person,
                        route = "profil",
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
            modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_small))
        )
        Text(
            label,
            color = Color.Black,
            textAlign = TextAlign.End
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.padding(end= dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DeezerAppPreview() {

}