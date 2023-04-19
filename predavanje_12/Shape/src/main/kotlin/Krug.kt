class Krug(name: String): Shape(name) {

    override fun opseg() {
        println("Opseg $name je 2rπ")
    }

    override fun povrsina() {
        println("Povrsina $name je r^2π")
    }
}