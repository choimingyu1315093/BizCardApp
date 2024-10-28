package com.example.bizcardapp

fun main() {
    //list
    val names = listOf("a", "b")
    val names2 = mutableListOf<String>("a", "b")
    names2.add("a")
    println(names2)

    //set
    val setNames = setOf("a", "b")
    val setNames2 = mutableSetOf("a", "b")
    setNames2.add("a")
    println(setNames2)

    //map
    val mapNames = mapOf("a" to "first", "b" to "second")
    println(mapNames["a"])
    println(mapNames.get("a"))
    if("a" in mapNames){
        println("yes is in")
    }
    if("first" in mapNames.values){
        println("yes is in")
    }
    val mapNames2 = mutableMapOf("a" to "first", "b" to "second")
    mapNames2["c"] = "third"
    println(mapNames2)
}