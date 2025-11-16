package examples

class Pair<T, R>(val first: T, val second: R) {
    fun getInfo(): String {
        val firstType = first?.let { it::class.simpleName } ?: "Unknown"
        val secondType = second?.let { it::class.simpleName } ?: "Unknown"
        return "First: $first ($firstType), Second: $second ($secondType)"
    }
}

fun main() {
    val pair1 = Pair(1, "Кот")
    val pair2 = Pair("Строка", listOf(1, 2, 3))
    val pair3 = Pair(null, 42) // Теперь работает и с null

    println(pair1.getInfo())
    println(pair2.getInfo())
    println(pair3.getInfo())
}