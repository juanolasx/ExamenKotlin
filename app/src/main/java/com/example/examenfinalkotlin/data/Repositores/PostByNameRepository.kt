package com.example.examenfinalkotlin.data.Repositores

import com.example.examenfinalkotlin.data.Model.Post
import com.example.examenfinalkotlin.data.Remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostByNameRepository {
    suspend fun fetchPostById(postId: String): Post? {
        return withContext(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.getPostById(postId).execute()
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
