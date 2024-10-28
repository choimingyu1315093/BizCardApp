package com.example.bizcardapp

fun main() {
    val test = "This is a "
    val test2 = test.append("Apple")
    println(test2)
}

fun String.append(toAppend: String): String {
    return this.plus(toAppend)
}
//위에거랑 같은 함수
fun String.append2(toAppend: String): String = this.plus(toAppend)