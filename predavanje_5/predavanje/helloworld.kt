/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 * lkfsdnpfsndfasfasf
 * fasfa
 */
fun main(args: Array<String>) {
    
	//println(args[0])
    
    var sum: Int = sumOfTwoNumbers(1, 3)
    
    if(sum != 6){
        // println("Well done!")
    }else{
        // println("Bad Calculation!")
    }
    
    if(sum == 1) {
        println("Sum is one!") // First check
    }else if(sum == 2) {
        println("Sum is two!") // Second check
    }else if(sum == 2){
        println("Sum is three!") // Third check
    }else {
        println("I have no idea what sum is!") // I give up
    }
    
    when(sum){
        1 -> println("Sum is one!")
        2 -> println("Sum is two!")
        3 -> println("Sum is three!")
        else -> println("I have no idea what sum is!") 
    }    
    
    var numbers = arrayOf("One", "Two", "Matej", 1)
    for(i in numbers) {
        println(i)
    }
    
    var sumOfAllNumbers = intArrayOf(1,2,3,4,5,6,7,8)
    var result: Int = 0
    for(i in sumOfAllNumbers) {
        println("Before sum: "+result)
        result = result + i
        if(result == 15){
            continue
        }
        println("After sum: "+result)
    }
    println("Final: " + result)
}

// SumOfTwoNumbers is a function
fun sumOfTwoNumbers(a: Int, b: Int): Int {
    return a+b
}