class Book(name: String, price: Double, val author: String): Product(name, price) {
    override fun getInfo(): String{
        return "$name, by $author: $price"
    }
}