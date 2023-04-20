class Ziro(balance: Double): Account(balance) {

    override fun getInfo(): String {
    return "balance: $balance"
    }
}