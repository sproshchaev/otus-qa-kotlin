package ru.otus.qa.junit5.extensions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(LoggingExtension::class)
class LoggingExtensionDemo {

    @Test
    fun `успешный тест`() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `падающий тест`() {
        assertEquals(5, 2 + 2) // специально ломаем
    }
}
