class Tekuci(type: String,balance: Double): Account(type, balance) {

    override fun getInfo(): String {
        return "Account: $type, balance: $balance"
    }
}