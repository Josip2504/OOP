class User(val name: String, var balance: Double = 0.0) {
    private val product: MutableList<Product> = mutableListOf()

    fun addProduct(product: Product) {
        this.product.add(product)
    }
    fun removeProduct(book: Product){
        product.remove(book)
    }

    fun sellProduct(product: Product){
        if(product in this.product){
            balance += product.price
            removeProduct(product)
        }
    }

    fun buyProduct(product: Product, seller: User) {
        if (balance >= product.price) {
            balance -= product.price
            seller.balance += product.price
            seller.removeProduct(product)
            addProduct(product)
        }
    }

    fun listBooks(): List<Product>{
        return product
    }
}