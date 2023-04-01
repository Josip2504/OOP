import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var currentRoom = "You are in a dark room. There is a locked door to the north. There is a key on the table."
    var hasKey = false

    while(!currentRoom.contains("Congratulation you got out!")){
        println(currentRoom)
        print("> ")

        var input = scanner.next()
        input += scanner.nextLine()

        when (input){
            "go north" -> {
                if(currentRoom.contains("locked")){
                    println("The door is locked. You need a key.")
                }else{
                    println("Congratulation you got out!")
                    currentRoom = "Congratulation you got out!"
                }
            }
            "pick up key" -> {
                if (currentRoom.contains("key")){
                    hasKey = true
                    currentRoom = currentRoom.replace("key", "nothing")
                    println("You picked up a key.")
                }else{
                    println("There is nothing to pick up.")
                }
            }
            "use key" -> {
                if (hasKey && currentRoom.contains("locked")){
                    currentRoom = currentRoom.replace("locked", "")
                    println("You unlocked the door.")
                }else if(hasKey) {
                    //nothing to unlock
                    println("There is nothing to unlock.")
                }else{
                    //you dont have a key
                    println("You don't have a key")
                }
            }
            else -> {
                println("I don't know what you want")
            }
        }
    }

}