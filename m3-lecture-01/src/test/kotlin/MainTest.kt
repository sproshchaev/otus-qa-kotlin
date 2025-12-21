import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS

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

    // Пример 1: @Tag - для категоризации тестов
    @Test
    @Tag("fast") // Метка для быстрых тестов
    @DisplayName("Быстрый тест - проверка умножения")
    fun fastTestMultiplication() {
        assertEquals(6, 2 * 3, "2 * 3 должно равняться 6")
    }

    @Test
    @Tag("slow") // Метка для медленных тестов (например, интеграционных)
    @Tag("integration") // Тест может иметь несколько тегов
    @DisplayName("Медленный интеграционный тест")
    fun slowIntegrationTest() {
        // Имитация долгого выполнения
        Thread.sleep(100)
        assertTrue(true, "Долгий тест должен проходить успешно")
    }

    // Пример 2: @RepeatedTest - повторение теста
    @RepeatedTest(
        value = 5, // Количество повторений
        name = "Повторение {currentRepetition} из {totalRepetitions}"
    )
    @DisplayName("Повторяющаяся проверка случайного числа")
    fun repeatedRandomTest(repetitionInfo: RepetitionInfo) {
        // Генерируем "случайное" число от 1 до 10
        // Используем номер повторения как псевдослучайное значение
        val randomValue = repetitionInfo.currentRepetition

        // Проверяем, что значение в допустимом диапазоне
        assertTrue(randomValue in 1..10) {
            "Сгенерированное значение $randomValue должно быть от 1 до 10"
        }

        println("Выполняется повторение ${repetitionInfo.currentRepetition} из ${repetitionInfo.totalRepetitions}")
    }

    // Пример 3: @RepeatedTest с @Tag
    @RepeatedTest(3)
    @Tag("stability") // Тег для проверки стабильности
    @DisplayName("Тест стабильности соединения")
    fun stabilityTest() {
        // Имитация проверки соединения
        val connectionSuccessful = true
        assertTrue(connectionSuccessful, "Соединение должно быть успешным")
    }

    // Пример 4: Комбинация @RepeatedTest с проверкой исключения
    @RepeatedTest(
        value = 4,
        name = "Попытка {currentRepetition}: проверка деления на ноль"
    )
    @DisplayName("Повторяющаяся проверка исключения")
    fun repeatedExceptionTest() {
        assertThrows(ArithmeticException::class.java) {
            val result = 100 / 0
        }
    }
}

// Пример использования @Tag на уровне всего класса
@Tag("critical") // Все тесты в этом классе будут помечены как critical
class CriticalTests {

    @Test
    @DisplayName("Критический тест - проверка аутентификации")
    fun criticalAuthenticationTest() {
        assertDoesNotThrow {
            // Имитация аутентификации
            val isAuthenticated = true
            require(isAuthenticated) { "Аутентификация должна быть успешной" }
        }
    }
}