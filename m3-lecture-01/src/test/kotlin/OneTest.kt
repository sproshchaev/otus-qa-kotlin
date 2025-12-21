import extensions.NumberResolver
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.*

@ExtendWith(NumberResolver::class)
class OneTest {
    @Test
    fun test(number: Int) {
        println("Число: $number")
        assertEquals(42, number)
    }
}