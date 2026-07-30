package ru.otus.qa.bdd.cucumber.parameterized

import io.cucumber.java8.En
import ru.otus.qa.bdd.domain.Account
import ru.otus.qa.bdd.domain.BankService
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class TransferParameterizedStepDefinitions : En {

    private val bank = BankService()
    private lateinit var sender: Account
    private lateinit var receiver: Account
    private var initialSenderBalance = 0

    init {
        Given("На счете отправителя есть {int} рублей") { amount: Int ->
            initialSenderBalance = amount
            sender = Account("Отправитель", amount)
        }
        And("Счет получателя не закрыт") {
            receiver = Account("Получатель", 0)
            assertFalse(receiver.closed)
        }
        When("Отправитель переводит получателю {int} рублей") { amount: Int ->
            bank.transfer(sender, receiver, amount)
        }
        Then("Баланс счета получателя увеличен на {int} рублей") { amount: Int ->
            assertEquals(amount, receiver.balance)
        }
        And("Баланс счета отправителя уменьшен на {int} рублей") { amount: Int ->
            assertEquals(initialSenderBalance - amount, sender.balance)
        }
        And("В списке операций получателя нет списания комиссии") {
            assertFalse(receiver.operations.any { it.contains("Комиссия") })
        }
    }
}
