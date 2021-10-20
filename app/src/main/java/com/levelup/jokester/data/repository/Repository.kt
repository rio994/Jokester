package com.levelup.jokester.data.repository

import com.levelup.jokester.data.local.AppDatabase
import com.levelup.jokester.data.model.JokeResponse
import com.levelup.jokester.data.remote.JokesService
import retrofit2.Call

class Repository(val jokesService: JokesService, val database : AppDatabase) {

    fun getAnyJoke() : Call<JokeResponse> {
        return jokesService.getAnyJoke()
    }

    fun saveJoke(jokeResponse: JokeResponse) = database.jokeDao().insert(jokeResponse)


    fun getJokes() = database.jokeDao().getJokes()

    fun deleteJoke(jokeResponse: JokeResponse) = database.jokeDao().delete(jokeResponse)

}