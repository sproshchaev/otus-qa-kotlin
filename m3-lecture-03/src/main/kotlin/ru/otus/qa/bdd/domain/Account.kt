package ru.otus.qa.bdd.domain

class Account(
    val owner: String,
    var balance: Int,
    var closed: Boolean = false
) {
    val operations = mutableListOf<String>()
}
