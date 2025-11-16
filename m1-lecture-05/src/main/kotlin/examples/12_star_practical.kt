package examples

fun processAnyList(list: List<*>) {
    // Можем читать элементы как Any?
    for (item in list) {
        println("Элемент: $item")
    }

    // НО НЕ МОЖЕМ ДОБАВЛЯТЬ:
    // if (list is MutableList<*>) {
    //     list.add("text") // Error: Out-projected type prohibits use
    // }
}

fun main() {
    val stringList = listOf("A", "B", "C")
    val intList = listOf(1, 2, 3)

    processAnyList(stringList)
    processAnyList(intList)

    // Star projection с MutableList
    val mutableStringList = mutableListOf("X", "Y", "Z")
    val starList: MutableList<*> = mutableStringList

    // Читать можно
    println("Первый элемент: ${starList[0]}")

    // Писать НЕЛЬЗЯ - компилятор не знает, какой тип безопасно добавлять
    // starList.add("new") // Ошибка компиляции
}