// upper bounds

// T должен быть Comparable (возможность сравнения)
// fun <T>
fun <T : Comparable<T>> max(a: T, b: T): T {
    return if (a > b) a else b
}

// Можно ограничить конкретным классом
class Container<T : Number>(val value: T) {
    fun doubleValue(): Double = value.toDouble() * 2


}

fun main() {
    println(max(10, 20))    // Int - Comparable
    println(max("A", "B"))  // String - Comparable

    val intContainer = Container(42)
    val doubleContainer = Container(42.5)
    // val stringContainer = Container("Строка") // Cannot infer type for type parameter 'T'
    // println(max(intContainer, doubleContainer))

}