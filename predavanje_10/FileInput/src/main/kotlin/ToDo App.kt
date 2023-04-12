import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.lang.Thread.sleep
import java.util.InputMismatchException
import java.util.Scanner

fun main() {
    val filePath = "C:\\Users\\Mata\\Desktop\\Tecaj\\predavanje_10\\FileInput\\src\\main\\resources\\tasks.json"
    val scanner = Scanner(System.`in`)

    val tasks = JSONArray(getContentOfFile(filePath))

    while (true){

        if(tasks.length() == 0){
            println("Nema aktivnih zadataka!")
        }else {
            println("Trenutni zadaci: ")
            tasks.forEachIndexed { index, task ->
                task as JSONObject
                println("${index + 1}. ${task.getString("task")}")
            }
        }

        println()
        println("Unesi novi zadatak ili unesi \"d\" za brisanje ili unesi \"q\" da izades iz aplikacije")
        var input = scanner.next()
        input += scanner.nextLine()

        if(input == "q"){
            createNewFile(filePath, tasks.toString())
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

            if(deleteInput-1 in 0 until tasks.length()){
                tasks.remove(deleteInput-1)
                println("Zadatak uspješno obrisan!")
            }else {
                println("Zadatak s brojem $deleteInput ne postoji!")
            }
            continue
        }
        tasks.put(JSONObject().put("task", input))
        println("Zadatak uspješno dodan!")

        sleep(500)
    }

}