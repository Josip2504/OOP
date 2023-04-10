fun main() {
    val lista = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7)
    lista.removeIf { it % 2 == 0 }
    println(lista)
}