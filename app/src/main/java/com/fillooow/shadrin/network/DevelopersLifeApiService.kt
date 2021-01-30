package com.fillooow.shadrin.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://developerslife.ru/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DevelopersLifeApiService {

    @GET("0?json=true")
    suspend fun getProperties(): List<DevelopersLifeProperty>

    @GET("random?json=true")
    suspend fun getRandomPost(): DevelopersLifeProperty
}
object DevelopersLifeApi {

    val retrofitService: DevelopersLifeApiService by lazy { retrofit.create(DevelopersLifeApiService::class.java) }
}