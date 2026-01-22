import kotlin.concurrent.thread

fun main() {
    val producer = SimpleProducer()

    try {
        // Отправка нескольких сообщений
        repeat(10) { index ->
            val message = "Hello Kafka from Kotlin! Message #$index"
            producer.sendMessage("key-$index", message)
            println("Sent: $message")

            Thread.sleep(1000) // Задержка 1 секунда между сообщениями
        }

        // Пример асинхронной отправки
        thread {
            repeat(5) { index ->
                producer.sendMessage("async-key-$index", "Async message #$index")
                Thread.sleep(500)
            }
        }

        // Даем время на асинхронную отправку
        Thread.sleep(3000)

    } finally {
        producer.close()
    }
}