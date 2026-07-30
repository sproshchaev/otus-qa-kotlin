package ru.otus.qa.bdd.cucumber.literal

import io.cucumber.java8.En
import ru.otus.qa.bdd.domain.Account
import ru.otus.qa.bdd.domain.BankService
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class TransferLiteralStepDefinitions : En {

    private val bank = BankService()
    private lateinit var sender: Account
    private lateinit var receiver: Account

    init {
        Given("На счете отправителя есть 1000 рублей") {
            sender = Account("Отправитель", 1000)
        }
        And("Счет получателя не закрыт") {
            receiver = Account("Получатель", 0)
            assertFalse(receiver.closed)
        }
        When("Отправитель переводит получателю 800 рублей") {
            bank.transfer(sender, receiver, 800)
        }
        Then("Баланс счета получателя увеличен на 800 рублей") {
            assertEquals(800, receiver.balance)
        }
        And("Баланс счета отправителя уменьшен на 800 рублей") {
            assertEquals(200, sender.balance)
        }
        And("В списке операций получателя нет списания комиссии") {
            assertFalse(receiver.operations.any { it.contains("Комиссия") })
        }
    }
}
