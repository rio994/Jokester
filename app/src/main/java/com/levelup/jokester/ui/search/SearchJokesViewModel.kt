package com.levelup.jokester.ui.search

import androidx.lifecycle.MutableLiveData
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

    val singleType =  "single"
    val joke = MutableLiveData<JokeResponse>()
    val errorResponse = MutableLiveData<String>()
    val jokes = repository.getJokes()

    fun getAnyJoke() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAnyJoke().enqueue(object : Callback<JokeResponse> {
                override fun onResponse(
                    call: Call<JokeResponse>,
                    response: Response<JokeResponse>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        joke.postValue(response.body())
                    } else {
                        errorResponse.postValue(response.errorBody().toString())
                    }
                }


                override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
                    errorResponse.postValue(t.message)
                }

            })
        }
    }

    fun saveJoke()=viewModelScope.launch(Dispatchers.IO){
        joke.value?.let {
            it.isFavorite = !it.isFavorite

            if(it.isFavorite)
                repository.saveJoke(it)
            else
                repository.deleteJoke(it)
        }

    }


    fun deleteJoke(joke : JokeResponse) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteJoke(joke)
    }

    fun isSingleType() : Boolean = singleType == joke.value?.type
}