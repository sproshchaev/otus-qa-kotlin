package examples

fun main() {
    // Компилятор автоматически выводит тип для listOf
    val stringList = listOf("А", "Б", "В")        // List<String>
    val intList = listOf(1, 2, 3)                 // List<Int>

    // И для итератора тоже
    val iterator = stringList.iterator()          // Iterator<String>

    println("stringList тип: ${stringList::class.simpleName}")
    println("intList тип: ${intList::class.simpleName}")
    println("iterator тип: ${iterator::class.simpleName}")
}
