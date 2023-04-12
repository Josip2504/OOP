fun main() {

    val gradovi = mapOf<String, Int>(
        "London" to 9000000,
        "Osijek" to 96000,
        "Oslo" to 630000,
        "Skopje" to 546000,
        "Tokyo" to 14000000,
        "Istambul" to 15000000
        )
    val more = gradovi.filterValues { it ->
        it > 1000000
    }
    println(more.keys)
}