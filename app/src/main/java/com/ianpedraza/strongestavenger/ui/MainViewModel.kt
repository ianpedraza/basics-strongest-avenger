package com.ianpedraza.strongestavenger.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ianpedraza.strongestavenger.R

class MainViewModel : ViewModel() {

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    private val _image = MutableLiveData<Int>()
    val image: LiveData<Int> = _image

    fun onImagePressed(character: Int) {
        _text.value = when(character) {
            WANDA -> WANDA_NAME
            STRANGE -> STRANGE_NAME
            CAROL -> CAROL_NAME
            else -> null
        }

        _image.value = when(character) {
            WANDA -> R.drawable.wanda
            STRANGE -> R.drawable.strange
            CAROL -> R.drawable.captain_marvel
            else -> null
        }
    }

    companion object {
        private const val WANDA_NAME = "The Scarlet Witch"
        private const val STRANGE_NAME = "Doctor Strange"
        private const val CAROL_NAME = "Captain Marvel"

        const val WANDA = 0
        const val STRANGE = 1
        const val CAROL = 2
    }

}