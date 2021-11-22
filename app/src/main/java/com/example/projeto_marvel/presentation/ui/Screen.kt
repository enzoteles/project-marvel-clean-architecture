package com.example.projeto_marvel.presentation.ui

sealed class Screen(val route:String){
    object ListCommicsScreen: Screen(route = "list_screen")
    object CommicsDetailScreen: Screen(route = "detail_screen")
}
