class MarketPlace(private val users: MutableList<User> = mutableListOf()) {
    val products: MutableList<Product> = mutableListOf()

    fun addUser(user: User){
        users.add(user)
    }

    fun listUsers(): List<User> {
        return users
    }

    fun sellProduct(product: Product, seller: User) {
        seller.sellProduct(product)
        products.add(product)
    }

    fun buyProduct(product: Product, buyer: User) {
        buyer.buyProduct(product, buyer)
        products.remove(product)
    }

}