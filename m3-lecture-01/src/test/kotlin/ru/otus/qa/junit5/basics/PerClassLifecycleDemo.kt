package ru.otus.qa.junit5.basics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class PerClassLifecycleDemo {

    private var счётчик = 0

    // ОБЫЧНЫЙ метод, без companion object и @JvmStatic
    @BeforeAll
    fun поднимаемОкружениеОдинРаз() {
        println(">>> BeforeAll без статики, объект = ${this.hashCode()}")
    }

    @Test
    @Order(1)
    fun `первый тест увеличивает счётчик`() {
        счётчик++
        println("Тест 1: счётчик = $счётчик, объект = ${this.hashCode()}")
        assertEquals(1, счётчик)
    }

    @Test
    @Order(2)
    fun `второй тест видит состояние первого`() {
        счётчик++
        println("Тест 2: счётчик = $счётчик, объект = ${this.hashCode()}")
        assertEquals(2, счётчик) // уже 2 — состояние сохранилось!
    }
}
