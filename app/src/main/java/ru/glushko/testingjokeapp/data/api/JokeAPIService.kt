package ru.glushko.testingjokeapp.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.glushko.testingjokeapp.data.model.APIJoke
import ru.glushko.testingjokeapp.data.model.APIJokeList

interface JokeAPIService {

    @GET("jokes/random/{count}")
    suspend fun getJokesByCount(@Path("count") count: Int): Response<APIJokeList>
}