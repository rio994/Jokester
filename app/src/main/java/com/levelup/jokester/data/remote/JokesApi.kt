package com.levelup.jokester.data.remote

import com.levelup.jokester.data.model.JokeResponse
import retrofit2.Call
import retrofit2.http.GET

interface JokesApi {
    @GET("joke/any")
    fun getAnyJoke() : Call<JokeResponse>
}