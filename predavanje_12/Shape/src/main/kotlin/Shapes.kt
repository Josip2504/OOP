class Shapes(val shapes: MutableList<Shape> = mutableListOf()) {

    fun addShape(shape: Shape){
        shapes.add(shape)
    }

    fun printShapes(){
        for (shape in shapes){
            println("${shape.name}")
        }
    }
}