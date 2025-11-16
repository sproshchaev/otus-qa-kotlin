package examples

class TestSuite {
    fun test(name: String, testBlock: () -> Unit) {
        println("🧪 Тест: $name")
        try {
            testBlock()
            println("✅ Тест '$name' пройден")
        } catch (e: Exception) {
            println("❌ Тест '$name' провален: ${e.message}")
        }
    }

    fun describe(description: String, suiteBlock: TestSuite.() -> Unit) {
        println("\n📁 $description")
        this.suiteBlock()
    }
}

fun main() {
    val suite = TestSuite()

    // DSL-подобный синтаксис
    suite.describe("Проверки математики") {
        test("Сложение") {
            check(2 + 2 == 4) { "Сложение работает неправильно" }
        }

        test("Умножение") {
            check(3 * 3 == 9) { "Умножение работает неправильно" }
        }
    }

    suite.describe("Проверки строк") {
        test("Длина строки") {
            val text = "Kotlin"
            check(text.length == 6) { "Неправильная длина строки" }
        }
    }
}