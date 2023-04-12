fun main() {

    val matejsAccount = BankAccount(
        "123456789",
        "Matej Đuroković",
        1000.0
    )

    val perosAccount = BankAccount(
        "123456987",
        "Pero Perić",
        5000.0
    )
//    println(matejsAccount.toString())
//    println(perosAccount.toString())

    matejsAccount.deposit(500.0)
//    println(matejsAccount.toString())

    matejsAccount.withdraw(300.0)
//    println(matejsAccount.toString())

    matejsAccount.transfer(300.0, perosAccount)

    matejsAccount.printTransactions()
    println("----------------")
    perosAccount.printTransactions()

//    println(matejsAccount.toString())
//    println(perosAccount.toString())
}