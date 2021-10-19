package com.levelup.jokester.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.levelup.jokester.data.remote.JokesApi
import com.levelup.jokester.data.remote.JokesService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val remoteModule = module {

    val url = "https://v2.jokeapi.dev/"

    fun provideGson() : Gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
        .create()

    fun provideHttpClient() : OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .build()

    fun provideRetrofit(gson: Gson, httpClient: OkHttpClient) : Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(httpClient)
        .build()

    single { provideGson() }
    single { provideHttpClient() }
    single { provideRetrofit(get(),get()) }
    single { get<Retrofit>().create(JokesApi :: class.java) }
    single { JokesService(get()) }

}