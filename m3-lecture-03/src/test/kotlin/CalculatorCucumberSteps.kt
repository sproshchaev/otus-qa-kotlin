package ru.otus

import io.cucumber.java8.En

class CalculatorCucumberSteps : En {

    private var a: Int = 0
    private var b: Int = 0
    private var result: Int = 0

    init {
        Given("пользователь открывает калькулятор") {
            // просто инициализация, можно ничего не делать
            println("Калькулятор открыт")
        }

        When("пользователь складывает {int} и {int}") { x: Int, y: Int ->
            a = x
            b = y
            result = a + b
        }

        When("пользователь умножает {int} на {int}") { x: Int, y: Int ->
            a = x
            b = y
            result = a * b
        }

        Then("результат должен быть {int}") { expected: Int ->
            assert(result == expected) { "Ожидалось $expected, получено $result" }
        }
    }
}