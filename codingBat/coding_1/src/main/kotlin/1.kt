import java.util.InputMismatchException
import java.util.Scanner


fun main() {

    val scanner = Scanner(System.`in`)
    var a: Int
    var b: Int

    while (true){
        println("Enter a num: ")
        try {
            a = scanner.nextInt()
            break
        } catch (ex: InputMismatchException) {
            println("Must enter a number!")
            scanner.nextLine()
        }
    }

    while (true) {
        println("Enter a second num:")
        try {
            b = scanner.nextInt()
            break
        } catch (ex: InputMismatchException) {
            println("Must enter a number!")
            scanner.nextLine()
        }
    }

    if (a == 6 || b == 6){
        println("True")
    }else if (a + b == 6) {
        println("True")
    }else{
        println("False")
    }
}