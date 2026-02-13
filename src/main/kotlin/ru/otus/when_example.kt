package ru.otus

/**
 * when
 */
fun main() {

    // 1. when c конкретным значением (как switch)
    val statusCode = 404
    val message = when (statusCode) {
        200 -> "OK"
        404 -> "Not Found"
        500 -> "Internal Server Error"
        else -> "Unknown status"
    }
    println("Статус $statusCode: $message")

    // 2. Несколько значений в одной ветке
    val grade = 'B'
    when (grade) {
        'A', 'B' -> println("Хорошая оценка")
        'C' -> println("Удовлетворительно")
        'D', 'E' -> println("Плохо")
        else -> println("Недопустимая оценка")
    }

    // 3. Проверка вхождения в диапазон (in)
    val number = 15
    when (number) {
        in 1..10 -> println("Число от 1 до 10")
        in 11..20 -> println("Число от 11 до 20")
        else -> println("Число вне диапазона 1-20")
    }

    // 4. Проверка типа (is)
    val obj: Any = "Hello, Kotlin"
    when (obj) {
        is String -> println("Строка длиной ${obj.length}")
        is Int -> println("Целое число: $obj")
        else -> println("Неизвестный тип")
    }

    // 5. when без аргумента (булевы выражения)
    val x = 10
    val y = -5
    when {
        x > 0 && y > 0 -> println("Оба положительные")
        x > 0 -> println("х полож, y отрицат или ноль")
        y > 0 -> println("y полож, x отриц или ноль")
        else -> println("оба положительные")
    }

}