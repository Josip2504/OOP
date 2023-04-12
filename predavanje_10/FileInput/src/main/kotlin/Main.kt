import java.io.File
import java.io.FileReader
import java.io.FileWriter

fun main() {
    val filePath = "C:\\Users\\Mata\\Desktop\\Tecaj\\predavanje_10\\FileInput\\src\\main\\resources\\hello.txt"
    val textToWrite = "Hello world!"
    val textToAdd = " My name is Kotlin!"

    createNewFile(filePath, textToWrite)

    readFromFile(filePath)

    addToFile(filePath, textToAdd)

    readFromFile(filePath)

}

fun createNewFile(filePath: String, textToWrite: String) {
    File(filePath).writeText(textToWrite)
    println("Zapisali smo u file!")
}

fun readFromFile(filePath: String) {
    FileReader(filePath).use {reader ->
        val contentOfFile = reader.readText()
        println(contentOfFile)
    }
    println("Završili sa čitanjem!")
}

fun getContentOfFile(filePath: String): String{
    FileReader(filePath).use { reader ->
        return reader.readText()
    }
}

fun addToFile(filePath: String, textToWrite: String){
    FileWriter(filePath, true).use {writer ->
        writer.write(textToWrite)
    }
    println("Završili sa dodavanjem!")
}