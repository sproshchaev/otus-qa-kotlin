
class Rectangle(private val width: Int, private val height: Int) {

    val area = {
            println("get aria")
            this.width * this.height
        }
}

fun main() {
    val rect = Rectangle(5, 5)
    println(rect.area.invoke())
}