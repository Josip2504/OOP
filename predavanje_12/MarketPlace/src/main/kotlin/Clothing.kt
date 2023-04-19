class Clothing(name: String, price: Double, val size: String): Product(name, price) {
    override fun getInfo(): String{
        return "$name ($size): $price"
    }
}