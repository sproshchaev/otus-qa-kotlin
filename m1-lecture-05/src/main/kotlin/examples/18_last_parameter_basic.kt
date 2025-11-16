package examples

// 18_last_parameter_basic.kt

fun logger(name: String, body: () -> Unit) {
    println("START METHOD $name")
    body()
    println("END METHOD $name")
}

fun main() {
    // Обычный вызов
    logger("RunTest", {
        println("something")
    })

    // Синтаксис с лямбдой за скобками
    logger("RunTest") {
        println("something")
    }

    // Выглядит как встроенная языковая конструкция!
}