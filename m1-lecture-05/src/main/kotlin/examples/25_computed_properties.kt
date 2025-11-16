package examples

class Rectangle(val width: Double, val height: Double) {
    // Вычисляемое свойство (только getter)
    val area: Double
        get() {
            println("   ⚡ Вычисляется area...")
            return width * height
        }

    // Программно-определяемое свойство (custom setter)
    var scale: Double = 1.0
        set(value) {
            println("   ⚡ Custom setter scale: $field -> $value")
            field = value
        }

    // Свойство с логикой в getter и setter
    var description: String = ""
        get() {
            println("   ⚡ Custom getter description")
            return "Прямоугольник ${width}x${height} (площадь: $area)"
        }
        set(value) {
            println("   ⚡ Custom setter description: '$value'")
            field = "🔷 $value"
        }
}

fun demonstrateProperties(rect: Rectangle) {
    println("1. Обычные свойства:")
    println("   width: ${rect.width}")
    println("   height: ${rect.height}")

    println("\n2. Вычисляемое свойство (area):")
    println("   area: ${rect.area}") // Сработает getter
    println("   area снова: ${rect.area}") // Getter сработает снова

    println("\n3. Custom setter (scale):")
    rect.scale = 2.5
    println("   scale: ${rect.scale}")

    println("\n4. Custom getter/setter (description):")
    println("   description: ${rect.description}")
    rect.description = "Супер прямоугольник"
    println("   после установки: ${rect.description}")
}

fun main() {
    val rect = Rectangle(5.0, 3.0)

    println("=== Демонстрация вычисляемых и программных свойств ===\n")
    demonstrateProperties(rect)
}