package context

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterResolver
import org.junit.jupiter.api.extension.ParameterContext

// Самое простое расширение
class SimpleParamExtension : ParameterResolver {
    override fun supportsParameter(
        parameterContext: ParameterContext,
        extensionContext: ExtensionContext
    ): Boolean {
        // Поддерживаем только String параметры
        return parameterContext.parameter.type == String::class.java
    }

    override fun resolveParameter(
        parameterContext: ParameterContext,
        extensionContext: ExtensionContext
    ): Any {
        // ParameterContext показывает позицию параметра
        val position = parameterContext.index
        return "Значение для параметра #$position"
    }
}

// Самый простой тест
@ExtendWith(SimpleParamExtension::class)
class OneParamTest {

    @Test
    fun testWithParam(value: String) {
        println("Получен параметр: $value")
        assertTrue(value.startsWith("Значение"))
    }
}