package ru.otus.qa.junit5.basics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FirstTestDemo {

    @Test
    fun `сложение двух чисел`() {
        val result = 2 + 3
        assertEquals(5, result, "2 + 3 должно быть 5")
    }

    @Test
    fun `строка содержит подстроку`() {
        val text = "Kotlin QA Engineer"
        assertTrue(text.contains("QA"))
    }

    // метод БЕЗ аннотации — фреймворк его не увидит
    fun этоНеТест() {
        println("Меня никто не запустит")
    }
}
