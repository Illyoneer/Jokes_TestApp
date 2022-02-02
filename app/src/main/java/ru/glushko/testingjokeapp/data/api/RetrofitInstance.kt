package ru.glushko.testingjokeapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofitInstance by lazy {
        Retrofit.Builder()
            .baseUrl("http://api.icndb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val jokeApi: JokeAPIService by lazy {
        retrofitInstance.create(JokeAPIService::class.java)
    }
}