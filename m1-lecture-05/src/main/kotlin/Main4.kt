open class Test {
    open fun run() = println("Запуск теста")
}

class SpecificTest : Test() {
    override fun run() = println("Запуск специфичного теста")
}

//class TestRunner<T: Test>(private val test: Test) { // Cannot infer type for type parameter 'T'. Specify it explicitly.
class TestRunner<T: Test>(private val test: T) {      // Здесь указываем T вместо Test
    fun runTest() {
        test.run()
    }
}

fun main() {
    val specificRunner = TestRunner(SpecificTest())
    val starRunner = TestRunner(SpecificTest())

    specificRunner.runTest()
    starRunner.runTest()
}