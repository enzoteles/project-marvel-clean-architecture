package com.example.projeto_marvel.presentation.ui.list_characters.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.projeto_marvel.presentation.ui.Screen
import com.example.projeto_marvel.presentation.ui.list_characters.components.GetCommicsState
import com.example.projeto_marvel.presentation.ui.list_characters.viewmodel.GetCommicsViewModel

@Composable
fun ListCharacter(
    viewModel: GetCommicsViewModel,
    nameScreen: (String)-> Unit
){
    val state = viewModel.state.value
    Scaffold(
        topBar = { TopBarListCharacter() },
        content = { ListLazyCollun(state = state, nameScreen = nameScreen) },
    )

}

@Composable
fun TopBarListCharacter(){
    TopAppBar(
        title = {
            Text(text = "List of Characters")
        },

        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 12.dp
    )
}

@Composable
fun ListLazyCollun(
    state: GetCommicsState,
    nameScreen: (String)-> Unit
){
    Box(modifier = Modifier.fillMaxSize()) {
        //loading
        if(state.isLoadding) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        //content
        LazyColumn{
            itemsIndexed(
                state.commics?.data?.results ?: listOf()
            ){ index, item ->
                // layout character item
                CharacterListItem(item = item, onClick = {
                    nameScreen(Screen.CommicsDetailScreen.route + "/$index")
                })
            }
        }
        //error
        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

    }

}