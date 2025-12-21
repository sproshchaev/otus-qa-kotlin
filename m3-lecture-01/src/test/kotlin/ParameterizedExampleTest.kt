import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.*

class ParameterizedExampleTest {

    // Пример 1: @ValueSource (самый простой)
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 5, 10])
    fun `test with ValueSource - number is positive`(number: Int) {
        assertTrue(number > 0) { "Число $number должно быть положительным" }
    }

    // Пример 2: @EnumSource
    enum class TestNumber(val value: Int) {
        ONE(1), TWO(2), THREE(3), FIVE(5), TEN(10)
    }

    @ParameterizedTest
    @EnumSource(TestNumber::class)
    fun `test with EnumSource - number is positive`(testNumber: TestNumber) {
        val number = testNumber.value
        assertTrue(number > 0) { "Число $number (из enum ${testNumber.name}) должно быть положительным" }
    }

    // Пример 3: @CsvSource
    @ParameterizedTest
    @CsvSource(
        "1, true",
        "2, true",
        "3, true",
        "5, true",
        "10, true",
        "0, false",
        "-5, false"
    )
    fun `test with CsvSource - number positivity check`(number: Int, expectedPositive: Boolean) {
        // Проверяем, соответствует ли фактическая положительность числа ожидаемой
        val isActuallyPositive = number > 0
        assertTrue(isActuallyPositive == expectedPositive) {
            "Для числа $number ожидалась положительность: $expectedPositive, но получено: $isActuallyPositive"
        }
    }

    // Единственный companion object для всех статических методов
    companion object {
        // Пример 4: @MethodSource с локальным методом
        @JvmStatic
        fun provideNumbers(): List<Arguments> = listOf(
            Arguments.of(1, true),
            Arguments.of(2, true),
            Arguments.of(3, true),
            Arguments.of(5, true),
            Arguments.of(10, true),
            Arguments.of(0, false),
            Arguments.of(-5, false)
        )

        // Пример 5: @MethodSource с внешним файлом ресурсов
        @JvmStatic
        fun loadNumbersFromResource(): List<Arguments> {
            // Чтение данных из файла в ресурсах
            val inputStream = ParameterizedExampleTest::class.java
                .classLoader
                .getResourceAsStream("test_numbers.csv") ?: return emptyList()

            return inputStream.bufferedReader().useLines { lines ->
                lines.filter { it.isNotBlank() && !it.startsWith("#") }
                    .map { line ->
                        val parts = line.split(",")
                        Arguments.of(parts[0].trim().toInt(), parts[1].trim().toBoolean())
                    }
                    .toList()
            }
        }
    }

    // Пример 4: Тест с локальным MethodSource
    @ParameterizedTest
    @MethodSource("provideNumbers")
    fun `test with MethodSource - local method`(number: Int, expectedPositive: Boolean) {
        val isActuallyPositive = number > 0
        assertTrue(isActuallyPositive == expectedPositive) {
            "Для числа $number ожидалась положительность: $expectedPositive, но получено: $isActuallyPositive"
        }
    }

    // Пример 5: Тест с MethodSource из ресурса
    @ParameterizedTest
    @MethodSource("loadNumbersFromResource")
    fun `test with MethodSource - from resource file`(number: Int, expectedPositive: Boolean) {
        val isActuallyPositive = number > 0
        assertTrue(isActuallyPositive == expectedPositive) {
            "Для числа $number (из ресурса) ожидалась положительность: $expectedPositive, но получено: $isActuallyPositive"
        }
    }
}