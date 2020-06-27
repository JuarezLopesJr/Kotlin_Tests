package advanced

/*
object Util {
    fun getProcessors() = Runtime.getRuntime().availableProcessors()
}
*/
/* testing to defining setters ('field' keyword creates the backing field
  yearOfMake is a property (has the val keyword), theColor is a parameter (no val/var)

  Don’t write more than one init block, and avoid it if you can. The less work
  we do in constructors, the better from the program safety and also
  performance point of view

 */

/*
class Car(val yearOfMake: Int, theColor: String) {
    */
/* replacing init block *//*

    var fuelLevel = if (yearOfMake < 2020) 90 else 100
        private set

    */
/* init {
         if (yearOfMake < 2020) {
             fuelLevel = 90
         }
     }*//*


    var color = theColor
        set(value) {
            if (value.isBlank()) {
                throw RuntimeException("empty value not permitted")
            }
            field = value
        }
}


fun main() {
    val car = Car(2019, "blue")
    car.color = "green"
//    car.fuelLevel--

    println(car.fuelLevel)

    try {
        car.color = ""
    } catch (e: Exception) {
        println(e.localizedMessage)
    }
    println(car.color)
}*/

/* Secondary constructors example - (secondary constructors don't define properties and can't
 be decorated with val/var. It must call the primary constructor's properties or the other
 secondary constructor if any)

class Person(val firstName: String, val lastName: String) {
    var fullTime = true

    constructor(firstName: String, lastName: String, fte: Boolean) : this(firstName, lastName) {
        fullTime = fte
    }
}
 */

/*
 companion objects - are class level properties, and not on a specific instance of the class
 Companion objects are singletons defined within a class—
 they’re singleton companions of classes. In addition, companion objects
 may implement interfaces and may extend from base classes, and thus are
 useful with code reuse as well
 MachineOperator class needs a property and a method
 at the class level; we achieve that using a companion object

class MachineOperator private constructor(val name: String) {
    fun checkin() = checkedIn++
    fun checkout() = checkedIn--

    companion object MachineOperatorFactory {
        var checkedIn = 0
        fun minimumBreak() = "15 minutes every 2 hours"

        fun create(name: String) = MachineOperator("john").also {
            it.checkin()
        }
        /*fun create(name: String): MachineOperator {
            return MachineOperator("john").also {
                it.checkin()
            }*/
    }
}


fun main() {
    val operator = MachineOperator.create("john")
    /* getting the reference to the companion object if has no name
    val ref = MachineOperator.Companion
     */
    /* getting the named reference
    val ref = MachineOperator.MachineOperatorFactory
    */

    /*val machine = MachineOperator("john")
    MachineOperator.minimumBreak()
    machine.checkin()
    MachineOperator.checkedIn = 2
    val test = MachineOperator.minimumBreak()*/
}
*/

/* generics classes */

/*
class PriorityPair<T : Comparable<T>>(member1: T, member2: T) {
    val first: T
    val second: T

    init {
        if (member1 >= member2) {
            first = member1
            second = member2
        } else {
            first = member2
            second = member1
        }
    }
}

fun main() {
    println(PriorityPair(2, 1)) //2, 1
    println(PriorityPair("A", "B")) // B, A
}*/

/* data classes - are specialized classes that are intended to carry mostly data
rather than behavior
data class Todo(val id: Int, val name: String, val completed: Boolean)

fun main() {
    val myTodo = Todo(1, "make more money", true)
    val (myId, taskName, done) = myTodo
}*/

/*
interfaces
interface Remote {
    fun up()
    fun down()

    fun doubleUp() {
        up()
        up()
    }

    companion object {
        fun combine(first: Remote, second: Remote): Remote = object : Remote {
            override fun up() {
                first.up()
                second.up()
            }

            override fun down() {
                first.down()
                second.down()
            }
        }
    }
}

class Tv {
    var volume = 0
}

class TvRemote(val tv: Tv) : Remote {
    override fun up() {
        tv.volume++
    }

    override fun down() {
        tv.volume--
    }
}

fun main() {
    val tv = Tv()
    val remote: Remote = TvRemote(tv)
    remote.up() // or .down() are handled by TvRemote(tv)
    remote.doubleUp() // handled by Remote interface, as it wasn't an abstract method

    val anotherTv = Tv()
    val combinedRemote = Remote.combine(remote, TvRemote(anotherTv))

    combinedRemote.up()
    println(tv.volume) //4
    println(anotherTv.volume) //1
} */

/* abstract classes
abstract class Musician( val name: String, val activeFrom: Int) {
abstract fun instrumentType (): String
}
class Cellist(name: String, activeFrom: Int) : Musician(name, activeFrom) {
override fun instrumentType () = "String"
}
val ma = Cellist( "Yo-Yo Ma" , 1961)
  */

/*
inner classes
interface Remote {
    fun up()
    fun down()

    fun doubleUp() {
        up()
        up()
    }
}


class Tv {
    private var volume = 0
    val remote: Remote
        get() = TVRemote()

    override fun toString(): String = "Volume: $volume"

    inner class TVRemote : Remote {
        override fun up() {
            volume++
        }

        override fun down() {
            volume--
        } */

/* using this here to not shadow the toString() on the outer class *//*
        override fun toString(): String = "Remote: ${this@Tv}"
    }
}

class Tv {
    private var volume = 0
    val remote: Remote
        get() = object : Remote {
            override fun up() {
                volume++
            }

            override fun down() {
                volume--
            }

            override fun toString() = "Remote: ${this@Tv.toString()}"
        }

    override fun toString(): String = "Volume: ${volume}"
}

fun main() {
    val tv = Tv()
    val remote = tv.remote

    println("$tv") //Volume: 0
    remote.up()
    println("After increasing: $tv") //After increasing: Volume: 1
    remote.doubleUp()
    println("After doubleUp: $tv") //After doubleUp: Volume: 3
    println(remote)
} */

/*
/* inheritance */

open class Vehicle(val year: Int, open var color: String) {
    open val km = 0

    final override fun toString() = "Year: $year, Color: $color, Km: $km "

    fun repaint(newColor: String) {
        color = newColor
    }
}

/* overriding val km to var km (as val can become var, but not the other way around)
 because val only implements the getter method, the setter can be added in the derived class
 but the setter from the base class (var) MUST NOT be overriding (removed) in the derived class
 */
open class Car(year: Int, color: String) : Vehicle(year, color) {
    override var km: Int = 0
        set(value) {
            if (value < 0) {
                throw RuntimeException("km must be positive")
            }

            field = value
        }

    fun drive(distance: Int) {
        km += distance
    }
}

/* extending even more with Car being the base class, which already inherits from Vehicle */
class FamilyCar(year: Int, color: String) : Car(year, color) {
    override var color: String
        get() = super.color
        set(value) {
            if (value.isEmpty()) {
                throw RuntimeException("Color required")
            }
            super.color = value
        }
}
*/

/* sealed - open for extension by other classes defined in the
same file but closed—that is, final or not open —for any other classes
sealed classes can't be instantiated
 */

/*
/* enum classes - restricts the number of instances to one for each subclass
 enum classes can also be iterated, the values() method provides an array of all
 the instances of the enum class
 for (suit in Suit.values()) {
println( "${suit.name} -- ${suit.ordinal}" ) //CLUBS -- 0, etc.
}
 */
enum class Suit(val symbol: Char) {
    CLUBS('\u2663'),
    DIAMONDS('\u2666'),
    HEARTS('\u2665') {
        override fun display() = "${super.display()} $symbol"
    },
    SPADES('\u2660');

    open fun display() = "$symbol $name"
}

fun main() {
    for (suit in Suit.values()) {
        println(suit.display())
    }
} */

/* delegation - more flexible than inheritance
Kotlin requires the left side of the 'by' to be an interface. The right side is an
implementor of that interface
*/
/*interface Worker {
    fun work(): String
    fun takeVacation()

    *//* used in the multiple delegation example *//*
    fun fileTimeSheet() = println("Why? Really?")
}*/

/* used in the multiple delegation example */
/*interface Assistant {
    fun doChores()
    fun fileTimeSheet() = println("No escape from that")
}*/

/*class KotlinProgrammer() : Worker {
    override fun work() = "coding in kotlin"

    override fun takeVacation() = println("code on the beach")
}*/

/* implicit delegation
class Manager() : Worker by KotlinProgrammer()
*/

/* delegation to a parameter (even more flexibility)
class Manager(val staff: Worker) : Worker by staff {
    fun meeting() =
        println("organizing meeting with ${staff.javaClass.simpleName}")
} */

/* delegating to multiple interfaces */
/*class DepartmentAssistant : Assistant {
    override fun doChores() = println("routine stuff")
}*/
/* staff and assistant, are also class properties, as they have 'val' */
/*class Manager(val staff: Worker, val assistant: Assistant) :
    Worker by staff, Assistant by assistant {
    override fun takeVacation() = println("of course")
    override fun fileTimeSheet() {
        print("manually forwarding this...")
        assistant.fileTimeSheet() // calling the method in the Assistant interface
        staff.fileTimeSheet()
    }
}*/

/* delegating variables */

/*
class PoliteString(var content: String) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) =
        content.replace("stupid", "s*****")

    */
/* 'operator' stand for the assignment operator '=' used for get and set *//*

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        content = value
    }
}
*/
/* use a function that returns a delegate instance,
 instead of calling the constructor of a class after 'by' *//*

fun beingPolite(content: String) = PoliteString(content)


fun main() {
    var comment: String by beingPolite("some message")
    println(comment)

    comment = "this is stupid"
    println(comment)

    println("comment length is: ${comment.length}")
}*/

/* delegating properties*/

/*
class PoliteString(val dataSource: MutableMap<String, Any>) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) =
        (dataSource[property.name] as? String)?.replace("stupid", "s*****") ?: ""

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        dataSource[property.name] = value
    }
}

class PostComments(dataSource: MutableMap<String, Any>) {
    val title: String by dataSource
    var likes: Int by dataSource
    val comment: String by PoliteString(dataSource)

    override fun toString() = "Title: $title - Likes: $likes - Comment: $comment"
}

val data: List<MutableMap<String, Any>> = listOf(
    mutableMapOf(
        "title" to "Using Delegation",
        "likes" to 2,
        "comment" to "Keep it simple, stupid"
    ),
    mutableMapOf(
        "title" to "Using Inheritance",
        "likes" to 1,
        "comment" to "Prefer Delegation where possible"
    )
)

fun main() {
    val forPost1 = PostComments(data[0])
    val forPost2 = PostComments(data[1])

    forPost1.likes++
    println(forPost1)
    println(forPost2)

}*/

/* built-in delegates */

