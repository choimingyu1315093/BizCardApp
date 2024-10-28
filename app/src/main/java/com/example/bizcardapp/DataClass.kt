package com.example.bizcardapp

fun main() {
    val person = Person("mingyu", "choi", 35)
    println(person.name)
}

data class Person(
    val name: String,
    val lastName: String,
    val age: Int
)