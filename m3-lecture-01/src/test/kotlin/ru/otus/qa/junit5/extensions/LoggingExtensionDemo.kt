package ru.otus.qa.junit5.extensions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(LoggingExtension::class)
class LoggingExtensionDemo {

    @Test
    fun `успешный тест`() {
        assertEquals(4, 2 + 2)
    }

    // Намеренно падающий демо-тест: показывает реакцию расширения на провал.
    // Помечен тегом "failing" и по умолчанию исключён из сборки (см. build.gradle.kts),
    // чтобы не рушить общий build. Запуск: ./gradlew :m3-lecture-01:test -DincludeTags=failing
    @Tag("failing")
    @Test
    fun `падающий тест`() {
        assertEquals(5, 2 + 2) // специально ломаем
    }
}
