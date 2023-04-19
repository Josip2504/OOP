open class Account(val type: String, var balance: Double) {

    open fun getInfo(): String{
        return "$type: $balance"
    }

    override fun toString(): String {
        return getInfo()
    }

}