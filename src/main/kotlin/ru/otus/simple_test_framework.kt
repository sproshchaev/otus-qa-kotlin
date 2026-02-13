package ru.otus

import java.lang.reflect.InvocationTargetException

// 1. Собственное исключение
class TestException(message: String) : Exception(message)

// 2. Базовый класс с assert-методом
open class BaseTest {
    fun assertEquals(expected: Any?, actual: Any?, message: String = "") {
        if (expected != actual) {
            throw TestException("$message Ожидалось $expected, $actual")
        }
    }

    fun assertTrue(condition: Boolean, message: String = "") {
        if (!condition) {
            throw TestException("message Условие не выполнено")
        }
    }

}

// 3. Тестовый класс
class MyTest: BaseTest() {
    fun testSum() {
        val result = 2 + 2
        assertEquals(4, result, "Сумма 2+2 должна быть 4")
        println("testSum пройден")
    }

    fun testStringLength() {
        val str = "Kotlin"
        assertTrue(str.length == 6, "Длина строки должна быть 6")
        println("testStringLength пройден")
    }

    fun testFailing() {
        assertTrue(false, "Этот тест падает")
    }

    fun notATest() {
        println("Этот метод не будет вызван, так как не начинается с test")
    }

}

// 4. Запуск тестов через рефлексию
fun main() {
    val test = MyTest()

    for (method in test::class.java.methods) {
        if (method.name.startsWith("test")) {
            println("Запуск ${method.name}...")
            try {
                method.invoke(test)
                println("OK")
            } catch (e: InvocationTargetException) {
                // Извлекаем исходное исключение
                when (val cause = e.targetException) {
                    is TestException -> println("FAIL: ${cause.message}")
                    else -> throw cause
                }
            }
        }
    }

}