package examples

import kotlin.concurrent.thread

fun main() {
    println("Thread 1 run ${Thread.currentThread().name}")

    // СПОСОБ 1: Kotlin thread() с SAM-преобразованием
    thread {
        println("Thread 2 run ${Thread.currentThread().name}")
    }.join()

    // СПОСОБ 2: Классический Java подход с Runnable
    val r = Runnable {
        println("Thread 3 run ${Thread.currentThread().name}")
    }
    val t = Thread(r)
    t.start()
    t.join()
}