open class Product(val name: String, var price: Double) {
    open fun getInfo(): String{
        return "$name: $price"
    }

    override fun toString(): String {
        return getInfo()
    }
}