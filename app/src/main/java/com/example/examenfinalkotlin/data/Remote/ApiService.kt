package com.example.examenfinalkotlin.data.Remote



import com.example.examenfinalkotlin.data.Model.Post

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    //creo dos endopints uno para obtener todos los post
    // y otro para obtener el post por el id
    @GET("https://jsonplaceholder.typicode.com/posts")
    fun getAllPost(): Call<List<Post>>

    @GET("Post/{id}")
    fun getPostById(@Path("id") id: String): Call<Post>
//endpoint para crear un usuario no funciona pero fue intentado
    @POST("post")
    fun createPost(@Body post:Post): Call<Post>

    // Método DELETE para eliminar un usuario por ID tampoco funciona pero lo intente
    @DELETE("Post/{id}")
    fun deletePost(@Path("id") id: String): Call<Post>

}
