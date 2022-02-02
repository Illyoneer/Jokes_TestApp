package ru.glushko.testingjokeapp.di

import org.koin.dsl.module
import ru.glushko.testingjokeapp.data.mappers.JokeMapper
import ru.glushko.testingjokeapp.data.repositories.JokeRepositoryImpl
import ru.glushko.testingjokeapp.domain.repositories.JokeRepository

val dataModule = module {
    single {
        JokeMapper()
    }

    single <JokeRepository>{
       JokeRepositoryImpl(_mapper = get())
    }
}
