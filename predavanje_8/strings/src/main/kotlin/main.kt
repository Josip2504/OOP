import java.util.InputMismatchException
import java.util.Scanner
import kotlin.system.exitProcess

fun main() {
    var scanner = Scanner(System.`in`)
    var selectedApp = -1

    while (true) {
        println("Select an App:")
        println("""
            1. Reverser
            2. Number of vowels
            3. Replacer
            4. Palindrome
            5. Exit
        """.trimIndent())

        try {
            selectedApp = scanner.nextInt()
        }catch (ex: InputMismatchException) {
            val invalidInput = scanner.nextInt()
            println("$invalidInput is not a number!")
            continue
        }
        when (selectedApp) {
            1 -> {}
            2 -> {}
            5 -> exitProcess(status = 1)

        }
    }
}