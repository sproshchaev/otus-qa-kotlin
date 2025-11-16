package examples

fun processNumbers(numbers: List<Int>, operation: (Int) -> Int): List<Int> {
    return numbers.map(operation)
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    // Полная форма лямбды
    val squared = processNumbers(numbers) { x -> x * x }

    // С использованием 'it' (один аргумент)
    val doubled = processNumbers(numbers) { it * 2 }

    // Лямбда без аргументов
    val constantProvider: () -> Int = { 42 }

    println("Исходные: $numbers")
    println("Квадраты: $squared")
    println("Удвоенные: $doubled")
    println("Константа: ${constantProvider()}")
}