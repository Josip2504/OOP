fun main() {

    val shapes = Shapes()
    val kvadrat = Kvadrat("kvadrat")
    val krug = Krug("krug")

    shapes.addShape(kvadrat)
    shapes.addShape(krug)

//    kvadrat.povrsina()
//    kvadrat.opseg()
//
//    krug.povrsina()
//    krug.opseg()

    shapes.printShapes()
}