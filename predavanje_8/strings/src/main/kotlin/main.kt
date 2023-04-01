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
            val invalidInput = scanner.next()
            println("$invalidInput is not a number!")
            continue
        }
        when (selectedApp) {
            1 -> reverser(scanner)
            2 -> NumberOfVowels(scanner)
            3 -> replacer(scanner)
            4 -> palindrome(scanner)
            5 -> {
                println("Thanks for using app")
                exitProcess(1)
            }
            else -> {
                println("Unknown input")
                continue
            }

        }
        Thread.sleep(3000)
    }
}

fun palindrome(scanner: Scanner) {
    println("Give me a word that you wanna check is it a palindrome:")

    var input = scanner.next()
    input += scanner.nextLine()

    val reverseInput = input.reversed()

    if (input.lowercase().replace(" ","") == reverseInput.lowercase().replace(" ","")) {
        println("$input is a palindrome")
    }else{
        println("$input is not a palindrome")
    }

}

fun replacer(scanner: Scanner) {
    var input = ""
    println("Give me a word you want to edit:")

    input += scanner.next()
    input += scanner.nextLine()

    println("Give me a character you want to edit:")
    val oldChar = scanner.next()[0]

    println("Give me a char you what to replace with")
    val newChar = scanner.next()[0]

    var result = ""
    for(char in input) {
        if(char == oldChar){
            result += newChar
        }else {
            result += char
        }
    }
    println("Result: $result")
}

fun NumberOfVowels(scanner: Scanner) {
    println("Give me a word that you want to count vowels")
    val input = scanner.next()
    var counter = 0
    for(character in input) {
        if (
            character == 'a' ||
            character == 'e' ||
            character == 'i' ||
            character == 'o' ||
            character == 'u'
        ){
            counter++
        }
    }
    println("Number of vowles in $input is $counter")

}

fun reverser(scanner: Scanner) {
    println("Give me a word that you want to reverse:")
    val input = scanner.next()
    println(input.reversed())
}
