package examples

// Функция верхнего уровня
fun greet(name: String): String {
    return "Привет, $name!"
}

// Функция с двумя параметрами
fun calculate(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    // Объявляем переменные функционального типа
    val greetingFunction: (String) -> String = ::greet
    val mathFunction: (Int, Int) -> Int = ::calculate

    println(greetingFunction("Котлин"))
    println("Сумма: ${mathFunction(5, 3)}")
}