// Дата класс
data class User(
    var name: String = "",
    var age: Int = 0,
    var email: String = ""
) {

    // Переопределить оператор get для удобного получения свойств
    operator fun get(property: String): Any? {
        return when (property) {
            "name" -> name
            "age" -> age
            "email" -> email
            else -> null
        }
    }

    // Переопределение оператора set для удобного присвоения значений
    operator fun set(property: String, value: Any) {
        when (property) {
            "name" -> name = value as String
            "age" -> age = value as Int
            "email" -> email = value as String
        }
    }

}