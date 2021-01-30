package com.fillooow.shadrin.ui.content

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fillooow.shadrin.network.DevelopersLifeApi
import com.fillooow.shadrin.network.DevelopersLifeProperty
import kotlinx.coroutines.launch

class ContentViewModel : ViewModel() {

    val response = MutableLiveData<String>()

    private val _lastName = MutableLiveData("Ada")

    val lastName: LiveData<String> = _lastName

    private val _status = MutableLiveData<DevelopersLifeProperty>()

    val status: LiveData<DevelopersLifeProperty>
        get() = _status

    // with new values
    private val _properties = MutableLiveData<List<DevelopersLifeProperty>>()

    val properties: LiveData<List<DevelopersLifeProperty>>
        get() = _properties

    private val _property = MutableLiveData<DevelopersLifeProperty>()

    val property: LiveData<DevelopersLifeProperty>
        get() = _property

    init {
        getProperty()
    }

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
                val randomResult = DevelopersLifeApi.retrofitService.getRandomPost()
                response.value = "Success: ${randomResult.gifURL} Mars properties retrieved"

                _property.value = randomResult
            } catch (e: Exception) {
                response.value = "Failure: ${e.message}"
            }
        }
    }
}

enum class LoadState { LOADING, ERROR, DONE }