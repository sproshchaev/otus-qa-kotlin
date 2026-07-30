package ru.otus.qa.bdd.serenity

import net.thucydides.core.annotations.Step
import ru.otus.qa.bdd.domain.Account
import ru.otus.qa.bdd.domain.BankService
import kotlin.test.assertEquals
import kotlin.test.assertFalse

open class TransferSteps {

    private val bank = BankService()
    private lateinit var sender: Account
    private lateinit var receiver: Account

    @Step("На счете отправителя есть {0} рублей")
    open fun senderHasBalance(amount: Int) {
        sender = Account("Отправитель", amount)
    }

    @Step("Счет получателя не закрыт")
    open fun receiverAccountIsOpen() {
        receiver = Account("Получатель", 0)
        assertFalse(receiver.closed)
    }

    @Step("Отправитель переводит получателю {0} рублей")
    open fun transfers(amount: Int) {
        bank.transfer(sender, receiver, amount)
    }

    @Step("Баланс счета получателя увеличен на {0} рублей")
    open fun receiverBalanceIncreasedBy(amount: Int) {
        assertEquals(amount, receiver.balance)
    }

    @Step("Баланс счета отправителя уменьшен на {0} рублей")
    open fun senderBalanceDecreasedBy(amount: Int) {
        assertEquals(1000 - amount, sender.balance)
    }

    @Step("В списке операций получателя нет списания комиссии")
    open fun noCommissionInReceiverOperations() {
        assertFalse(receiver.operations.any { it.contains("Комиссия") })
    }
}
