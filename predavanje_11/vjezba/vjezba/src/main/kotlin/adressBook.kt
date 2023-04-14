import java.time.temporal.TemporalAmount

class bank (
    private val name: String,
    private val accountNum: String,
    var balance: Int
)
{
    val transaction = mutableListOf<Transactions>()

    fun deposit(amount: Int){
        balance += amount
        println("$amount has been added to $name account")
        transaction.add(Transactions(amount, "deposit"))
        Thread.sleep(1000)
    }

    fun withdraw(amount: Int){
        balance -= amount
        println("$amount has been withdrawn form $name account")
        transaction.add(Transactions(amount, "withdraw"))
        Thread.sleep(1000)
    }

    fun transfer(amount: Int, toAccount: bank){
        balance -= amount
        toAccount.balance += amount
        println("$amount has been transferred from $name account to ${toAccount.name} account")
        transaction.add(Transactions(amount, "Transfer to ${toAccount.name}"))
        toAccount.transaction.add(Transactions(amount, "Transfer from $name"))
        Thread.sleep(1000)

    }

    fun printTransaction(){
        println("Transactions for $name")
        for (transactions in transaction){
            println("- ${transaction}")
        }
    }

    override fun toString(): String {
        return "Name: $name, AccountNumber: $accountNum, Balance: $balance"
    }
}