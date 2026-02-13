package ru.otus

fun main() {

    // Обычный break во вложенном цикле
    for (i in 1..3) {
        for (j in 1..3) {
            if (j == 2) break // прерывается только внутренний цикл
            println("i=$i j=$j")
        }
    }

    // Обычный continue во вложенном цикле
    for (i in 1..3) {
        for (j in 1..3) {
            if (j == 2) continue // пропускает j=2 только во внутреннем цикле
            println("i=$i j=$j")
        }
    }

}