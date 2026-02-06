package ru.otus

import kotlin.math.sign

/**
 * Здесь Javadoc
 */
fun main() {

    // 1. Сохранение промежуточного результата
    val price = 100
    val tax = 20
    val total = price + tax // Промежуточный результат
    println("Итого: $total") // Итого: 120

    // 2. Строгая типизация
    val age: Int = 25
    // age = "Двадцать пять"

    // 3. Область видимости
    if (total > 100) { // начало блока кода
        val messageStr = "Дорого!"
        println(messageStr) // Дорого!
    } // конец блока кода
    // println(messageStr) - переменная вне области видимости

    // 4. Явное и косвнное определение типа
    val name: String = "Анна" // явное определение типа (мы указали String)
    val count = 10 // выведение типа компилятором на основе значения которое мы инициализируем
    println("Имя: $name, количество: $count") // Имя: Анна, количество: 10

    // 5. val - неизменяемая переменная
    val expectedStatus = "SUCCESS"
    // expectedStatus = "" - нельзя изменять

    // 6. var - можно изменять
    var actualStatus = "SUCCESS"
    actualStatus = " PENDING"
    println(actualStatus)

    // 7. lateinit
    lateinit var testData: String
    //println(testData)
    testData = "!!!"
    println(testData)

    // 8. Any - может хранить все
    var flexibleVar: Any = 42
    flexibleVar = "Теперь строка"
    flexibleVar = true
    println(flexibleVar) // true

    // 9. Unit и Nothing
    fun doSomething(): Unit {
        println("Run...")
    }

    doSomething()

    fun neverReturn(): Nothing {
        throw RuntimeException("Never return")
    }
    // neverReturn()

    // 10. Имена переменных
    // val 1user = "Alice"
    val user1 = "Alice"

    val `login val` = true

    val имя = "Борис"

    // var user+name = "Bob"
    var `user+name` = "Bob"

    val expectedStatus2 = true

    // 11. Типы
    val age2: Int = 25

    val count2: UInt = 10u

    val price2: Double = 12.34
    val price3: Float = 12.345f

    val isPassed: Boolean = false

    val hex = 0xFF
    val binary = 0B1010
    val longNum = 1000L

    val letter = 'a'
    val message2 = "Hello!"

    // 12. Хранение нескольких значений
    val person = Pair("Иван", 22)
    val (name3, age3) = person
    println("Имя $name3 возраст $age3") // Имя Иван возраст 22

    val user = Triple("Alice", "Alice", 22)
    val (name4, lastName4, age4) = user
    println("$name4 $lastName4 $age4") // Alice Alice 22

    val result = Pair(200, "OK")
    val (code, _) = result
    println("Код ответа $code") // Код ответа 200

    // 13. Математические операторы
    var total2 = 10;
    // total2 = total2 + 5
    total2 += 5

    println((10).sign) // 1
    println((-10).sign) // -1

    // 14. Null/ не Null
    var userName: String? = null
    // var userNameNotNull: String = null

    val length = userName?.length

    // !! - небезопасный вызов
    val length2 = userName!!.length

    val displayName = userName ?: "Alice"

    val message = userName?.uppercase() ?: "Неизвестно"




}