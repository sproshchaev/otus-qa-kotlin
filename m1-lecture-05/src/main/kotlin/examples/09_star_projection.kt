package examples

// 09_star_projection.kt
open class Test {
    open fun run() = println("Запуск теста")
}

class SpecificTest : Test() {
    override fun run() = println("Запуск специфичного теста")
}

class TestRunner<T : Test>(private val test: T) {
    fun runTest() {
        test.run()
    }
}

fun main() {
    val specificRunner = TestRunner(SpecificTest())
    val starRunner: TestRunner<*> = TestRunner(SpecificTest()) // T = Test (верхняя граница)

    specificRunner.runTest()
    starRunner.runTest() // Работает, но тип T известен только как Test
}