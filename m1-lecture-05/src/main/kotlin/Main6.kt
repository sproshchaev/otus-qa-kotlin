
fun logger(name: String, body: () -> Unit) {
    println("Start method $name")
    body()
    println("End method $name")
}

fun main() {
    // Обычный вызов
    logger("RunTest", {
        println("Hello, world!")
    })

    println("=========")

    // Лямбда за скобками
    logger("RunTest") {
        println("Hello, world!")
    }
}