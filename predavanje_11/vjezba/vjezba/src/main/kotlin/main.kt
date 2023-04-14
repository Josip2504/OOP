fun main() {

    val josipAccount = bank(
        "Josip",
        "1215231",
        4000
    )
    val markoAccount = bank(
        "Marko",
        "31458111",
        3000
    )

    josipAccount.transfer(400, markoAccount)
    josipAccount.deposit(1000)
    markoAccount.withdraw(700)
    josipAccount.printTransaction()
    println("-----------")
    markoAccount.printTransaction()
}