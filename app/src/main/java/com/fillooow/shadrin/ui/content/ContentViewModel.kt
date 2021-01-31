package com.fillooow.shadrin.ui.content

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fillooow.shadrin.network.DevelopersLifeApi
import com.fillooow.shadrin.network.DevelopersLifeProperty
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ContentViewModel : ViewModel() {

    private val responseCache = MutableLiveData<MutableList<DevelopersLifeProperty>>()
    val currentItem = MutableLiveData<DevelopersLifeProperty>()
    val canClickBack = MutableLiveData<Boolean>()
    private var currentPosition = -1

    init {
        responseCache.value = mutableListOf()
        getProperty()
    }

    private fun getProperty() {

        viewModelScope.launch {
            try {
                val result = async { DevelopersLifeApi.retrofitService.getRandomPost() }
                currentItem.value = result.await()

                canClickBack.value = (responseCache.value?.size ?: 0 - 1) > 0
            } catch (e: Exception) {
                Log.e("error", "Failure: ${e.message}")
            } finally {

                responseCache.value?.add(currentItem.value!!)
            }
        }
    }

    fun onNextClick() {

        currentPosition++
        if (currentPosition == responseCache.value?.size ?: 0 - 1) { // не успел доделать проверку на выход за границы массива
            getProperty()
        } else {
            currentItem.value = responseCache.value?.get(currentPosition)
        }

    }

    fun onPrevClick() {

        currentPosition--
        currentItem.value = responseCache.value?.get(currentPosition)
    }
}

// все выходные был занят и посидел над задачкой всего лишь пару часов :(