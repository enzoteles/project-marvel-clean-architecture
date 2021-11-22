package com.example.projeto_marvel.presentation.ui.list_characters.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import example.projeto_marvel.domain.model.ResultMapper

@Composable
fun CharacterListItem (
    item: ResultMapper,
    onClick: (ResultMapper)-> Unit
){
    Column(
        modifier = Modifier
            .clickable(onClick = { onClick(item) })
    ){
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Card(
                modifier = Modifier.size(48.dp),
                shape = CircleShape,
                elevation = 2.dp
            ) {
                Image(
                    painter = rememberImagePainter("${item.thumbnail.path}.${item.thumbnail.extension}"),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth().size(30.dp)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.subtitle2,

                    )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = item.format,
                    style = MaterialTheme.typography.body2
                )
            }

        }
        Divider(color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f))
    }
}


