package com.levelup.jokester.data.repository

import com.levelup.jokester.data.model.JokeResponse
import com.levelup.jokester.data.remote.JokesService
import retrofit2.Call

class Repository(val jokesService: JokesService) {

    fun getAnyJoke() : Call<JokeResponse> {
        return jokesService.getAnyJoke()
    }
}