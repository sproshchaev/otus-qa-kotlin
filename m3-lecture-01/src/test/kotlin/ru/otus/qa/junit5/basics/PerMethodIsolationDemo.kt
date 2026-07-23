package ru.otus.qa.junit5.basics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PerMethodIsolationDemo {

    // обычное поле класса
    private var счётчик = 0

    @Test
    fun `первый тест увеличивает счётчик`() {
        счётчик++
        println("Тест 1: счётчик = $счётчик, объект = ${this.hashCode()}")
        assertEquals(1, счётчик)
    }

    @Test
    fun `второй тест видит чистое поле`() {
        счётчик++
        println("Тест 2: счётчик = $счётчик, объект = ${this.hashCode()}")
        assertEquals(1, счётчик) // снова 1, а не 2!
    }
}
