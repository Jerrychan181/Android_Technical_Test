package com.example.deezer_test.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.deezer_test.R
import com.example.deezer_test.StateViewModel
import com.example.deezer_test.ui.theme.Gray40

/**
 * Cet écran affiche le profil d'une utilisateur
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilAppBar(
    canNavigateBack: () -> Unit
) {Column {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(R.string.title_profil)) },
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
fun ProfilScreen(navController: NavController, stateViewModel: StateViewModel) {
    MaterialTheme(
        colorScheme = if (stateViewModel.isDarkTheme.value) darkColorScheme() else lightColorScheme()
    ) {
        Scaffold(
            topBar = {
                ProfilAppBar(canNavigateBack = { navController.popBackStack() })
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(dimensionResource(id = R.dimen.padding_small))
                        .fillMaxSize()
                ){
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(dimensionResource(id = R.dimen.padding_medium))
                        ) {
                            Image(
                                painter = painterResource(R.drawable.pp_placeholder),
                                contentDescription = "profil_picture",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(128.dp)
                                    .clip(CircleShape)
                                    .align(Alignment.Center)
                            )
                        }
                            Column(){
                                Text(text = stringResource(R.string.placeholder_profilName),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 50.sp
                                    )
                                Text(text = stringResource(R.string.placeholder_profilFollower),
                                   color = Gray40)
                        }
                    }
            }

        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilScreenPreview() {
    ProfilScreen(navController = rememberNavController(), StateViewModel())

}
