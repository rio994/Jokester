package com.levelup.jokester.data.model

data class JokeResponse(val category : String,
                        val type : String,
                        val joke : String?,
                        val setup : String?,
                        val delivery : String?)
