
fun main() {

    // Создание User через DSL
    val user = user {
        "name" to "John Doe"
        "age" to 30
        "email" to "john.doe@example.com"
    }

    println(user) // User(name=John Doe, age=30, email=john.doe@example.com)

    // Альтернативный способ
    val user2 = user {
        name = "Richard Roe"
        age = 32
        email = "richard.roe@example.com" // User(name=Richard Roe, age=32, email=richard.roe@example.com)
    }

    println(user2)

    // Деструктуризация
    val(userName, userAge, userEmail) = user
    println("Name: $userName, Age: $userAge, Email: $userEmail") // Name: John Doe, Age: 30, Email: john.doe@example.com

    println("User name: ${user["name"]}")
    user["email"] = "new.email@example.com" // установили через set
    println("Updated email ${user.email}") // Updated email new.email@example.com


}