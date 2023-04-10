import java.util.Scanner

fun main(){

    val lista = mutableListOf<Int>(1, 2, 3, 4, 5, 6)
    val parni = lista.filter { x ->
        x % 2 == 0
    }
    val sum = parni.sum()
    println(sum)

}

