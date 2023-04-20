fun main() {

    val bank = Bank()

    val user1 = User("Josip")
    val user2 = User("Pero")

    bank.addUser(user1)
    bank.addUser(user2)

    user1.addAccount(Tekuci(100.0))
    user1.addAccount(Ziro(1000.0))

    user2.addAccount(Tekuci(300.0))
    user2.addAccount(Ziro(200.0))





}