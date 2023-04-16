fun main() {

    val admin = competitor(
        "admin"
    )

    admin.addCompetitor(
        "Josip Samardzic",
        22,
        "Osijek"
    )

    admin.addCompetitor(
        "Hrvoje Basic",
        32,
        "Zagreb"
    )

    admin.printList()

}