package ru.otus.qa.junit5.control

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class TestControlDemo {

    @Test
    @Tag("fast")
    fun `быстрая проверка`() {
        assertTrue(true)
    }

    @Test
    @Tag("slow")
    fun `медленная проверка`() {
        Thread.sleep(1000)
        assertTrue(true)
    }

    @Test
    @Disabled("Ждём фикс бага QA-123")
    fun `временно отключённый тест`() {
        assertTrue(false) // упал бы, но не запустится
    }

    @RepeatedTest(value = 5, name = "прогон {currentRepetition} из {totalRepetitions}")
    fun `проверка стабильности`() {
        val случайное = (1..10).random()
        assertTrue(случайное in 1..10)
    }
}
