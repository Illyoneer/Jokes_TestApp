package ru.glushko.testingjokeapp.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.glushko.testingjokeapp.presentation.viewmodels.MainViewModel

val presentationModule = module {
    viewModel {
        MainViewModel(_getJokesByCountUseCase = get())
    }
}