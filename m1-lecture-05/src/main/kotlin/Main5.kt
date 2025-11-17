
// Функция верхнего уровня
fun greet(name: String): String{
    return "Hello $name"
}

// Функция с двумя параметрами
fun  calculate(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    // переменные функционального типа
    val greetingFunction: (String) -> String = ::greet
    val mathFunction: (Int, Int) -> Int = ::calculate

    println(greetingFunction("Kotlin"))
    println("Сумма: ${mathFunction(1, 2)}")
}