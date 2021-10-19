package com.levelup.jokester.data.remote

import com.levelup.jokester.data.model.JokeResponse
import retrofit2.Call

class JokesService(private val jokesApi : JokesApi) {

    fun getAnyJoke() : Call<JokeResponse>{
        return jokesApi.getAnyJoke()
    }

}