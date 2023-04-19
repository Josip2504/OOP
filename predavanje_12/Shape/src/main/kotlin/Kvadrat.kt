class Kvadrat(name: String,): Shape(name){

    override fun povrsina() {
        println("Povrsina $name je a*a")
    }

    override fun opseg() {
        println("Opseg $name je 4a")
    }

}