fun main(){

    val string = arrayOf("Josip", "Iva", "Sara")
    val longest = string.maxBy { it.length }
    println(longest)

}