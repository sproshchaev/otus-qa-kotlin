package ru.otus.qa.junit5.extensions

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver

class UserParameterResolver : ParameterResolver {

    override fun supportsParameter(
        parameterContext: ParameterContext,
        extensionContext: ExtensionContext
    ): Boolean {
        // отвечаем "да" только для параметров типа TestUser
        return parameterContext.parameter.type == TestUser::class.java
    }

    override fun resolveParameter(
        parameterContext: ParameterContext,
        extensionContext: ExtensionContext
    ): Any {
        println("Создаю пользователя для теста '${extensionContext.displayName}', " +
                "параметр №${parameterContext.index}")
        return TestUser("Тестовый Пользователь", 30)
    }
}
