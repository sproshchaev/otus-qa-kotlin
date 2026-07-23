package ru.otus.qa.junit5.params

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValueSourceDemo {

    // ТАК было бы без параметризации — три почти одинаковых метода
    // @Test fun `2 чётное`() { assertTrue(2 % 2 == 0) }
    // @Test fun `4 чётное`() { assertTrue(4 % 2 == 0) }
    // @Test fun `6 чётное`() { assertTrue(6 % 2 == 0) }

    @ParameterizedTest
    @ValueSource(ints = [2, 4, 6, 8, 100])
    fun `число является чётным`(число: Int) {
        assertTrue(число % 2 == 0, "$число должно быть чётным")
    }

    @ParameterizedTest(name = "строка \"{0}\" не пустая")
    @ValueSource(strings = ["Kotlin", "JUnit", "QA"])
    fun `строка не пустая`(строка: String) {
        assertTrue(строка.isNotEmpty())
    }
}
