fun main(args: Array<String>){
//                             0  1  2  3  4
    var numbers = arrayOf<Int>(1, 2, 3, 4, 5)

    for(number in numbers){
//        println(number)
    }

//    println("Broj prije promjene "+numbers[1])
    numbers[2] = 200
//    println("Broj poslje" + numbers[1])

    // Lambda functions
    numbers.forEach { number ->
//        println("${number+1} is a number from numbers uvecan za 1")
    }

    val someNumbers = Array<Int>(4) { 0 }
//    println( someNumbers.size)



    // Lists
    var numbersList = listOf(1, 2, 3, "Four", 5)
    var mutableNumbersList = mutableListOf(1, 2, 3, "4")

    numbersList.forEach { number ->
//        println(number)
    }

    // Dodavanje u listu
    mutableNumbersList.add(0, "One")

    // Promjena u listi
    mutableNumbersList[1] = 100

    mutableNumbersList.forEach { number ->
//        println(number)
    }

    // Sets
    var numbersSet = setOf<Int>(1, 2, 3, 4, 5, 1, 2, 3, 6)

    numbersSet.forEach {number ->
//        print("$number, ")
    }

    // Maps
    var numbersMap = mapOf<Int, String>(8 to "one", 2 to "two", 3 to "three")

    numbersMap.forEach { entry ->
//        println("${entry.key}, belongs to ${entry.value}")
    }

    var beersCount = mutableMapOf<String, Int>(
        "Ozujsko" to 10,
        "Karlovacko" to 8,
        "Staropramen" to 11
    )

    println("Na lageru imamo: ")
    beersCount.forEach { beerEntry ->
        println("${beerEntry.key}: ${beerEntry.value}")
    }

    println("Kupac je popio dva piva, staropramen i karlovacko")
    beersCount = kupacPopijePivo("Staropramen", beersCount)
    beersCount = kupacPopijePivo("Karlovacko", beersCount)

    println("Na lageru imamo: ")
    beersCount.forEach { beerEntry ->
        println("${beerEntry.key}: ${beerEntry.value}")
    }

//    println(numbersMap[2])





}

fun kupacPopijePivo(pivo: String, beersCount: MutableMap<String, Int>): MutableMap<String, Int> {
    var currentState = beersCount[pivo]?:-1
    if(currentState == -1){
        println("Nesto je poslo po krivu!")
        return beersCount
    }
    currentState -= 1
    beersCount[pivo] = currentState
    return beersCount
}
