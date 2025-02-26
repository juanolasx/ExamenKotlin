package com.example.examenfinalkotlin.data.Repositores

import com.example.examenfinalkotlin.data.Model.Post
import com.example.examenfinalkotlin.data.Remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
//he intentado hacer el metodo de deletepost pero no lo consegui
class DeletePost {
    suspend fun DeletePostById(postId: String): Post? {
        return withContext(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.deletePost(postId).execute()
                if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            } catch (e: Exception) {
                null
            }
        }
    }
}