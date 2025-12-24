import kotlin.test.Test
import kotlin.test.assertEquals

class UserTest {

    @Test
    fun `test create user with DSL`() {
        val user = user {
            name = "Иван Иванов"
            age = 30
            email = "ivan@example.com"
        }

        // Проверяем данные пользователя
        assertEquals("Иван Иванов", user.name)
        assertEquals(30, user.age)
        assertEquals("ivan@example.com", user.email)
    }


    @Test
    fun `test create user with infix DSL syntax`() {
        // Альтернативный синтаксис с инфиксной функцией
        val user = user {
            "name" to "Мария Петрова"
            "age" to 25
            "email" to "maria@example.com"
        }

        assertEquals("Мария Петрова", user.name)
        assertEquals(25, user.age)
        assertEquals("maria@example.com", user.email)
    }

    @Test
    fun `test user properties access with get operator`() {
        val user = User("Алексей", 35, "alex@example.com")

        // Используем оператор get для доступа к свойствам
        assertEquals("Алексей", user["name"])
        assertEquals(35, user["age"])
        assertEquals("alex@example.com", user["email"])
    }

    @Test
    fun `test user properties modification with set operator`() {
        val user = User("Ольга", 28, "olga@example.com")

        // set
        user["name"] = "Ольга Сидорова"
        user["age"] = 29
        user["email"] = "olga@example.com"

        assertEquals("Ольга Сидорова", user.name)
        assertEquals(29, user.age)
        assertEquals("olga@example.com", user["email"])
    }



}