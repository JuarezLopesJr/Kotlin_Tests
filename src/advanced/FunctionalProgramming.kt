package advanced

/* Functional programming reminders */

/* receiving a lambda as parameter

fun receivingLambda(n: Int, action: (Int) -> Unit) =  (1..n).forEach(action)


fun main() {
    fun isPrime(n: Int) =
        n > 1 && (2 until n).none { n % it == 0 }

    receivingLambda(9, ::print)
}*/
/*

*/
/* function receiving function *//*

val names = listOf("Pam", "Pat", "Paul", "Paula")

*/
/* it refers to (String) -> ... *//*

fun predicateOfLength(length: Int): (String) -> Boolean = { it.length == length }

val checkLength = fun(name: String): Boolean = name.length == 5
val doubleIt = { e: Int -> e * 2 }
//val seq = sequenceOf(2,3,4,5,6)

var factor = 2

fun invokeWith(n: Int, action: (Int) -> Unit) {
    println("enter invokewith: $n")
    action(n)
    println("exit invokewith : $n")
}

fun caller() {
    (1..3).forEach { i ->
        if (i == 2) return
        invokeWith(i) here@{
            println("enter for $it")
            if (i == 2) {
                return@here // only permitted in the current encompassing lambda scope
            }
            println("exit for $it")
        }
    }
    println("end of caller")
}

fun main() {
    invokeWith(6, ::println)
    caller()

    */
/*val doubled = listOf(1, 2).map { it * factor }
    val doubledAlso = sequenceOf(1, 2).map { it * factor }
    *//*
*/
/*println(names.find(predicateOfLength(5))) //Paula
    println(names.find(predicateOfLength(4))) //Paul
    println(names.find(checkLength))
    println(doubleIt(5))*//*
*/
/*
//    seq.forEach(::println)
//    print(seq.filter { it % 2 == 0 }.toList())
    factor = 0
    doubled.forEach(::print)
    doubledAlso.forEach(::println)*//*

}*/

/* internal iterators *//*

data class Person(val firstName: String, val age: Int)

*/
/*val numbers = listOf(10, 12, 15, 17, 18, 19)*//*


val people = listOf(
    Person("Sara", 12),
    Person("Jill", 51),
    Person("Paula", 23),
    Person("Paul", 25),
    Person("Mani", 12),
    Person("Jack", 70),
    Person("Sue", 10)
)

*/
/*val families = listOf(
    listOf(Person("Jack", 40), Person("Jill", 40)),
    listOf(Person("Eve", 18), Person("Adam", 18))
)*//*


fun main() {
    fun isAdult(person: Person): Boolean {
        println("isAdult called for ${person.firstName}")
        return person.age > 17
    }

    fun fetchFirstName(person: Person): String {
        println("fetchFirstName called for ${person.firstName}")
        return person.firstName
    }
    */
/* using asSequence to improve performance, as sequences are lazily evaluated
     i also could declare the val people as sequenceOf(...) to achieve the same result in performance
     in that case there's no need to call asSequence()
    *//*

    val nameOfFirstAdult = people.asSequence()
        .filter(::isAdult)
        .map(::fetchFirstName)
        .first() // first() it's what triggers the result from the pipeline


    */
/*val namesAndReversed = people.map { it.firstName }
        .map(String::toLowerCase)
        .flatMap { listOf(it, it.reversed()) }

    val namesSortedByAge = people.filter { it.age > 9 }
        .sortedBy { it.age } // .sortedByDescending {}
        .map { it.firstName }

    val members = families.flatten()
        .filter { it.age > 18 }
        .map { it.firstName }

    val groupBy1Letter = people.groupBy({ it.firstName.first() }) {
        it.firstName
    }

    println(groupBy1Letter)
    println(namesSortedByAge)
    println(members)
    println(namesAndReversed)
    println(families.flatten())
*//*

    */
/* val result = people.filter { person -> person.age > 20 }
         .map { person -> person.firstName }
         .map { name -> name.toUpperCase() }
         *//*
*/
/* reduce could be replaced with .joinToString(", ") *//*
*/
/*
        .reduce { names, name -> "$names - $name" }

    val totalAge = people.map { it.age }
        .sum() // specialized iterator, less error prone
    *//*
*/
/*.reduce { total, age -> total + age }*//*
*/
/*

    val nameOfFirstAdult = people.filter { it.age > 17 }
        .map { it.firstName }
        .first()

    *//*
*/
/*println(result)
    println(totalAge)
    println(nameOfFirstAdult)*//*


    */
/*val doubled = numbers.filter { it % 2 == 0 }.map { it * 2 }
    println(doubled)

    numbers.filter { it % 2 == 0 }
        .forEach(::print)*//*


}
*/
