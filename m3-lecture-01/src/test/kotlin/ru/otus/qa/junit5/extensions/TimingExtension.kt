package ru.otus.qa.junit5.extensions

import org.junit.jupiter.api.extension.AfterTestExecutionCallback
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback
import org.junit.jupiter.api.extension.ExtensionContext

class TimingExtension : BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private val ключ = "старт"

    private fun хранилище(context: ExtensionContext) =
        context.getStore(ExtensionContext.Namespace.create(javaClass, context.requiredTestMethod))

    override fun beforeTestExecution(context: ExtensionContext) {
        хранилище(context).put(ключ, System.currentTimeMillis())
    }

    override fun afterTestExecution(context: ExtensionContext) {
        val старт = хранилище(context).get(ключ, Long::class.javaObjectType)!!
        val длительность = System.currentTimeMillis() - старт
        println("Тест '${context.displayName}' выполнялся $длительность мс")
    }
}
