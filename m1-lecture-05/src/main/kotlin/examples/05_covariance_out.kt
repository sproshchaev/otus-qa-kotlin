package examples

// Producer - только возвращает значения (out)
interface Producer<out T> {
    fun produce(): T
}

class StringProducer : Producer<String> {
    override fun produce(): String = "Hello"
}

class IntProducer : Producer<Int> {
    override fun produce(): Int = 42
}

fun main() {
    val stringProducer: Producer<String> = StringProducer()
    val intProducer: Producer<Int> = IntProducer()

    // Благодаря 'out' мы можем присвоить Producer<String> переменной Producer<Any>
    val anyProducer1: Producer<Any> = stringProducer  // String является подтипом Any - работает!
    val anyProducer2: Producer<Any> = intProducer     // Int является подтипом Any - тоже работает!

    println(anyProducer1.produce())
    println(anyProducer2.produce())
}