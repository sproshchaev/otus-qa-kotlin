package ru.otus.qa.junit5.extensions

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TimingExtension::class)
class TimingExtensionDemo {

    @BeforeEach
    fun долгаяПодготовка() {
        Thread.sleep(300) // имитация подготовки данных
    }

    @Test
    fun `быстрый тест`() {
        Thread.sleep(50)
        assertTrue(true)
    }

    @Test
    fun `медленный тест`() {
        Thread.sleep(500)
        assertTrue(true)
    }
}
