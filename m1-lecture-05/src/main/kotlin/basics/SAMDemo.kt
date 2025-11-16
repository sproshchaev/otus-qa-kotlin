package basics

import kotlin.concurrent.thread

fun main() {
    println("Thread 1 run ${Thread.currentThread().name}")

    thread(name = "Custom-Thread-2") {
        println("Thread 2 run ${Thread.currentThread().name}")
    }.join()

    val t = Thread({
        println("Thread 3 run ${Thread.currentThread().name}")
    }, "Custom-Thread-3")
    t.start()
    t.join()
}