fun main() {

}

interface MobileDeveloper {
    fun developMobileApp()
}

class AndroidDeveloper(var mobileServices: MobileServices): MobileDeveloper {
    override fun developMobileApp() {
        println("Developing android app using Kotlin" +
        "Application will work with ${mobileServices.serviceName}")
    }
    enum class MobileServices(var serviceName: String){
        HMS("Huawei mobile service"),
        GMS("Google mobile service"),
        BOTH("Google and Huawei mobile service")
    }
}

class IosDeveloper: MobileDeveloper{
    override fun developMobileApp() {
        println("Developing iOS app using Swift")
    }

}