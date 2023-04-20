interface MobileDeveloper {
    fun developMobileApp()
}

class AndroidDeveloper(var mobileServices: MobileServices): MobileDeveloper{
    override fun developMobileApp() {
        println("Developing Android application by using Kotlin " +
                "Application will work with ${mobileServices.serviceName}")
    }
    enum class MobileServices(var serviceName: String){
        HMS("Huawei mobile service"),
        GMS("Google mobile service"),
        BOTH("Huawei and Google mobile service")
    }

}

class IosDeveloper: MobileDeveloper{
    override fun developMobileApp() {
        println("Developing iOS application by using swift")
    }
}

fun main() {
    val developers = arrayListOf<MobileDeveloper>(AndroidDeveloper(AndroidDeveloper.MobileServices.BOTH), IosDeveloper())

    developers.forEach {
        it.developMobileApp()
    }

}