package ru.otus.qa.bdd.domain

class BankService {

    /** Перевод внутри банка: комиссия не взимается. */
    fun transfer(from: Account, to: Account, amount: Int) {
        require(!to.closed) { "Счет получателя закрыт" }
        require(from.balance >= amount) { "Недостаточно средств" }

        from.balance -= amount
        to.balance += amount

        from.operations += "Списание $amount"
        to.operations += "Зачисление $amount"
    }
}
