package com.example.examenfinalkotlin.data.Di

import com.example.examenfinalkotlin.data.Repositores.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Indica que es un modulo hilt de Dagger
@Module
//Indica que este modulo sera instalado en SingeltonComponent
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providePostRepository(): PostRepository {
        return PostRepository()
    }
}