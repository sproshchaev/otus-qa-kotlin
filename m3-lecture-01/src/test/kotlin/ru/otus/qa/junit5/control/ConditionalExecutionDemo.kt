package ru.otus.qa.junit5.control

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.DisabledOnOs
import org.junit.jupiter.api.condition.OS

class ConditionalExecutionDemo {

    @Test
    @EnabledOnOs(OS.MAC)
    fun `только на macOS`() {
        println("Запустился на Mac")
        assertTrue(true)
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    fun `везде кроме Windows`() {
        println("Работа с путями в стиле Unix")
        assertTrue(true)
    }

    @Test
    @EnabledOnOs(architectures = ["aarch64"])
    fun `только на ARM-процессоре`() {
        println("Архитектура aarch64")
        assertTrue(true)
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "CI", matches = "true")
    fun `локально да, на сервере сборки нет`() {
        println("Этот тест не поедет в CI")
        assertTrue(true)
    }
}
