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
import example.projeto_marvel.common.DateTimeHelper
import example.projeto_marvel.common.toPtBrRealStringWithoutSymbol
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
fun ContentDetail(item: ResultMapper) {
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
                painter = rememberImagePainter("${item.thumbnail.path}.${item.thumbnail.extension}"),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
        }

        Text(
            text = item.title,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp),
            fontSize = 20.sp
        )
        Text(
            text = item.stories.collectionURI,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 8.dp),
            textAlign = TextAlign.Left,
            fontSize = 14.sp
        )
        Text(
            text = "Data: ${item.dates[0].date}",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 8.dp),
            textAlign = TextAlign.Left,
            fontSize = 14.sp
        )

        Text(
            text = "Price: R$ ${item.prices[0].price}",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 8.dp),
            textAlign = TextAlign.Left,
            fontSize = 14.sp
        )

        Text(
            text = item.format,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 8.dp),
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
    }

}