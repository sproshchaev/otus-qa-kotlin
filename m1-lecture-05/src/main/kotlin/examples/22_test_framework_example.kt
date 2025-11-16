package examples

// Имитация простого тестового фреймворка
fun `test`(testName: String, testBody: () -> Unit) {
    print("🔍 $testName: ")
    try {
        testBody()
        println("PASS")
    } catch (e: AssertionError) {
        println("FAIL - ${e.message}")
    }
}

fun `assert that`(value: Boolean) {
    if (!value) throw AssertionError("Утверждение не выполнено")
}

fun `assert equals`(expected: Any?, actual: Any?) {
    if (expected != actual) {
        throw AssertionError("Ожидалось: $expected, получено: $actual")
    }
}

fun main() {
    // Читается как естественный язык
    `test`("Проверка сложения") {
        `assert equals`(4, 2 + 2)
    }

    `test`("Проверка умножения") {
        `assert that`(3 * 3 == 9)
    }

    `test`("Проверка строк") {
        `assert equals`("Kotlin", "Kot".plus("lin"))
    }
}