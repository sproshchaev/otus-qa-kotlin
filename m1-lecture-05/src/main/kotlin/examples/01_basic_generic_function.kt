package examples

// Объявляем generic-функцию
fun <T> printItem(item: T) {
    println("Элемент: $item (тип: ${item?.javaClass?.simpleName ?: "Unknown"})")
}

fun main() {
    // Используем с разными типами - компилятор сам выводит T
    printItem(42)        // T выводится как Int
    printItem("Hello")   // T выводится как String
    printItem(true)      // T выводится как Boolean
}