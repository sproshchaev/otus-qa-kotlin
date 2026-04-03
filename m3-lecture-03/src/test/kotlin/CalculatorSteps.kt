class CalculatorSteps : PageObject() {

    private var result: Int = 0

    @Step("Пользователь складывает {0} и {1}")
    fun add(a: Int, b: Int) {
        result = a + b
        Serenity.recordReportData().withTitle("Результат сложения").andContents(result.toString())
    }

    @Step("Пользователь умножает {0} на {1}")
    fun multiply(a: Int, b: Int) {
        result = a * b
    }

    @Step("Результат должен быть равен {0}")
    fun resultShouldBe(expected: Int) {
        assert(result == expected) { "Ожидалось $expected, но получено $result" }
    }
}