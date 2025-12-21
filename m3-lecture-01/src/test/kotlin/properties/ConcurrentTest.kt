package properties

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Execution(ExecutionMode.CONCURRENT) // Разрешаем параллельное выполнение методов
class ConcurrentTest {

    @Test
    fun concurrentTest1() {
        println("Конкурентный тест 1 начался")
        Thread.sleep(10)
        println("Конкурентный тест 1 завершился")
        assertTrue(true)
    }

    @Test
    fun concurrentTest2() {
        println("Конкурентный тест 2 начался")
        Thread.sleep(10)
        println("Конкурентный тест 2 завершился")
        assertTrue(true)
    }
}