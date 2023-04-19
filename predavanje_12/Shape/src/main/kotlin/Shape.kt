open class Shape(val name: String) {

    open fun povrsina() {
        println("Formula za povrsinu $name")
    }

    open fun opseg() {
        println("Formula za opseg $name")
    }
}