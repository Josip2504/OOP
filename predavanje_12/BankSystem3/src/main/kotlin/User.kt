class User(private val name: String) {

    private val accounts: MutableList<Account> = mutableListOf()

    fun addAccount(account: Account){
        accounts.add(account)
    }
    fun getInfo(){
        println(Tekuci().balance)
    }
}