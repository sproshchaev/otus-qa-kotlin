import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestDataExtension::class) // Подключаем расширение
class SimpleExtensionTest {

    @Test
    @DisplayName("Проверка списка пользователей")
    fun testUsersList() {
        println("Тест: Проверяем список пользователей")

        // Используем данные из расширения
        val users = TestDataExtension.testUsers

        // Проверяем
        assertEquals(3, users.size)
        assertTrue(users.contains("Анна"))
        assertTrue(users.contains("Борис"))
        assertTrue(users.contains("Мария"))

    }

    @Test
    @DisplayName("Проверка цен на продукты")
    fun testProductPrices() {
        println("Тест: Проверяем цены на продукты")

        // Используем данные из расширения
        val products = TestDataExtension.testProducts

        // Проверяем
        assertEquals(50, products["яблоко"])
        assertEquals(30, products["банан"])
        assertEquals(70, products["апельсин"])

    }

    @Test
    @DisplayName("Проверка наличия продуктов")
    fun testProductAvailability() {
        println("Тест: Проверяем наличие продуктов")

        val products = TestDataExtension.testProducts

        // Проверяем, что продукт существует
        assertTrue(products.containsKey("яблоко"))
        assertFalse(products.containsKey("груша")) // Груши нет в списке

    }
}