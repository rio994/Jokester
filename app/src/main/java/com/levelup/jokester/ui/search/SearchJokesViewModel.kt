package com.levelup.jokester.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.levelup.jokester.data.model.JokeResponse
import com.levelup.jokester.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchJokesViewModel(private val repository: Repository) : ViewModel() {

    fun getAnyJoke() = viewModelScope.launch(Dispatchers.IO) {
        repository.getAnyJoke().enqueue(object : Callback<JokeResponse>{
            override fun onResponse(call: Call<JokeResponse>, response: Response<JokeResponse>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}