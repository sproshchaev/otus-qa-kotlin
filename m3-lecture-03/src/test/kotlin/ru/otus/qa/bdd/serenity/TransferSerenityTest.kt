package ru.otus.qa.bdd.serenity

import net.serenitybdd.junit.runners.SerenityRunner
import net.thucydides.core.annotations.Steps
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(SerenityRunner::class)
class TransferSerenityTest {

    @Steps
    lateinit var transfer: TransferSteps

    @Test
    fun `при переводе клиенту банка не должна быть списана комиссия`() {
        transfer.senderHasBalance(1000)
        transfer.receiverAccountIsOpen()
        transfer.transfers(800)
        transfer.receiverBalanceIncreasedBy(800)
        transfer.senderBalanceDecreasedBy(800)
        transfer.noCommissionInReceiverOperations()
    }
}
