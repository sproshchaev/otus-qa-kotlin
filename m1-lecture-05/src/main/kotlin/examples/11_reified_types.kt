package examples

inline fun <reified T> checkTypeAndPrint(value: Any) {
    println("Значение: $value")
    println("Тип значения: ${value::class.simpleName}")

    // Благодаря reified можем проверить конкретный generic-тип
    if (value is T) {
        println("✅ Значение является ${T::class.simpleName}")
    } else {
        println("❌ Значение НЕ является ${T::class.simpleName}")
    }
}

inline fun <reified T> filterByType(list: List<Any>): List<T> {
    return list.filterIsInstance<T>()
}

fun main() {
    val mixedList = listOf("Текст", 42, 3.14, "Еще текст", 100)

    // Проверяем тип
    println("=== Проверка типов ===")
    checkTypeAndPrint<String>("Hello")
    checkTypeAndPrint<Int>("Hello") // Покажет, что это не Int
    checkTypeAndPrint<Number>(42)   // Покажет, что это Number

    println("\n=== Фильтрация по типу ===")
    // Фильтруем по типу
    val strings: List<String> = filterByType(mixedList)
    val numbers: List<Int> = filterByType(mixedList)
    val doubles: List<Double> = filterByType(mixedList)

    println("Строки: $strings")
    println("Числа Int: $numbers")
    println("Числа Double: $doubles")
}