package examples

// Consumer - только принимает значения (in)
interface Consumer<in T> {
    fun consume(item: T)
}

class AnyConsumer : Consumer<Any> {
    override fun consume(item: Any) {
        println("Потребляем: $item")
    }
}

class NumberConsumer : Consumer<Number> {
    override fun consume(item: Number) {
        println("Число: ${item.toDouble()}")
    }
}

fun main() {
    val anyConsumer: Consumer<Any> = AnyConsumer()
    val numberConsumer: Consumer<Number> = NumberConsumer()

    // Благодаря 'in' мы можем присвоить Consumer<Any> переменной Consumer<String>
    val stringConsumer: Consumer<String> = anyConsumer  // Any является супертипом String - работает!

    // И Consumer<Number> переменной Consumer<Int>
    val intConsumer: Consumer<Int> = numberConsumer     // Number является супертипом Int - работает!

    stringConsumer.consume("Текст")
    intConsumer.consume(100)
}