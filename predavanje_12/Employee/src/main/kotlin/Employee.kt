open class Employee() {

    open fun addFunciton(employee: Employee) {}

    open fun work(){
        salary += 100
    }

    open fun getPaid(){
        if (salary == 0){
            println("Need to work to get paid")
        }else{
            salary = 0
            println("You got paid")
        }
    }

    open fun getInfo(){
        println("Employee: $name his salary: $salary")
    }
}