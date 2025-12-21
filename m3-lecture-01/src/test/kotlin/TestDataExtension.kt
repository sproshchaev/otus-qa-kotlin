import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

class TestDataExtension : BeforeEachCallback {

    companion object {
        // Общие тестовые данные, доступные всем тестам
        val testUsers = listOf("Анна", "Борис", "Мария")
        val testProducts = mapOf(
            "яблоко" to 50,
            "банан" to 30,
            "апельсин" to 70
        )
    }

    override fun beforeEach(context: ExtensionContext) {
        println("Подготовка тестовых данных...")
        println("   Доступно пользователей: ${testUsers.size}")
        println("   Доступно продуктов: ${testProducts.size}")
    }
}