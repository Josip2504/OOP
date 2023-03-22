/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main(args: Array<String>) {
    var result: String = ""
    
    when(args[0]){
        "Sum" -> result = sum(args[1].toInt(), args[2].toInt()).toString()
        "Min" -> result = min(args[1].toInt(), args[2].toInt()).toString()
        "Multiply" -> result = multiply(args[1].toInt(), args[2].toInt()).toString()
        "Div" -> result = div(args[1].toFloat(), args[2].toFloat()).toString()
        else -> println("Unknown operation!") 
    }
    println("End result is: " + result)
}

fun sum(a: Int, b: Int): Int{
    return a+b
}

fun min(a: Int, b: Int): Int{
    return a-b
}

fun multiply(a: Int, b: Int): Int{
    return a*b
}

fun div(a: Float, b: Float): Float {
    return a/b
}