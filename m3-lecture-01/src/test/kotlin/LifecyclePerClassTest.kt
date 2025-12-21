import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class) // Добавляем порядок выполнения
class LifecyclePerClassTest {

    // Поле для демонстрации состояния
    private var counter: Int = 0

    // При PER_CLASS @BeforeAll и @AfterAll НЕ должны быть static!
    @BeforeAll
    fun beforeAll() {
        println("=== PER_CLASS: BeforeAll (non-static) ===")
        counter = 100 // Начальное значение
    }

    @AfterAll
    fun afterAll() {
        println("=== PER_CLASS: AfterAll (non-static) ===")
        println("Final counter value: $counter")
    }

    @BeforeEach
    fun setUp() {
        println("BeforeEach: counter = $counter")
    }

    @AfterEach
    fun tearDown() {
        println("AfterEach: counter = $counter")
    }

    @Test
    @Order(1) // Явно указываем порядок
    fun `test 1 - increment from initial value`() {
        counter++
        println("Test 1: counter = $counter")
        assertEquals(101, counter) // 100 + 1
    }

    @Test
    @Order(2)
    fun `test 2 - increment again, state persists`() {
        counter++
        println("Test 2: counter = $counter")
        assertEquals(102, counter) // 101 + 1 - состояние сохранилось!
    }

    @Test
    @Order(3)
    fun `test 3 - see final state`() {
        println("Test 3: counter = $counter")
        assertEquals(102, counter) // То же значение, что после test 2
    }

    @Test
    @Order(4)
    fun `test 4 - modify state for next test`() {
        counter = 999
        println("Test 4: counter = $counter")
        assertEquals(999, counter)
    }

    @Test
    @Order(5)
    fun `test 5 - see modified state`() {
        println("Test 5: counter = $counter")
        assertEquals(999, counter) // Состояние изменилось в test 4!
    }
}