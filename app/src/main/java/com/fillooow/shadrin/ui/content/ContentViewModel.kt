package com.fillooow.shadrin.ui.content

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fillooow.shadrin.network.DevelopersLifeApi
import com.fillooow.shadrin.network.DevelopersLifeProperty
import kotlinx.coroutines.launch

class ContentViewModel : ViewModel() {

    init {
        getProperty()
    }

    private val responseCache = MutableLiveData<MutableList<DevelopersLifeProperty>>()
    val currentItem = MutableLiveData<DevelopersLifeProperty>()

    val status = MutableLiveData<DevelopersLifeProperty>()

    private fun getMarsRealEstateProperties() {

        viewModelScope.launch {
//            _status.value = MarsApiStatus.LOADING
            try {
//                _properties.value = MarsApi.retrofitService.getProperties()
//                _status.value = MarsApiStatus.DONE
            } catch (e: Exception) {
//                _status.value = MarsApiStatus.ERROR
//                _properties.value = ArrayList()
            }
        }
    }

    private fun getProperty() {

        viewModelScope.launch {
            try {
                val result = DevelopersLifeApi.retrofitService.getRandomPost()
                currentItem.value = result
                responseCache.value?.add(result)
            } catch (e: Exception) {
                Log.e("error", "Failure: ${e.message}")
            }
        }
    }

    fun onClick() = ::getProperty
}

enum class LoadState { LOADING, ERROR, DONE }