package ru.otus.qa.junit5.params

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MultiSourceParametersDemo {

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(
        "0,   1,   1",
        "1,   2,   3",
        "49,  51,  100",
        "1,   100, 101"
    )
    fun `сложение через CsvSource`(первое: Int, второе: Int, ожидаемое: Int) {
        assertEquals(ожидаемое, первое + второе)
    }

    @ParameterizedTest(name = "длина \"{0}\" = {1}")
    @MethodSource("источникДанных")
    fun `длина строки через MethodSource`(строка: String, длина: Int) {
        assertEquals(длина, строка.length)
    }

    companion object {
        @JvmStatic
        fun источникДанных(): Stream<Arguments> = Stream.of(
            Arguments.of("Kotlin", 6),
            Arguments.of("QA", 2),
            Arguments.of("", 0)
        )
    }
}
