package com.fillooow.shadrin.ui.content

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContentViewModel : ViewModel() {

    private val _lastName = MutableLiveData("Ada")

    val lastName: LiveData<String> = _lastName
}