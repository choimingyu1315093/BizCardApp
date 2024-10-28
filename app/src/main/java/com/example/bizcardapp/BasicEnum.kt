package com.example.bizcardapp

fun main() {
    println(getDayMessage(DayOfWeek.SUNDAY))
}

fun getDayMessage(day: DayOfWeek): String{
    return when(day){
        DayOfWeek.MONDAY -> "월요일은 새로운 시작!"
        DayOfWeek.FRIDAY -> "금요일은 주말의 시작!"
        DayOfWeek.SATURDAY, DayOfWeek.SUNDAY -> "주말에는 푹 쉬세요!"
        else -> "일하는 날입니다!"
    }
}

enum class DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}