import java.io.File

fun main(){

    val filePath = "C:\\Users\\josip\\OneDrive\\Radna površina\\OOP\\pradavanje_10\\main\\src\\main\\resources\\hello.txt"
    val text= "Hello world"

    File(filePath).writeText(text)

}