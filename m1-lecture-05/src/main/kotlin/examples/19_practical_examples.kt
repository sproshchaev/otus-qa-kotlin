package examples

// Функция для измерения времени выполнения
fun measureTime(operationName: String, block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    val end = System.currentTimeMillis()
    println("$operationName выполнен за ${end - start} мс")
}

// Функция для работы с ресурсами
fun withResource(resourceName: String, block: (String) -> Unit) {
    println("Открываем ресурс: $resourceName")
    block(resourceName)
    println("Закрываем ресурс: $resourceName")
}

// Функция с единственной лямбдой
fun runWithRetry(maxAttempts: Int = 3, block: () -> Boolean) {
    repeat(maxAttempts) { attempt ->
        println("Попытка ${attempt + 1}")
        if (block()) {
            println("Успех!")
            return
        }
    }
    println("Все попытки провалились")
}

fun main() {
    // Измерение времени
    measureTime("Сложная операция") {
        Thread.sleep(100)
        println("Опция выполнена")
    }

    // Работа с ресурсами
    withResource("database") { resource ->
        println("Работаем с $resource")
        println("Выполняем запрос...")
    }

    // Повторные попытки
    runWithRetry {
        val success = Math.random() > 0.7
        println("Результат операции: $success")
        success
    }
}