package com.example.examenfinalkotlin.data.Repositores

import android.util.Log
import com.example.examenfinalkotlin.data.Model.Post
import com.example.examenfinalkotlin.data.Remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostRepository {
    suspend fun fetchPost(): List<Post>? {

        return withContext(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.getAllPost().execute()
                if (response.isSuccessful) {
                    response.body()
                } else {
                    Log.e("API_ERROR", "Error: ${response.code()}")
                    null
                }
            } catch (e: Exception) {

                Log.e("API_ERROR", "Exception: ${e.message}")
                null
            }
        }
    }
    // Método para crear un usuario no funciona pero lo intente
    suspend fun createUser(post: Post): Post? {
        return withContext(Dispatchers.IO) {
            val response =
                RetrofitInstance.api.createPost(post).execute()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }
    // Método para eliminar un usuario por ID tampoco funciona pero lo intente
    suspend fun deletePost(id: Int): Boolean {
        return withContext(Dispatchers.IO) {
            val response =
                RetrofitInstance.api.deletePost(id.toString()).execute()
            response.isSuccessful
}
    }
}

