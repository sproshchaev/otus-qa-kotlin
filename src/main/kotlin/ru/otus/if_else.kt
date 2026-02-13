package ru.otus

/**
 * Пример использования if
 */
fun main() {
    val age = 20;

    // Простой if без else
    if (age >= 18) {
        println("Доступ разрешен")
    }

    // If-else
    if (age >= 21) {
        println("Можно арендовать машину")
    } else {
        println("Аренда недоступна")
    }

    // If-else с несколькими условиями
    val score = 85
    if (score >= 90) {
        println("Оценка: A")
    } else if (score >= 75) {
        println("Оценка: B")
    } else if (score >= 50) {
        println("Оценка: C")
    } else {
        println("Оценка: D")
    }

    // Вложенный if (в блоке else)
    val isMember = true
    val purchaseAmount = 1500

    if (isMember) {
        println("Привет, постоянный клиент!")
        if (purchaseAmount > 1000) {
            println("Вам начислены доп бонусы")
        }
    } else {
        println("Хотите стать членом нашего клуба?")
    }

}