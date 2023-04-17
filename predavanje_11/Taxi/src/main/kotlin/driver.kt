class driver(
    private val name: String,
    var balance: Int
)
{
    var list = mutableListOf<list>()

    fun ride(
        customer: String,
        distance: Int,
        price: Int
    ) {
        balance += price
        list.add(list(customer, distance, price))
    }

    fun printList(){
        println("Povijest voznji od $name: ")
        for (list in list){
            println("Ime: ${list.customer}, Udaljenost: ${list.distance}km, ${list.price} eura")
        }
    }

    override fun toString(): String {
        return "Vozac: $name, Balacne: $balance"
    }

}