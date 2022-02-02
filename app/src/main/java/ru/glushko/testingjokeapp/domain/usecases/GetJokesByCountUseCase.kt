package ru.glushko.testingjokeapp.domain.usecases

import ru.glushko.testingjokeapp.domain.repositories.JokeRepository

class GetJokesByCountUseCase(private val _jokeRepository: JokeRepository) {
    suspend fun getJokesByCount(count:Int) = _jokeRepository.getJokesByCount(count)
}