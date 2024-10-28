package com.example.bizcardapp

fun main() {
    val car = Car()//인스턴스화 (객체 생성)
    val car2 = Car2(color = "Blue", model = "BMW")
    val car3 = Car3(color = "Blue", model = "BMW")

    val truck = Truck(color = "Blue", model = "BMW")
    truck.drive()

    val button = Button(label = "Button")
    button.onClick("This is a Button")
}

class Car {
    var color = "Red"
    var model = "Toyota"
}

class Car2 (var color: String = "Red", var model: String = "Toyota"){

}

//상속
open class Car3 (var color: String, var model: String){
    open fun speed(minSpeed: Int, maxSpeed: Int){
        println("Min speed is $minSpeed, Max speed is $maxSpeed")
    }

    open fun drive(){
        println("Driving")
    }
}

class Truck(color: String, model: String): Car3(color, model){
    override fun drive() {
        super.drive()
        println("Truck is driving")
    }

    override fun speed(minSpeed: Int, maxSpeed: Int) {
        super.speed(minSpeed, maxSpeed)
        println("Truck speed is $minSpeed to $maxSpeed")
    }
}

//interface
interface ClickEvent {
    fun onClick(message: String){
        println(message)
    }
}

class Button(val label: String): ClickEvent {
    override fun onClick(message: String) {
        println("Clicked by $label and here's a message $message")
    }
}