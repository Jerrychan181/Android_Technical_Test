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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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


@Composable
fun DeezerApp(
    modifier: Modifier = Modifier
) {
    Scaffold(
    ) {
paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .padding(dimensionResource(id = R.dimen.padding_small))
                .verticalScroll(rememberScrollState())
                .fillMaxSize()

        )
        {
            Text(
                text = stringResource(R.string.title_preference),
                color = Color.Gray,
                textAlign = TextAlign.Left
            )

            MenuCard(modifier = modifier
                .padding(dimensionResource(id = R.dimen.padding_small)))

        }

    }

}

@Composable
fun MenuCard(modifier: Modifier = Modifier, ) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F0F5)),

    ) {

        NavigationButton(stringResource(R.string.navigation_button_account), Icons.Default.Person)
        NavigationButton(stringResource(R.string.navigation_button_display), Icons.Default.Build)
    }
}

/**
 * Boutons de navigation vers les autres écrans
 */
@Composable
fun NavigationButton(label: String, icon: ImageVector) {
    TextButton(
        onClick = {  },
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
    DeezerApp()
}