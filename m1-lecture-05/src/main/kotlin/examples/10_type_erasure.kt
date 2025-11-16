package examples

// 10_type_erasure.kt
fun checkListType(list: List<*>) {
    when {
        list is List<*> -> println("Это какая-то List")
        else -> println("Это не List")
    }

    // ЭТО НЕ СКОМПИЛИРУЕТСЯ:
    // if (list is List<String>) { } // Error: Cannot check for instance of erased type

    // Но можно проверить первый элемент:
    val first = list.firstOrNull()
    when (first) {
        is String -> println("Первый элемент String: $first")
        is Int -> println("Первый элемент Int: $first")
        else -> println("Первый элемент другого типа: $first")
    }
}

fun main() {
    val stringList = listOf("A", "B", "C")
    val intList = listOf(1, 2, 3)

    checkListType(stringList)
    checkListType(intList)
}