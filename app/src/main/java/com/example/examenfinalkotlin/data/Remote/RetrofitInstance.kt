package com.example.examenfinalkotlin.data.Remote


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/posts/"

    val api: ApiService by lazy {
        // Crea una nueva instancia de Retrofit, que es la librería que maneja las peticiones HTTP
        Retrofit.Builder()
            // Especifica la URL base de la API
            .baseUrl(BASE_URL)
            // Convierte automáticamente las respuestas JSON de la API en objetos Kotlin
            .addConverterFactory(GsonConverterFactory.create())
            // Construye la instancia de Retrofit con todas las configuraciones previas.
            .build()
            // Crea la implementación de ApiService para hacer peticiones.
            .create(ApiService::class.java)
    }
}