package examples

// T должен быть Comparable (можно сравнивать)
fun <T : Comparable<T>> max(a: T, b: T): T {
    return if (a > b) a else b
}

// Можно ограничить конкретным классом
class Container<T : Number>(val value: T) {
    fun doubleValue(): Double = value.toDouble() * 2
}

fun main() {
    println(max(10, 20))        // Работает - Int реализует Comparable
    println(max("A", "B"))      // Работает - String реализует Comparable
    // println(max(10, "text")) // Ошибка! Разные типы, не компилируется

    val intContainer = Container(42)
    val doubleContainer = Container(3.14)
    // val stringContainer = Container("text") // Ошибка! String не Number

    println("Удвоенное значение: ${intContainer.doubleValue()}")
}