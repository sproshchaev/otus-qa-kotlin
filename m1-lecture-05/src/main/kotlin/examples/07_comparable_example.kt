package examples

fun processComparable(x: Comparable<Number>) {
    // Благодаря 'in' в Comparable мы можем присвоить Comparable<Number> переменной Comparable<Double>
    val a: Comparable<Double> = x  // Number является супертипом Double - работает!

    println("Можно сравнить с 10.5: ${a.compareTo(10.5)}")
}

fun main() {
    val numberComparable = object : Comparable<Number> {
        override fun compareTo(other: Number): Int = 0
    }

    processComparable(numberComparable)
}
