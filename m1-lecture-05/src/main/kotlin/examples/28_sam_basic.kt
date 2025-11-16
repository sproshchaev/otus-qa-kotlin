package examples

fun main() {
    println("=== Базовые SAM-интерфейсы ===")

    // Runnable - классический SAM-интерфейс
    val runnable = Runnable {
        println("Выполняется в Runnable")
    }

    println("Создали Runnable через лямбду")
    runnable.run()

    // Использование в потоке
    val thread = Thread {
        println("Выполняется в потоке")
    }
    thread.start()
}