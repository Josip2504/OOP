class BankAccount(
    private val accountNumber: String,
    private val accountHolder: String,
    private var balance: Double
) {
    private val transactions = mutableListOf<Transaction>()

    fun deposit(amount: Double){
        balance += amount
        transactions.add(Transaction(amount, "Deposit"))
//        println("Added $amount to the account! New Balance: $balance")
    }

    fun withdraw(amount: Double) {
        balance -= amount
        transactions.add(Transaction(amount, "Withdrawal"))
//        println("Withdrew $amount from the account! New Balance: $balance")
    }

    fun transfer(amount: Double, toAccount: BankAccount){
        balance -= amount
        toAccount.balance += amount
        transactions.add(Transaction(amount, "Transfer to ${toAccount.accountHolder}"))
        toAccount.transactions.add(Transaction(amount, "Transfer from $accountHolder"))
//        println("Transferred $amount from $accountHolder to ${toAccount.accountHolder}!")
    }

    fun printTransactions(){
        println("Transaction history for account $accountNumber")
        for (transaction in transactions) {
            println("- ${transaction.type}: ${transaction.amount}")
        }
    }

    override fun toString(): String {
        return "Account number: $accountNumber, Account Holder: $accountHolder, Balance: $balance"
    }

}