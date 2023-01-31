package com.example.rickandmorty.feature_characters.presentation.character_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.rickandmorty.R
import com.example.rickandmorty.feature_characters.domain.model.CharacterShort
import com.example.rickandmorty.ui.theme.Shapes

@Composable
fun CharacterListItem(
    character: CharacterShort,
    onItemClick: (CharacterShort) -> Unit
) {
    Card(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .clickable { onItemClick(character) }
            .padding(16.dp, 8.dp),
        //backgroundColor = TransparentBlack need to add
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = rememberAsyncImagePainter(character.image),
                contentDescription = null,
                modifier = Modifier.size(300.dp),
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier
                    .padding(16.dp, 0.dp, 0.dp, 0.dp)
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = character.name,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(Modifier.fillMaxWidth().wrapContentHeight()) {
                    Text(
                        text = stringResource(R.string.status),
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = character.status,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Start
                    )
                }
                Spacer(Modifier.fillMaxWidth().height(4.dp))
                Row(Modifier.fillMaxWidth().wrapContentHeight()) {
                    Text(
                        text = stringResource(R.string.gender),
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = character.gender,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Start
                    )
                }
                Spacer(Modifier.fillMaxWidth().height(4.dp))
                Row(Modifier.fillMaxWidth().wrapContentHeight()) {
                    Text(
                        text = stringResource(R.string.species),
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = character.species,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}