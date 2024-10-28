package com.example.bizcardapp

fun main() {
    Repository.startFetch()
    getResult(Repository.currentState())
    Repository.finishFetch()
    getResult(Repository.currentState())
    Repository.errorFetch()
    getResult(Repository.currentState())
}

fun getResult(result: Result){
    when(result){
        Result.SUCCESS -> println("Success")
        Result.FAILED -> println("Failed")
        Result.ERROR -> println("Error")
        Result.IDLE -> println("Idle")
        Result.LOADING -> println("loading")
    }
}

object Repository {
    private var loadState: Result = Result.IDLE
    private var dataFetched: String? = null

    fun startFetch(){
        loadState = Result.LOADING
        dataFetched = "data"
    }

    fun finishFetch(){
        loadState = Result.SUCCESS
        dataFetched = null
    }

    fun errorFetch(){
        loadState = Result.ERROR
    }

    fun currentState(): Result{
        return loadState
    }
}

enum class Result {
    SUCCESS,
    FAILED,
    ERROR,
    IDLE,
    LOADING
}