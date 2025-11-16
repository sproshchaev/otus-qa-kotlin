package examples

import java.util.concurrent.Callable
import java.util.function.Consumer
import java.util.function.Predicate

fun main() {
    println("=== Интеграция с Java библиотеками ===")

    // Callable из java.util.concurrent
    val callable = Callable {
        "Результат из Callable"
    }

    println("Callable: ${callable.call()}")

    // Consumer из java.util.function
    val names = listOf("Анна", "Борис", "Виктор")
    val consumer = Consumer<String> { name ->
        println("Обрабатываем: $name")
    }

    println("\nConsumer:")
    names.forEach(consumer)

    // Predicate из java.util.function
    val predicate = Predicate<String> { it.length > 4 }
    val filteredNames = names.filter(predicate::test)

    println("\nPredicate (длина > 4): $filteredNames")
}