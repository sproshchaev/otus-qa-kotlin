package context

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(SimpleContextExtension::class)
class MinimalContextTest {

    @Test
    @DisplayName("Простой тест сложения")
    fun testAddition() {
        Assertions.assertEquals(4, 2 + 2)
    }

    @Test
    @DisplayName("Тест проверки строки")
    fun testString() {
        Assertions.assertEquals("hello", "HELLO".lowercase())
    }
}