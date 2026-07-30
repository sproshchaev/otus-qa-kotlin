package ru.otus.qa.bdd.spek

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import ru.otus.qa.bdd.domain.Account
import ru.otus.qa.bdd.domain.BankService
import kotlin.test.assertEquals
import kotlin.test.assertFalse

object TransferGherkinStyleSpec : Spek({

    Feature("Переводы между клиентами банка") {

        val bank by memoized { BankService() }
        val sender by memoized { Account("Отправитель", 1000) }
        val receiver by memoized { Account("Получатель", 0) }

        Scenario("При переводе клиенту банка не должна быть списана комиссия") {

            Given("На счете отправителя есть 1000 рублей") {
                assertEquals(1000, sender.balance)
            }
            And("Счет получателя не закрыт") {
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
})
