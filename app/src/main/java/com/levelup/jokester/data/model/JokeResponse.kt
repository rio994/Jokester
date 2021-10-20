package com.levelup.jokester.data.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.levelup.jokester.BR

@Entity
class JokeResponse : BaseObservable(){

    @PrimaryKey
    var id : Int = -1
    var category : String? = null
    var type : String? = null
    var joke : String? = null
    var setup : String? = null
    var delivery : String = ""

    fun getFullJoke()= when(type) {
        "single" -> joke
        else -> setup + delivery
    }

    @Ignore
    @Bindable
    var isFavorite : Boolean = false
        set(value) {
            if(field != value){
                field=value
                notifyPropertyChanged(BR.isFavorite)
            }
        }


}
