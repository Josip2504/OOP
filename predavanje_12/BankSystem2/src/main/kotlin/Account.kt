open class Account(var balance: Double) {

    open fun getInfo(): String{
        return "$balance"
    }

    override fun toString(): String {
        return getInfo()
    }

}