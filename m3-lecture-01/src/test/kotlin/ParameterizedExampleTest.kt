import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ParameterizedExampleTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 5, 10])
    fun `test number is positive`(number: Int) {
        // Проверяем, что все переданные числа положительные
        assertEquals(true, number > 0, "Число $number должно быть положительным")
    }

    @ParameterizedTest
    @ValueSource(strings = ["hello", "world", "test"])
    fun `test string length`(text: String) {
        // Проверяем, что длина строки не менее 4 символов
        assertEquals(true, text.length >= 4, "Строка '$text' должна быть длиной >= 4")
    }
}