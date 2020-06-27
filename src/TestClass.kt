interface CreditCard{
    fun checkData(number: Int)
}

class TestClass(val firstName: String = "Peter", val lastName: String = "Parker") {
    var nickName: String? = null
        set(value) {
            field = value
            println("new nickname is $value")
        }
        get() {
            println("returned value is $field")
            return field
        }

    fun printInfo() {
        println("$lastName ($nickName) $firstName ")
    }
}

class AllCard:CreditCard{
    override fun checkData(number: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
