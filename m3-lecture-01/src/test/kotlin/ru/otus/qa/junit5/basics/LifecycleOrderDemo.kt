package ru.otus.qa.junit5.basics

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LifecycleOrderDemo {

    companion object {
        @JvmStatic
        @BeforeAll
        fun поднимаемОкружение() {
            println(">>> BeforeAll — один раз перед всеми тестами")
        }

        @JvmStatic
        @AfterAll
        fun гасимОкружение() {
            println("<<< AfterAll — один раз после всех тестов")
        }
    }

    @BeforeEach
    fun готовимДанные() {
        println("  -> BeforeEach — перед каждым тестом")
    }

    @AfterEach
    fun убираемЗаСобой() {
        println("  <- AfterEach — после каждого теста")
    }

    @Test
    fun первыйТест() {
        println("     [тест 1]")
    }

    @Test
    fun второйТест() {
        println("     [тест 2]")
    }
}
