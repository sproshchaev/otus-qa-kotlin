
// Класс с двумя generic - параметрами
class Pair<T, R>(val first: T, val second: R) {
    fun getInfo():String {
        return "$first - $second"
    }
}

fun main() {
    val pair1 = Pair(1, "Cat");
    val pair2 = Pair(2, "Dog");

    println(pair1.getInfo())
    println(pair2.getInfo())

    var stringList = listOf("A", "B", "C") // List<String>

}