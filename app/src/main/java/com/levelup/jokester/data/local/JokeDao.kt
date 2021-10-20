package com.levelup.jokester.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.levelup.jokester.data.model.JokeResponse

@Dao
interface JokeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data : JokeResponse)

    @Query("SELECT * FROM JokeResponse")
    fun getJokes() : LiveData<List<JokeResponse>>

    @Delete
    fun delete(data : JokeResponse)
}