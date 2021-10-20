package com.levelup.jokester.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.levelup.jokester.data.model.JokeResponse

@Database(entities = [JokeResponse::class], version = 4, exportSchema = true)
abstract class AppDatabase() : RoomDatabase() {
    abstract fun jokeDao() : JokeDao
}