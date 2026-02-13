package ru.otus

fun main() {

    // Исключение, сгенерированное Kotlin
    try {
        val result = 10 / 0
        println(result) // не выполнится
    } catch (e: ArithmeticException) {
        println("Перехвачено встроенное исключение: ${e.message}")
    }

}