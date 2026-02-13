package ru.otus

/**
 * Пример использования if как выражения (вместо тернарного оператора)
 */
fun main() {

    // Присвоение значения
    val age = 19
    val category = if (age < 18) "Ребенок" else "Взрослый"
    println("Категория: $category")

    // Использование в return
    fun getFee(isMember: Boolean): Int {
        return if (isMember) 100 else 250
    }
    println("Взнос для участника: ${getFee(true)}")
    println("Взнос для гостя: ${getFee(false)}")

    // if с блоками кода: последнее выражение в блоке становится результатом
    var hour = 15
    val greeting = if (hour < 12) {
        println("Утро")
        "Доброе утро"
    } else if (hour < 18) {
        println("День")
        "Добрый день"
    } else {
        println("Вечер")
        "Добрый вечер"
    }
    println(greeting)

    // Разные типы в ветках - общий тип Any?
    val maybeNumber: Any? = if (age > 0) age else null
    println(maybeNumber)

    // if как аргумент функции
    fun describe(length: Int) = "Длина: $length"
    val list = listOf(1, 2, 3)
    println(describe(if (list.isNotEmpty()) list.size else 0))

}