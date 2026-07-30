package ru.otus.qa.bdd.spek

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import ru.otus.qa.bdd.domain.Account
import ru.otus.qa.bdd.domain.BankService
import kotlin.test.assertEquals

object TransferSpecificationStyleSpec : Spek({

    describe("Переводы между клиентами банка") {

        val bank by memoized { BankService() }
        val sender by memoized { Account("Отправитель", 1000) }
        val receiver by memoized { Account("Получатель", 0) }

        context("перевод клиенту того же банка") {

            it("увеличивает баланс получателя на сумму перевода") {
                bank.transfer(sender, receiver, 800)
                assertEquals(800, receiver.balance)
            }

            it("уменьшает баланс отправителя на сумму перевода") {
                bank.transfer(sender, receiver, 800)
                assertEquals(200, sender.balance)
            }
        }
    }
})
