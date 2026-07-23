package ru.otus.qa.junit5.extensions

import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

class LoggingExtension : BeforeAllCallback, BeforeEachCallback, AfterEachCallback {

    override fun beforeAll(context: ExtensionContext) {
        println("=== Стартует класс: ${context.displayName}")
    }

    override fun beforeEach(context: ExtensionContext) {
        println("  --> Стартует тест: ${context.displayName}")
    }

    override fun afterEach(context: ExtensionContext) {
        val упал = context.executionException.isPresent
        val статус = if (упал) "УПАЛ" else "прошёл"
        println("  <-- Тест ${context.requiredTestMethod.name}: $статус")
    }
}
