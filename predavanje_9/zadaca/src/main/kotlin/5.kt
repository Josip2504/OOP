fun main() {
    val lista = mutableListOf<String>("josip", "marko", "ivan")
    val veliko = lista.map {it.uppercase()
    }
    println(veliko)
}