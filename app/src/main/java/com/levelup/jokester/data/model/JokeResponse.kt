package com.levelup.jokester.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class JokeResponse(@PrimaryKey val id : Int,
                        val category : String?,
                        val type : String?,
                        val joke : String?,
                        val setup : String?,
                        val delivery : String?){

    var fullJoke : String? = when(type) {
        "single" -> joke
        else -> setup + delivery
    }
}
