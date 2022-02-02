package ru.glushko.testingjokeapp.data.repositories

import ru.glushko.testingjokeapp.data.api.RetrofitInstance
import ru.glushko.testingjokeapp.data.mappers.JokeMapper
import ru.glushko.testingjokeapp.domain.model.Joke
import ru.glushko.testingjokeapp.domain.model.JokeList
import ru.glushko.testingjokeapp.domain.repositories.JokeRepository

class JokeRepositoryImpl(private val _mapper: JokeMapper): JokeRepository {
    override suspend fun getJokesByCount(count: Int): List<Joke>?
    = _mapper.mapListAPIJokeToListEntity(RetrofitInstance.jokeApi.getJokesByCount(count).body()?.value)
}