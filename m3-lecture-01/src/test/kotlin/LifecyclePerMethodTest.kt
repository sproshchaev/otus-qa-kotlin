import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

class LifecyclePerMethodTest {

    // Поле для демонстрации состояния
    private var counter: Int = 0

    // @BeforeAll должен быть static при PER_METHOD
    companion object {
        @JvmStatic
        @BeforeAll
        fun beforeAllStatic() {
            println("=== PER_METHOD: BeforeAll (static) ===")
        }

        @JvmStatic
        @AfterAll
        fun afterAllStatic() {
            println("=== PER_METHOD: AfterAll (static) ===")
        }
    }

    @BeforeEach
    fun setUp() {
        counter = 0 // Сбрасываем счетчик перед каждым тестом
        println("BeforeEach: counter = $counter")
    }

    @AfterEach
    fun tearDown() {
        println("AfterEach: counter = $counter")
    }

    @Test
    fun `test 1 - increment counter`() {
        counter++
        println("Test 1: counter = $counter")
        assertEquals(1, counter)
    }

    @Test
    fun `test 2 - increment counter again`() {
        counter++
        println("Test 2: counter = $counter")
        assertEquals(1, counter) // Всегда 1, так как новый экземпляр!
    }

    @Test
    fun `test 3 - check initial state`() {
        println("Test 3: counter = $counter")
        assertEquals(0, counter) // Всегда 0 при начале теста
    }
}