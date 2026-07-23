package ru.otus.qa.junit5.alternative

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFailsWith
import kotlin.test.BeforeTest

class KotlinTestAssertionsDemo {

    private lateinit var список: MutableList<String>

    @BeforeTest
    fun подготовка() {
        список = mutableListOf("Kotlin", "JUnit")
    }

    @Test
    fun `размер списка`() {
        // порядок аргументов ДРУГОЙ: сначала ожидаемое, потом фактическое,
        // но сообщение идёт третьим — как в JUnit
        assertEquals(2, список.size, "В списке должно быть 2 элемента")
    }

    @Test
    fun `список содержит элемент`() {
        assertTrue(список.contains("Kotlin"))
    }

    @Test
    fun `обращение за границы бросает исключение`() {
        assertFailsWith<IndexOutOfBoundsException> {
            список[10]
        }
    }
}
