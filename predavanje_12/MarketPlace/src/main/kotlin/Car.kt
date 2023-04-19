class Car(name: String, price: Double, val color: String): Product(name, price) {
    override fun getInfo(): String {
        return "car: $name of a $color for a: $price"
    }
}