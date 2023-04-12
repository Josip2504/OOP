fun main() {

    val lista = listOf<Int>(2, 3, 10)
    val multi = lista.fold(1) { acc, number ->
        acc * number
    }
    println(multi)

}