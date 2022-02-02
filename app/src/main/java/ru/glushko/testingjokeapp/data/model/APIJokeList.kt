package ru.glushko.testingjokeapp.data.model

data class APIJokeList(
    val type: String,
    val value: List<APIJoke>
)