import java.util.Scanner



fun main(){
    val scanner = Scanner(System.`in`)
    var currentRoom = "You are in the room. There is a knife on the table. There are doors on the north."
    var hasKey = false
    var hasKnife = false

    while (!currentRoom.contains("Game Over")){
        println(currentRoom)
        print("> ")

        var input = scanner.next()
        input += scanner.nextLine()

        when (input) {
            "pick up a knife" -> {
                if (currentRoom.contains("knife")){
                    hasKnife = true
                    println("You picked up a knife.")
                    currentRoom = currentRoom.replace("knife", "nothing")
                }else{
                    println("There is nothing to pick up.")
                }
            }
            "go north" -> {
                if (currentRoom.contains("north")){
                    println("You entered a new room.")
                    currentRoom = "You are in new room. There is a monster on the east and key on the table. There is a locked door on the south."
                }else{
                    println("There is nothing on the north.")
                }

            }
            "go east" -> {
                if (!currentRoom.contains("east")) {
                    println("There is nothing on the east.")
                }else if (hasKnife) {
                    currentRoom = currentRoom.replace("monster on the east and ", "" )
                    println("You killed the monster.")
                }else{
                    println("Monster will kill you! You need a knife.")
                }
            }
            "pick up a key" -> {
                if (!currentRoom.contains("key")) {
                    println("Key is not on the table.")
                }else if (!currentRoom.contains("monster")){
                    hasKey = true
                    currentRoom = currentRoom.replace("key", "nothing")
                    println("You picked up a key.")
                }else{
                    println("Monster will kill you!")
                }
            }
            "go south" -> {
                if (hasKey) {
                    println("Congratulations! You exited the room!")
                    currentRoom = "Game Over"
                }else if (currentRoom.contains("south")){
                    println("You need a key to unlock a door.")
                }else{
                    println("There is nothing on the south.")
                }
            }
            "go back" -> {
                if (currentRoom.contains("north")){
                    println("You can't go back.")
                }else{
                    if (hasKnife) {
                        println("You went back to first room.")
                        currentRoom = "You are in the first room. There is a nothing on the table. There are doors on the north."
                    }else{
                        println("You went back to first room.")
                        currentRoom = "You are in the first room. There is a knife on the table. There are doors on the north."
                    }
                }

            }else -> {
                println("I don't know what you want.")
            }
        }
        Thread.sleep(1000)
    }
}

