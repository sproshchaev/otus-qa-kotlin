package examples

typealias SimpleAction = () -> Unit
typealias Logger = (String) -> Unit

fun executeWithLog(action: SimpleAction, logger: Logger) {
    logger("Начало выполнения")
    action()
    logger("Конец выполнения")
}

fun main() {
    // Функция без аргументов и возвращаемого значения
    val simpleAction: SimpleAction = {
        println("Действие выполняется!")
    }

    // Логгер в консоль
    val consoleLogger: Logger = { message ->
        println("[LOG] $message")
    }

    // Логгер с временной меткой
    val timestampLogger: Logger = { message ->
        println("[${System.currentTimeMillis()}] $message")
    }

    executeWithLog(simpleAction, consoleLogger)
    println("---")
    executeWithLog(simpleAction, timestampLogger)
}