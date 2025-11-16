package examples

typealias StringMapper = (String) -> String
typealias NumberOperation = (Int, Int) -> Int

class StringProcessor {
    fun process(text: String): String = text.uppercase()

    companion object {
        fun staticProcess(text: String): String = text.lowercase()
    }
}

fun main() {
    val processor = StringProcessor()

    // Разные способы получения ссылок на функции:
    val topLevel: StringMapper = ::greet                    // Функция верхнего уровня
    val companionRef: StringMapper = StringProcessor::staticProcess  // Companion object
    val instanceRef: StringMapper = processor::process      // Метод объекта

    println(topLevel("hello"))
    println(companionRef("HELLO"))
    println(instanceRef("hello"))
}