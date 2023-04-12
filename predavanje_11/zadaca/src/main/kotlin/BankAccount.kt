class BankAccount (
    private val accountNumber: String,
    private val accountName: String,
    private var balance: Double
)
    {
        private val transaction = mutableListOf<Transaction>()

        fun deposit(amount: Double) {
            balance += amount
//            println("$amount added to $accountName")
            transaction.add(Transaction(amount, "deposit"))
        }

        fun withdrawal(amount: Double) {
            balance -= amount
//            println("$amount was withdrawn from $accountName account")
            transaction.add(Transaction(amount, "withdrawal"))
        }

        fun transfer(amount: Double, toAccount: BankAccount) {
            balance -= amount
            toAccount.balance += amount
//            println("$amount was transfered form $accountName to ${toAccount.accountName}")
            transaction.add(Transaction(amount, "transfer to ${toAccount.accountName}"))
            toAccount.transaction.add(Transaction(amount, "transfer from $accountName"))
        }

        fun printTranasction(){
//            println("Transiction history for $accountName")
            for (transaction in transaction) {
                println("- ${transaction.type}: ${transaction.amount}")
            }
        }

        override fun toString(): String {
            return "Account number: $accountName, Account holder: $accountNumber, Balance: $balance"
        }
    }