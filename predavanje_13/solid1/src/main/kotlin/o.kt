fun main() {

    var rect = Rectangle(2, 2)
    var circle = Circle(2)

    var area = AreaFactory().calculateArea(arrayListOf(rect, circle))
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
class AreaFactory() {
    fun calculateArea(shapes: ArrayList<Shape>): Int {
        var area = 0
        for (shape in shapes){
            area += shape.getArea()
        }
        return area
    }
}