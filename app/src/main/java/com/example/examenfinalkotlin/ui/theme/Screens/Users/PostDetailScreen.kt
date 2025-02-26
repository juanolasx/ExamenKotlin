package com.example.examenfinalkotlin.ui.theme.Screens.Users

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.examenfinalkotlin.data.Model.Post

@Composable
fun PostDetailScreen(post: Post) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    //esta parte de aqui es para cuando pinches y vayas a la pestaña con detalles
        //te muestre el userid,el title. el id y el body/cuerpo
        //pongo los spacer para que haya hueco entre ellos por que si no queda muy junto y no se lee
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "-USER ID: ${post.userid}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "-TITULO: ${post.title}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "-ID: ${post.id}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "-CUERPO PRINCIPAL: ${post.body}", style = MaterialTheme.typography.bodyMedium)
    }
}
