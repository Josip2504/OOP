fun main(args: Array<String>) {
    val marketPlace = MarketPlace()

    val user1 = User("Pero", 100.0)
    val user2 = User("Ivo", 50.0)

    val book1 = Book("the Great Gatsby", 10.0, "Scott Fitzgerald")
    val clothing = Clothing("Red T-Shirt", 5.0, "M")
    val car = Car("BMW", 100.0, "Black")

    marketPlace.addUser(user1)
    marketPlace.addUser(user2)

    user1.addProduct(book1)
    user2.addProduct(clothing)
    user2.addProduct(car)

    println("Before purchase")
    println("User 1: ${user1.listBooks()}")
    println("User 2: ${user2.listBooks()}")

    marketPlace.sellProduct(book1, user1)
    marketPlace.sellProduct(car, user2)
    marketPlace.buyProduct(book1, user2)

    println("Marketplace products:")
    for (product in marketPlace.products) {
        println(product)
    }

    marketPlace.buyProduct(car, user2)

    println("After purchase")
    println("User 1: ${user1.listBooks()}")
    println("User 2: ${user2.listBooks()}")



}
