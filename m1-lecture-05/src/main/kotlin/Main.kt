
fun printItemInt(item: Int) {
    println("Элемент: ${item}")
}

fun printItemStr(item: String) {
    println("Элемент: ${item}")
}

fun printItemBool(item: Boolean) {
    println("Элемент: ${item}")
}

// generic: <T> = (T)ype
fun <T> printItem(item: T) {
    println("Элемент: ${item?.javaClass?.simpleName ?: "Unknown"}")
}

fun main() {

    printItemInt(55)
    printItemStr("String")
    printItemBool(true)

    printItem(55)       // T -> Int
    printItem("String") // T -> String
    printItem(true)     // T -> Boolean

}