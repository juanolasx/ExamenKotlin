package com.example.examenfinalkotlin.ui.theme.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.examenfinalkotlin.data.Model.Post

@Composable
fun PostItem(Post: Post, onClick: (Post) -> Unit) {
    // Usamos `Card` para mostrar el post
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(Post) }, // Aseguramos que el click está bien registrado aquí
        shape = RoundedCornerShape(8.dp)  // Bordes redondeados
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = Post.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}