package examples

class Person(var name: String, val age: Int) {
    val isAdult: Boolean
        get() = age >= 18

    var email: String = ""
        set(value) {
            println("Устанавливаем email: $value")
            field = value
        }

    companion object {
        const val SPECIES = "Homo Sapiens"
    }
}

fun main() {
    val person = Person("Анна", 25)

    // Ссылки на свойства класса
    val nameRef = Person::name
    val ageRef = Person::age
    val isAdultRef = Person::isAdult

    // Ссылки на свойства экземпляра
    val instanceNameRef = person::name
    val instanceAgeRef = person::age

    println("Имя через ссылку: ${nameRef.get(person)}")
    println("Возраст через ссылку: ${ageRef.get(person)}")
    println("Взрослый?: ${isAdultRef.get(person)}")

    // Изменение через ссылку
    nameRef.set(person, "Мария")
    println("Новое имя: ${person.name}")
}