package ru.glushko.testingjokeapp.di

import org.koin.dsl.module
import ru.glushko.testingjokeapp.domain.usecases.GetJokesByCountUseCase

val domainModule = module {
    factory {
        GetJokesByCountUseCase(_jokeRepository = get())
    }
}

