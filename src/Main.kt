fun sayHello(greeting: String, vararg itemsToGreet: String) {
    itemsToGreet.forEach { itemToGreet ->
        println("$greeting $itemToGreet")
    }
}
// Longer syntax, same as above in functionality
//fun sayHello(greeting: String, itemsToGreet:List<String>) {
//    itemsToGreet.forEach { itemToGreet ->
//        println("$greeting $itemToGreet")
//    }
//}

fun main() {
    val things = arrayOf("js", "kotlin", "C")
//    in kotlin the spread operator is '*'
    sayHello("hi", *things)
    things.forEachIndexed { index, thing ->
        println("$index $thing")
    }
//
//    for (thing in things) {
//        println(thing)
//    }

    val testClass = TestClass()
    testClass.lastName
    testClass.firstName
    testClass.nickName = "huu"
    testClass.nickName = "jdudd"
    println(testClass.nickName)
}


