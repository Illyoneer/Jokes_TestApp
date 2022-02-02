package ru.glushko.testingjokeapp.data.mappers

import ru.glushko.testingjokeapp.data.model.APIJoke
import ru.glushko.testingjokeapp.domain.model.Joke

class JokeMapper {
    private fun mapAPIJokeToEntity(apiJoke: APIJoke) = Joke(
        id = apiJoke.id,
        joke = apiJoke.joke
    ) //Мап элемента из API -> Entity

    fun mapListAPIJokeToListEntity(list: List<APIJoke>?) = list?.map{
        mapAPIJokeToEntity(it)
    } //Мап каждого элемента списка из DB -> Entity и получение нового списка.
}