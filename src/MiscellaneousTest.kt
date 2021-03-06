 import kotlin.random.Random

/*Forcing NullPointerError exception
*
* val lowest:Int = emptyList<Int>().min()!! // overridden compiler safe null engine with (!!)
*
* */

/*Extension function method
* class HttpHandler(val request: HttpRequest, val response: HttpResponse)
* fun getPath(path: String, handler: HttpHandler.() -> Unit) // extension function of type HttpHandler
*
* fun miscellaneous.main(){
*   getPath("/") { if request.accept == "application/json" ... else response... }
* }
*using that extension function i can access those methods from (HttpHandler), without boilerplate code
*
* */
/*TODO - always try to use if/else and when as expressions, for better error handling from the IDE
*
* val result = when(x) {...}
* val isCondition = if {...}
* */

/*

* Custom getter and setter reminder - to define custom getters and setters, declare properties inside class body, the variable must be initiated with a default value or in case i need that value to be computed each time that property is retrieved, i must explicitly define a getter (get())
*
* class Fruit(var weight: Int) {
*   val heavy // not passing default value explicitly
*   get() = weight > 20
* }
*
* Usage:
*   var fruit = Fruit(7)
    println(fruit.heavy) //prints: false
    fruit.weight = 30
    println(fruit.heavy) //prints: true
*
*The field keyword, points to the variable declared in the class body
*
* */

/* open class MiscellaneousTest(var weight: Int) {
      open var ecoRating: Int = 2 // explicit default value
        get() {
            println("getter retrieved: $field") // field points to the variable ecoRating
            return field
        }
        set(value) {
            field = if (value < 0) 0 else value
            println("setter new value assigned: $field")
        }

        /* val fruit = MiscellaneousTest(69)
     val ecoRating = fruit.ecoRating // get()
     println(ecoRating) // prints 2 (the initial/default value)
     fruit.ecoRating = 6 // set(value)
     fruit.ecoRating = -3 // set(value) */
    /*val tmp = InlineTest(6)
    println(tmp.now)*/
} */
/* TODO: check inline modifier method*/
/*class InlineTest(var num:Int) {
    inline val now:Long
    get() {
        println("time retrieved")
        return System.currentTimeMillis()
    }


} */

/* Abstract class implementation, methods are open by default in abstract classes
(but each method must still be marked as abstract abstract fun grow(height: Int))
* abstract is used as a base super class, it can only be inherited,
* not instantiated (var test = Class()) - ERROR
* and the function must have no body - abstract fun someFun(parameters)
*
* abstract class Plant() {
    var height = 0
    abstract fun grow(height: Int)
 }

*
*  */


/* Interface - All methods and properties have to be overridden in a class implementing interface
* interface EmailProvider {
*   val email:String
*   fun validateEmail()
* }
*
* Properties defined in a primary constructor can be used to override parameters from an interface
* class User(override val email:String):EmailProvider{
*   override fun validateEmail() {...}
* }
*
* Interface also can implement default behavior so i don't have to define it in the extended class
* interface EmailProvider {
    val email: String
    val nickname: String
    get() = email.substringBefore("@") // default implementation
    fun validateEmail() = nickname.isNotEmpty() // default method
  }
 Interfaces containing methods with the same signature and default implementations
 call the desired interface method with "super" and angle brackets
 interface A {
    fun foo() {
    println("A")
    }
   }

   interface B {
    fun foo() {
    println("B")
    }
   }

    class Item : A, B {
    override fun foo() {
    val a = super<A>.foo() // defining which interface to call
    val b = super<B>.foo()
    }
   }
*
*
*  */

/*Data Class: used to store data (from a server or local DB) - adds additional capabilities to a class in the form of methods generated by the Kotlin compiler - equals , hashCode , toString , copy and componentN. The limitation is that data classes can't be marked as abstract, inner, and sealed

data class Product(var name:String, var price:Double )

val productA = Product("bike", 69.9) // prints: Product(name="bike",price=69.9) (toString method)
val productB = Product("bike", 69.9)

productA == product8 // prints: true - equals method, by default hashCode and equals methods are generated based on every property declared in the primary constructor

val productC = productA.copy() - prints: Product(name="bike",price=69.9)  (copy method)

* Copy method is used also to change specifics parts of the object, without mutate the original
val productD = productA.copy(name="motorcycle")

Destructuring pattern to create multiple variables at once
data class Person(val name:String, val lastName:String, val age:Int)
val person = Person("john", "doe", 20)
var (name, lastName, age) = person // will create var name = "john" , var lastName = "doe" and var age = 20
I can also omit one or more properties using an underscore
var (name, _, age) = person

Destructuring simple types e.g: String
val fileName = "MainActivity.kt"
val (name, extension) = fileName.split(".", limit = 2)

Destructuring in for loop
val authors = listOf(
Person("Igor", "Wojda", 180),
Person("Marcin", "Moskała", 180)
)
println("Authors:")
for ((name, surname) in authors) {
println("$name $surname")
}
*/

/* Visibility Modifiers
* Declared at top level file
* public: (default): Element is visible everywhere
* private: Element is visible inside the file containing the declaration
  protected: Not available at top level
  internal: Element is visible everywhere in the same module. It is public for
 elements in the same module
 * In a nutshell - in top level declaration - i can access private only in the same file, internal only in the same module
 *
*
* Classes and interfaces (members--elements)
* public: (default): Client who sees the declaring class sees its public members.
* private: Element is visible only inside the class or interface containing the member.
  protected: Visible inside the class containing the declaration and subclasses. It is
not applicable inside an object, because an object cannot be opened.
internal: Any client inside this module who sees the declaring class sees its
internal members.
*
* In a nutshell - when instantiate a class val person = Person() - only public and internal are accessible
* when inherit (subclass): class User: Person() {...} - i can access public, internal and protected
*
* It's also possible to override the modifiers, even when instantiate a class:
* open class Person() { protected fun foo() }
*
* class User: Person() { override public fun foo() } // overriding protected modifier
*
* val person = Person()
* person.foo() // Error
*
* val user = Student()
* user.foo() // access granted
*
*
* */

/*Functional Programming

// Getting 'when' subject in a variable
    fun Request.getBody() =
    when (val response = executeRequest()) {
    is Success -> response.body
    is HttpError -> throw HttpException(response.status)
}

(String) -> (Int) ->: function that takes String and returns a function that takes Int type and returns Int
()->Int)-> String: function that takes another function as an argument, and returns String type
Function in argument takes no arguments and returns Int

fun addCache(function: (Int) -> Int): (Int) -> Int {
 // code
}

val fibonacciNumber: (Int)->Int = // function implementation
val fibonacciNumberWithCache = addCache(fibonacciNumber)

* functions can also be used as generic type:
* var todoList: List<() -> Int> = for (task in todoList) task()
*
Anonymous functions
val a: (Int) -> Int = fun(i: Int) = i * 2 // 1
val b: ()->Int = fun(): Int { return 4 }
val c: (String)->Unit = fun(s: String){ println(s) }
// Usage
println(a(10)) // Prints: 20
println(b()) // Prints: 4
c("Kotlin rules") // Prints: Kotlin rules

Lambda Expressions - { argument(s) -> function body } - Instead of return, result of the last expression is returned (returned value is taken from the last statement in lambda expressions)
{ 1 }: A lambda expression that takes no arguments and returns 1. Its type is () -> Int
{ s: String -> println(s) }: A lambda expression that takes one argument of type String , and prints it. It returns Unit . Its type is (String)->Unit
{ a: Int, b: Int -> a + b } : A lambda expression that takes two Int arguments and returns the sum of them. Its type is (Int, Int)->Int

val printAndReturn = {x:Int, y:Int ->
        println("calculate: $x + $y")
        x + y // last statement, so the result of this expression will be a returned value
    }

Getting ip
val getIp = fun():String {
        return java.net.URL("http://api.ipify.org").readText()
    }

 * Get timer log example
  fun addLogs(tag: String, f: () -> Unit) { // lambda expression as last parameter
        println("$tag started")
        val startTime = System.currentTimeMillis()
        f()
        val endTime = System.currentTimeMillis()
        println("$tag finished in ${endTime - startTime}")
    }
    addLogs("sleeper") { Thread.sleep(2000) } // lambda expression is the last parameter so it can be defined outside the ()

** More practical usage of last lambda parameter to process data structure

fun repeatUntilError(code:() -> Unit):Throwable { // lambda parameter
        while (true) {
            try {
                code()
            } catch (t: Throwable) {
                return t
            }
        }
    }
// Usage
    val tooMuchAttemptsError = repeatUntilError { loginAttempts() } last lambda parameter convention/usage

The 'return' modifier used inside the lambda expression of the 'inline' function is called a non-local return


** Function reference - To be able to use a top-level function as a value, i need to use a function reference

fun greet() {
        print("hello ")
    }

    fun salute() {
        print("have a nice day")
    }

    val todoList: List<() -> Unit> = listOf(::greet, ::salute)
    for (task in todoList) task()


* */

/*Generics - a generic class defines and uses a placeholder instead of a real type

*
* class SimpleList<T> - 'T' is type parameter, type will be defined during class creation
*
* // Usage with type arguments (User, Int)
* var UserList:SimpleList<User>
  var IntList: SimpleList<Int>

 class Student(val name:String)
 *
 * val studentList = SimpleList<Student>()
 * studentList.add(Student("john"))
 * println(studentList.getItemAt(0).name) // retrieving only for the type Student
*
* Limiting the default type argument with upper bound type parameter
*
* class SimpleList<T: Number> - Number class is an abstract class, that is, a superclass of Kotlin numeric types
( Byte , Short , Int , Long , Float , and Double )

  val numberList = SimpleList<Number>()
  val intList = SimpleList<Int>()
  val doubleList = SimpleList<Double>()
  val nameList = SimpleList<String>() // error, it must be of numeric types

*  Variance modifiers - co-variance , contra variance , invariance
* co-variance (out) - extends the same type and the superclass
* class Box<T> { fun sum(list: Box<out Number>) {...} } // meaning NO subtypes Int, Float, Double. But can extend from super class Any
*
* contra-variance (in) - extends any subtype, don't extend superclass
* class Box<T> {
*   fun sum(list:Box<in Number>) {...}
* }
* //Usage
* sum(Box<Any>()) // ERROR, Any is supertype of Number
* sum(Box<Number>()) // ok, same type
* sum(Box<Int>()) // ok, Int is subtype of Number
*
*** Use-site variance
  interface BaseView
  interface ProductView : BaseView
  class Presenter<T>

  // Usage example
    var presenter = Presenter<BaseView>()
    var productPresenter = Presenter<ProductView>()
    presenter = productPresenter
    // Error: Type mismatch
    // Required: Presenter<BaseView>
    // Found: Presenter<ProductView>

// Correct Usage
 var presenter: Presenter<out BaseView> = Presenter<BaseView>()
 var productPresenter = Presenter<ProductView>()
 presenter = productPresenter

 *** Declaration-site variance at type parameter declaration - more preferable for multi classes, is declared only once

interface BaseView
interface ProductView: BaseView
class Presenter<out T>
//usage
//Variable declared inside class A and B
var presenter = Presenter<BaseView>()
var productPresenter = Presenter<ProductView>()
presenter = productPresenter


Type erasure is the process of removing a type argument from a generic type, so that
the generic type loses some of its type information (type argument) at runtime
* */

/* Collection processing - more effective and terse than multiple for loops
** Reminder **
* functions that are changing object are formulated in present imperative form (it returns Unit) - e.g: sort
* functions that are returning a new collection with changed values are most often formulated in the past form of a verb, not changing the collection on which it is invoked  - e.g: sorted

Stream process - similar to method chaining in JS
data class Student(
    val name: String,
    val grade: Double,
    val passing: Boolean
   )

val students = listOf(
    Student("John", 4.2, true),
    Student("Bill", 3.5, true),
    Student("John", 3.2, false),
    Student("Aron", 4.3, true),
    Student("Jimmy", 3.1, true)
  )

students.filter { it.passing }
    .sortedByDescending { it.grade }
    .take(3)
    .forEach(::println) // same as .forEach { println(it) }

Types of Collections
List and Set - inherits from Collection, Set is unordered and doesn't contain repetitive elements

Sorting collections using property reference, instead of lambda functions

data class User(val name: String, val surname: String) {
override fun toString() = "$name $surname"
}
val users = listOf(
User("A", "A"),
User("B", "A"),
User("B", "B"),
User("A", "B")
)

val sortedUsers = users
.sortedWith(compareBy(User::surname, User::name)) // property reference
// instead of compareBy({it.surname}, {it.name})
print(sortedUsers) // [A A, B A, A B, B B]

Grouping collections
val grouped = listOf("ala", "alan", "mulan", "malan").groupBy {it.first()}
println(grouped) // Prints: {'a': ["ala", "alan"], "m": ["mulan", "malan"]}

Practical example - get a list of the best students from each class

class Student(val name: String, val classCode: String, val meanGrade: Float)

val students = listOf(
    Student("Homer", "1", 1.1F),
    Student("Carl", "2", 1.5F),
    Student("Donald", "2", 3.5F),
    Student("Alex", "3", 4.5F),
    Student("Marcin", "3", 5.0F),
    Student("Max", "1", 3.2F)
)

val bestInClass = students
    .groupBy { it.classCode }
    .map { (_, students) -> students.maxBy { it.meanGrade }!! }
    .map { it.name }

    print(bestInClass) // Prints: [Max, Donald, Marcin]

* More complex example - list containing the results of players in different categories:
class Result(
    val player: Player,
    val category: Category,
    val result: Double
 )

class Player(val name: String)
enum class Category { SWIMMING, RUNNING, CYCLING }

val results = listOf(
    Result("Alex", Category.SWIMMING, 23.4),
    Result("Alex", Category.RUNNING, 43.2),
    Result("Alex", Category.CYCLING, 15.3),
    Result("Max", Category.SWIMMING, 17.3),
    Result("Max", Category.RUNNING, 33.3),
    Result("Bob", Category.SWIMMING, 29.9),
    Result("Bob", Category.CYCLING, 18.0)
)

val bestInCategory = results
    .groupBy { it.category }
    .mapValues { it.value.maxBy { it.result }?.player }
print(bestInCategory) // Prints: {SWIMMING=Bob, RUNNING=Alex, CYCLING=Bob}




 */

/* Delegate
 interface Player{
    fun playGame()
}

class RPGPlayer(private val enemy:String) : Player{
    override fun playGame() {
        println("killing $enemy")
    }
}
// Syntax class name -> interface name by (delegate to) another class whos already overwritten interface's methods
class WitchPlayer(private val enemy: String) : Player by RPGPlayer(enemy)

 val player = WitchPlayer("monster").playGame()

 // Multiple delegations example

 interface Player {
fun playGame()
}
interface GameMaker {
fun developGame()
}
class WitcherPlayer(val enemy: String) : Player {
override fun playGame() {
print("Killin $enemy! ")
}
}
class WitcherCreator(val gameName: String) : GameMaker{
override fun developGame() {
println("Makin $gameName! ")
}
}
class WitcherPassionate :
Player by WitcherPlayer("monsters"),
GameMaker by WitcherCreator("Witcher 3") {
fun fulfillYourDestiny() {
playGame()
developGame()
}
}
// Usage
WitchPassionate().fulfillYourDestiny() // Killing monsters! Making Witch 3!

*** Decorator Pattern - design pattern that makes it possible to add a behavior to an existing
class without using inheritance

*** Observable delegate syntax - used to define behavior that should happen on the property value change

var list: MutableList<Int> by Delegates.observable(mutableListOf()) { _, old, new ->
        println("list changed from $old to $new")
    }

 */





fun main() {
    val numbers = Random.nextInt(100)
    val evenOrNull = numbers.takeIf { it % 2 == 0 }
    println(evenOrNull)
}



