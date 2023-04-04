import java.lang.Thread.sleep
import java.util.InputMismatchException
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val tasks = mutableListOf<String>()

    while (true){

        if(tasks.size == 0){
            println("Nema aktivnih zadataka!")
        }else {
            println("Trenutni zadaci: ")
            for(index in 0 until  tasks.size){
                println("${index+1}. ${tasks[index]}")
            }
        }

        println()
        println("Unesi novi zadatak ili unesi \"d\" za brisanje ili unesi \"q\" da izades iz aplikacije")
        var input = scanner.next()
        input += scanner.nextLine()

        if(input == "q"){
            println("Hvala na koristenju aplikacije!")
            break
        }

        if(input == "d"){
            println("Unesi broj zadatka koji zelis obrisati:")
            var deleteInput: Int
            try {
                deleteInput = scanner.nextInt()
            }catch (ex: InputMismatchException){
                val invalidInput = scanner.nextLine()
                println("$invalidInput nije broj!")
                continue
            }

            if(deleteInput-1 in 0 until tasks.size){
                tasks.removeAt(deleteInput-1)
                println("Zadatak uspješno obrisan!")
            }else {
                println("Zadatak s brojem $deleteInput ne postoji!")
            }
            continue
        }
        tasks.add(input)
        println("Zadatak uspješno dodan!")

        sleep(500)
    }

}