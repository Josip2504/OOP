fun main() {
    val rect = Rectangle(100, 50)
    val circle = Circle(50)
    val square = Square(20)


    var area = AreaFactory().calculateArea(arrayListOf(rect, circle, square))
    println(area)
}

interface Shape {
    fun getArea(): Int
}

class Rectangle(var length: Int = 0, var height: Int = 0): Shape {

    override fun getArea(): Int {
        return length * height
    }
}

class Circle(var radius: Int = 0): Shape {
    override fun getArea(): Int {
        return (radius * radius * 3.14).toInt()
    }
}

class Square(var size: Int = 0): Shape {

    override fun getArea(): Int {
        return size*size
    }
}

class AreaFactory() {
    fun calculateArea(shapes: ArrayList<Shape>): Int {
        var area = 0
        for(shape in shapes) {
           area += shape.getArea()
        }
        return area
    }
}