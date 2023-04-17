import java.util.InputMismatchException
import java.util.Scanner

fun main() {

    val scanner = Scanner(System.`in`)
    var a = 0
    var b: Int

    println("Enter a num: ")
    var a: Int
    try {
        var a = scanner.nextInt()
    }catch (ex: InputMismatchException){
        println("Must enter a number!")
        scanner.nextLine()
    }

    println("Enter second num: ")
    var b: Int
    try {
        b = scanner.nextInt()
    }catch (ex: InputMismatchException){
        println("Must enter a number!")
        scanner.nextLine()
    }

    if (a == 6 || b == 6){
        println("true")
    }else if (a + b == 6){
        println("true")
    }else{
        println("false")
    }

}