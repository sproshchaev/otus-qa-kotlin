package examples

data class User(val name: String, val age: Int)

typealias UserFilter = (User) -> Boolean

fun filterUsers(users: List<User>, filter: UserFilter): List<User> {
    return users.filter(filter)
}

fun main() {
    val users = listOf(
        User("Анна", 25),
        User("Борис", 17),
        User("Виктор", 30),
        User("Дарья", 16)
    )

    // Взрослые пользователи
    val adultsFilter: UserFilter = { it.age >= 18 }

    // Пользователи с именем на "В"
    val nameFilter: UserFilter = { it.name.startsWith("В") }

    println("Все взрослые:")
    println(filterUsers(users, adultsFilter))

    println("\nИмена на 'В':")
    println(filterUsers(users, nameFilter))

    // Лямбда прямо в вызове
    println("\nМолодые (до 20):")
    println(filterUsers(users) { user -> user.age < 20 })
}