import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    println("Enter a number: ")
    try {
        var num = scanner.nextInt()
        if (num in 90..110 || num in 190..210) {
            println("True")
        } else {
            println("False")
        }
    } catch (e: InputMismatchException) {
        println("Must enter a number!")
    }
}


