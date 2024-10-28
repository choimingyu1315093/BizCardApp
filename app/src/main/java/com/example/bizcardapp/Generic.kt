package com.example.bizcardapp

fun main() {
    val listOfItems = listOf("Rafael", "Gina", "George", "James")
    val listOfNumbers = listOf(1,2,3,4,5)
    val finder = Finder(listOfItems)
    finder.findItem("Gina"){
        println("Found $it")
    }
}

//Finder class의 문제는 String 타입만 찾을 수 있다는 점이다.
//제네릭: 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 것.
//class Finder(private val list: List<String>){
//
//    fun findItem(element: String, foundItem: (String?) -> Unit){
//        val itemFoundList = list.filter {
//            it == element
//        }
//        if(itemFoundList.isNullOrEmpty()){
//            foundItem(null)
//        }else {
//            foundItem(itemFoundList.first())
//        }
//    }
//}

class Finder<T>(private val list: List<T>){

   fun findItem(element: T, foundItem: (T?) -> Unit){
       val itemFoundList = list.filter {
           it == element
       }
       if(itemFoundList.isEmpty()){
           foundItem(null)
       }else {
           foundItem(itemFoundList.first())
       }
   }
}