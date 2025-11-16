
fun OddListFun(list: List<Any>): List<Any> {
    return list.filterIndexed { i,_ -> i % 2 == 1 }
}

fun OddListFunInt(list: List<Int>): List<Int> {
    return list.filterIndexed { i,_ -> i % 2 == 1 }
}

fun <T> NotRememberType(list: List<T>) {
//     val t = T::class
}

inline fun <reified T> RememberType () {
    val t = T::class.java.constructors.first()
}

fun main() {

    val elements: List<Int> = listOf(1, 2, 3, 4)
    val elements3: List<Number> = listOf(1, 2, 3, 4)

    val m = mapOf("1" to 2)

//    val mElements:MutableList<Number> = mutableListOf<Int>(1, 2, 3)

    val elements2 = listOf("1", "3")

    println(OddListFunInt(elements))
    println(OddListFun(elements2))

}