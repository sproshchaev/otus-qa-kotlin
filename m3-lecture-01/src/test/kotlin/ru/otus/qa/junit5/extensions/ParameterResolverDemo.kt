package ru.otus.qa.junit5.extensions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(UserParameterResolver::class)
class ParameterResolverDemo {

    @Test
    fun `у пользователя есть имя`(пользователь: TestUser) {
        assertTrue(пользователь.имя.isNotEmpty())
    }

    @Test
    fun `пользователь совершеннолетний`(пользователь: TestUser) {
        assertEquals(30, пользователь.возраст)
        assertTrue(пользователь.возраст >= 18)
    }
}
