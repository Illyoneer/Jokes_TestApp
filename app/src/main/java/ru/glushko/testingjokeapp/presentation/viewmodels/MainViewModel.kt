package ru.glushko.testingjokeapp.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.glushko.testingjokeapp.domain.model.Joke
import ru.glushko.testingjokeapp.domain.usecases.GetJokesByCountUseCase

class MainViewModel(private val _getJokesByCountUseCase: GetJokesByCountUseCase): ViewModel() {

    val localJokesList:MutableLiveData<List<Joke>> = MutableLiveData()

    fun getJokesByCount(count:Int) = viewModelScope.launch {
        localJokesList.postValue(_getJokesByCountUseCase.getJokesByCount(count))
    }


}