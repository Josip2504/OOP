fun main() {

    val bank = Bank()

    val user1 = User("Josip")
    val user2 = User("Pero")

    bank.addUser(user1)
    bank.addUser(user2)

    user1.addAccount("Tekuci")

}