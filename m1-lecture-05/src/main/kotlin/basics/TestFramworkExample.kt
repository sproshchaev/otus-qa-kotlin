package basics

fun log(prefix: String, block: () -> String?) {
    val result = block()
    println("[$prefix] " + (result ?: "").trim())
}

abstract class OtusTestEngine {
    abstract fun run()
}

class TestFailedException(override val message: String?) : Exception()

abstract class OtusTest<T> {
    abstract fun startUp()
    fun tearDown() {}
    fun assertEquals(expected: T, evaluated: T) {
        if (expected == evaluated) {
            return
        }
        throw TestFailedException("Value $evaluated is not equals to expected [$expected]")
    }
}

class MyTest : OtusTest<Int>() {
    override fun startUp() {
        log("basics.MyTest") {
            "Test is started"
        }
    }

    fun testSum() {
        assertEquals(10, 5 + 5)
    }

    fun testFailing() {
        assertEquals(11, 5 + 5)
    }
}

class Lesson4 : OtusTestEngine() {

    val tests = mutableListOf<OtusTest<*>>()

    inline fun <reified T : OtusTest<*>> registerTest() {
        //create new test instance (indirect, by type)
        val test = T::class.java.getConstructor().newInstance()
        tests.add(test)
    }

    override fun run() {
        for (test in tests) {
            test.startUp()
            //get and run all test methods
            for (method in test::class.java.methods) {
                if (method.name.startsWith("test")) {
                    log("basics.Lesson4") {
                        "Running test ${method.name}"
                    }
                    val result = runCatching {
                        method.invoke(test)
                    }
                    if (result.isFailure) {
                        log("basics.Lesson4") {
                            "Test execution error: ${result.exceptionOrNull()}"
                        }
                    } else {
                        log("basics.Lesson4") {
                            "Test passed OK"
                        }
                    }
                }
            }
        }
    }
}

fun main() {
    val engine = Lesson4()
    engine.registerTest<MyTest>()
    engine.run()
}