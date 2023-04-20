class Bank (private val users: MutableList<User> = mutableListOf()) {

    fun addUser(user: User){
        users.add(user)
    }

    fun listUsers(){
        for (users in users){
            println(users)
        }
    }

    override fun toString(): String {
        return "Account users: $users"
    }
}