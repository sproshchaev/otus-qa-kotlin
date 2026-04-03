package ru.otus

import net.serenitybdd.junit5.SerenityJUnit5Extension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(SerenityJUnit5Extension::class)
class SimpleSerenityTest {

    private val steps = CalculatorSteps()

    @Test
    fun `сложение двух чисел работает корректно`() {
        steps.add(2, 3)
        steps.resultShouldBe(5)
    }

    @Test
    fun `умножение двух чисел работает корректно`() {
        steps.multiply(4, 5)
        steps.resultShouldBe(20)
    }
}