class competitor (
    private val admin: String
)
{
    private val popis = mutableListOf<list>()

    fun addCompetitor(
        name: String,
        age: Int,
        city: String
    ) {
        popis.add(list(name, age, city))
        println("$name added to competitor list")
    }

    fun printList(){
        println("All registered competitors: ")
        for (list in popis){
            println("- ${list.name}, ${list.age}, ${list.city}")
        }
    }
}