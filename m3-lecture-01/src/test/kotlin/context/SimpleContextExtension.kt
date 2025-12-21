package context

import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

class SimpleContextExtension : BeforeEachCallback {
    override fun beforeEach(context: ExtensionContext) {
        // Получаем информацию о текущем тесте
        val className = context.testClass.map { it.simpleName }.orElse("Неизвестный класс")
        val methodName = context.testMethod.map { it.name }.orElse("Неизвестный метод")

        println("Запускается тест: $className.$methodName")
        println("Отображаемое имя: '${context.displayName}'")
    }
}