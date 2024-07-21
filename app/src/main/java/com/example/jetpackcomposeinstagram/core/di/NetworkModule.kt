package com.example.jetpackcomposeinstagram.core.di

import com.example.jetpackcomposeinstagram.login.data.network.LoginClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//VIDEO #101
//Mirar la explicación de esta clase en los apuntes y en el documento word
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    //VIDEO #101
    //Mirar apuntes :)
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //VIDEO #101
    //Mirar apuntes :)
    @Singleton
    @Provides
    fun provideLoginClient(retrofit: Retrofit): LoginClient {
        return retrofit.create(LoginClient::class.java)
    }


}