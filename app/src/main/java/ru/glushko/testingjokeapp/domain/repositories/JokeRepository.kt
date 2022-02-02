package ru.glushko.testingjokeapp.domain.repositories
import ru.glushko.testingjokeapp.domain.model.Joke
import ru.glushko.testingjokeapp.domain.model.JokeList

interface JokeRepository {
    suspend fun getJokesByCount(count: Int): List<Joke>?
}