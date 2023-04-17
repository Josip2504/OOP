fun main() {

    val josip = driver(
        "Josip Samardzic",
        0
    )
    val pero = driver(
        "Pero Peric",
        0
    )

    josip.ride("Ivan", 5, 5)
    pero.ride("Karlo", 2, 3)
    josip.ride("Marko", 2, 3)
    pero.ride("Sara", 10, 7)

    println(josip.toString())
    println(pero.toString())

    josip.printList()
    println("-------------------")
    pero.printList()
}