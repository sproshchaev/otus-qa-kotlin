import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName

class MainTest {

    @Test
    @DisplayName("Проверка базовой математики: сложение")
    fun testAddition() {
        // Простейшая проверка сложения
        val result = 2 + 2
        assertEquals(4, result, "2 + 2 должно равняться 4")
    }

    @Test
    @DisplayName("Проверка условия истинности")
    fun testBooleanCondition() {
        // Проверка истинного условия
        val isCorrect = true
        assertTrue(isCorrect, "Условие должно быть истинным")
    }

    @Test
    @DisplayName("Проверка на неравенство")
    fun testNotEquals() {
        // Проверка что значения не равны
        val a = 10
        val b = 20
        assertNotEquals(a, b, "10 не должно равняться 20")
    }

    @Test
    @DisplayName("Проверка корректности инициализации")
    fun testNotNull() {
        // Проверка что объект не null
        val text = "Hello, JUnit 5!"
        assertNotNull(text, "Текст не должен быть null")
    }

    @Test
    @DisplayName("Проверка исключения")
    fun testException() {
        // Проверка что код выбрасывает исключение
        assertThrows(ArithmeticException::class.java) {
            val result = 10 / 0 // Делим на ноль
        }
    }
}