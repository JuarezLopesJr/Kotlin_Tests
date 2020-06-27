import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList

//import java.io.File

//import java.io.FileReader

/* IMPORTANT REMINDER:
* PRE-INCREMENT - value is retrieved, incremented and passed to a function as argument
* var speed = 1.0
* println(++speed) - Prints: 2.0
* println(speed) - Prints: 2.0
*
*POST-INCREMENT - value is retrieved, passed to a function as argument and then it's incremented so the old value is passed to a function
* var speed = 1.0
* println(speed++) - Prints: 1.0
* println(speed) - Prints: 2.0
*
*
* */
/*An argument is an actual value that is passed to the function when a function is called.
Parameter refers to the variables declared inside function declaration*/

/* const modifier to initialize val at compile time (compile time must always have a value)
it's used when the value of val is only known at runtime (result of a method call)
const val MAX_ENTRIES = 200 (value available at compile time)

* Defining a custom annotation
@MaxLogEntries(MAX_ENTRIES) - getting the result of val MAX_ENTRIES at runtime
class Logs {...}
* */


/* Using extensions
fun ArrayList<Int>.findMaxValue(): Int {

    var maxValue = 0
    for (number in this) {
        if (number > maxValue) {
            maxValue = number
        }
    }
    return maxValue
}*/

fun main() {
/*    val items = listOf("C", "kotlin", "JS")

    for (index in items.indices) {
        println("item at index: $index is ${items[index]}")
        val fruits = listOf("banana", "peach", "avocado", "apple")
        fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
    } */
/*   Another form of iteration using withIndex() method, same as above
    for ((index, item) in items.withIndex()) {
        println("item at index: $index is $item")
    }

    val fruits = listOf("banana", "peach", "avocado", "apple")
    fruits.filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }

    val numbers = listOf(1, 2, 3, -5, -4, 6, 9)
//    val positives = numbers.filter { x -> x > 0 }
    val positives = numbers.filter { it > 0 }
    println(positives) */

/*    Invoking findMaxValue extension
    val listOfNumbers = ArrayList<Int>()
    listOfNumbers.add(2)
    listOfNumbers.add(5)
    listOfNumbers.add(10)
    println("Highest number is: ${listOfNumbers.findMaxValue()}") */

    /*val yinYang = '\u262F'
    println(yinYang)

    var str = "john"
    var nam = str.replaceFirst("j", "J")
    println(nam)*/

    /*for (char in 'a'..'z'){
        println(char)
    }*/

    /*
    Reference and Structural equality check
    The == operator is null safe. That is, we don't need to worry if we are
    testing a null instance as the compiler will add the null check for us
    val a = File("Main.kt")
    val b = File("Main.kt")

    println("reference equality: ${a === b} ")
    println("structural equality: ${a == b} ")
    */
    // To read from file, first put the content inside a variable then call the toChar() method
//    import java.io.FileReader
    /* try {
         val readFromFile = FileReader("fileName or path")
         var character: Int?
         do {
             character = readFromFile.read()
             print(character.toChar())
         } while (character != -1)
     } catch (ex:Exception) {
         println(ex.message)
     } finally {
        readFromFile.close()
     } */

//    "when" statements used as expression, else clause is mandatory
    /* val vehicle = "motorcycle"

     val message = when(vehicle){
         "motorcycle" -> {
             "2 wheels"
         }
         "car" -> {
           "4 wheels"
         } else -> {
             "not defined"
         }
     }
     println(message) */

// when using smart casts
    /*
    * val name = when (person) {
        is String -> person.toUpperCase()
        is User -> person.name
        //Code is smart casted to String, so we can
        //call String class methods
        //...
        }  */

/* val riskAssessment = 47
    val risk = when (riskAssessment) {
        in 1..20 -> "negligible risk"
        !in 21..40 -> "minor risk"
        !in 41..60 -> "major risk"
        else -> "undefined risk"
    }
    println(risk) // Prints: major risk */
/*
Any expression can be put on the right-hand side of the branch, even another when call

val riskAssessment = 80
val handleStrategy = "Warn"
val risk = when (riskAssessment) {
    in 1..20 -> print("negligible risk")
    !in 21..40 -> print("minor risk")
    !in 41..60 -> print("major risk")
    else -> when (handleStrategy){
        "Warn" -> "Risk assessment warning"
        "Ignore" -> "Risk ignored"
        else -> "Unknown risk!"
      }
   }
println(risk) // Prints: Risk assessment warning
*/

    /* omitting the argument for when call, the branch conditions behave as boolean
    only the branch that return true will be executed

    private fun getPasswordErrorId(password: String) = when {
       password.isEmpty() -> R.string.error_field_required
       passwordInvalid(password) -> R.string.error_invalid_password
       else -> null
   } */
    /* TODO - CHECK Lambda with receiver
    val isEven:Int.() -> Boolean = {
        this % 2 == 0
    }
    println(25689411.isEven()) */


}