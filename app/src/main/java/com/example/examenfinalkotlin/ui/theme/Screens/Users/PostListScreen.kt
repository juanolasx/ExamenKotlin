package com.example.examenfinalkotlin.ui.theme.Screens.Users

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.examenfinalkotlin.data.Model.Post
import com.example.examenfinalkotlin.ui.theme.Components.PostItem

@Composable
fun PostListScreen(onPostClick: (Post) -> Unit, Posts: List<Post>?) {
    // Si no hemos recibido la lista de posts, mostramos un cargador
    if (Posts == null) {
        CircularProgressIndicator(modifier = Modifier.fillMaxSize())
    }  else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(Posts!!) { Post ->
                // Aseguramos que onClick se pase correctamente a cada PostItem
                PostItem(Post = Post, onClick = { onPostClick(Post) })
            }
        }
    }
}
