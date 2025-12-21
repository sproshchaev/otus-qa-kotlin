package properties

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import kotlin.concurrent.thread

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FastTest {

    @Test
    fun fastTest1() {
        println("Быстрый тест 1 - поток: ${Thread.currentThread().name}")
        assertEquals(2, 1 + 1)
    }

    @Test
    fun fastTest2() {
        println("Быстрый тест 2 - поток: ${Thread.currentThread().name}")
        assertEquals(4, 2 * 2)
    }
}

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SlowTest {

    @Test
    fun slowButOk() {
        println("Медленный тест (в пределах таймаута) - поток: ${Thread.currentThread().name}")
        Thread.sleep(50) // Меньше 100ms из конфигурации
        assertTrue(true)
    }

    @Test
    @Timeout(1) // Переопределяем таймаут для этого теста
    fun verySlowWithCustomTimeout() {
        println("Очень медленный тест с кастомным таймаутом")
        Thread.sleep(500) // Но у нас свой таймаут 1 секунда
        assertEquals(10, 5 + 5)
    }
}