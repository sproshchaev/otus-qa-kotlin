package ru.otus

/**
 * Циклы-итераторы
 */
fun main() {

    // 1. Итерация по списку
    val fruits = listOf("Apple", "Banana", "Chery")
    println("Фрукты:")
    for (fruit in fruits) {
        println(" - $fruit")
    }

    // 2. Итерация по множеству
    val uniqueNumber = setOf(1, 2, 3, 2, 1)
    println("Уникальные числа")
    for (num in uniqueNumber) {
        println("$num")
    }

    // 3. Итерация по диапазону
    println("Числа от 1 до 5:")
    for (i in 1..5) {
        println("$i ")
    }

    // 4. Убывающий диапазон
    println("Числа от 10 до 1 с шагом 2:")
    for (i in 10 downTo 1 step 2) {
        println("$i ")
    }
    println()

    // 5. Итерация по Map
    val capitals = mapOf("Франция" to "Париж", "Яаония" to "Токио")
    println("Столицы:")
    for ((country, city) in capitals) {
        println("$country, $city")
    }

    // .forEach
    println("Фрукты: ")
    fruits.forEach { fruit -> println("- $fruit") }

}