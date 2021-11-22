package com.example.projeto_marvel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.projeto_marvel.presentation.ui.theme.ProjetoMarvelTheme
import com.example.projeto_marvel.presentation.ui.detail_character.screen.DetailCharacter
import com.example.projeto_marvel.presentation.ui.list_characters.screen.ListCharacter
import com.example.projeto_marvel.presentation.ui.Screen
import com.example.projeto_marvel.presentation.ui.list_characters.viewmodel.GetCommicsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavGraphActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoMarvelTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
internal fun Navigation() {
    val navController = rememberNavController()
    val viewModel: GetCommicsViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Screen.ListCommicsScreen.route) {
        composable(route = Screen.ListCommicsScreen.route) {
            ListCharacter(viewModel){ nameScreen->
                navController.navigate(nameScreen)
            }
        }
        composable(
            route = Screen.CommicsDetailScreen.route + "/{index}",
            arguments = listOf(
                navArgument("index"){
                    type = NavType.IntType
                }
            )
        ){ entry->
            val index = entry.arguments?.getInt("index") ?: 0
            viewModel.state.value?.commics?.data?.results?.let { listCharacter ->
                val character = listCharacter[index]
                DetailCharacter(character = character){
                    navController.popBackStack()
                }
            }
        }
    }
}