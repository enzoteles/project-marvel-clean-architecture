package com.example.projeto_marvel.presentation.ui.detail_character.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import example.projeto_marvel.domain.model.ResultMapper

@Composable
fun DetailCharacter(
    character: ResultMapper,
    onClick: () -> Unit){
    Scaffold(
        topBar = { TopBarDetailCharacter(onClick) },
        content = { ContentDetail(character) },
    )

}

@Composable
fun TopBarDetailCharacter(onClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Detail Character")
        },
        navigationIcon = {
            IconButton(onClick = { onClick() }) {
                Icon(Icons.Filled.ArrowBack,"")
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 12.dp
    )
}
@Composable
fun ContentDetail(character: ResultMapper) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(16.dp),
            elevation = 2.dp
        ) {
            Image(
                painter = rememberImagePainter("${character.thumbnail.path}.${character.thumbnail.extension}"),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
        }

        Text(
            text = "Character Name",
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(top = 8.dp),
            fontSize = 20.sp
        )
        Text(
            text = "Character Description",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 8.dp),
            textAlign = TextAlign.Left,
            fontSize = 14.sp
        )

        Text(
            text = "Date: 15/07/2021",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 8.dp),
            textAlign = TextAlign.Left,
            fontSize = 14.sp
        )

        Text(
            text = "Price: $2.00",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 8.dp),
            textAlign = TextAlign.Left,
            fontSize = 14.sp
        )

        Text(
            text = "Character Apparence Comics List",
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 8.dp),
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
    }

}