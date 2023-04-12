fun main() {

    val josipAccount = BankAccount(
        "123456789",
        "Josip Samardzic",
        1000.0
    )
    val markoAccount = BankAccount(
        "18648374",
        "Marko Horvat",
        2000.0
    )

    josipAccount.deposit(500.0)

    markoAccount.withdrawal(700.0)

    josipAccount.transfer(200.0, markoAccount)

    josipAccount.printTranasction()
    println("-----------------")
    markoAccount.printTranasction()
}