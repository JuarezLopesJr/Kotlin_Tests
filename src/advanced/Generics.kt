package advanced

/* Generics Training */

/* covariance List<out T> - tell the compiler to permit the use of a derived class of a parametric type T
    in addition to allowing the type T, out means intend to read out only, not insert
    to accept a type itself or any of its derived types in its place
    Using covariance, you tell the compiler to accept a derived parametric type
    in place of a parametric type

 * contravariance Array<in T> — permit a super class of a parametric type T where type T is expected
The 'in' specification tells Kotlin to permit method calls
that set in values on that parameter and not permit methods that read out

using WHERE - used to specify the generic parameters of a function with more than one parameter, in this example
the generic T is constrained by the type AutoClosable (only one parameter)

 fun <T: AutoClosable> useAndClose (input: T) {
  input.close()
}

using where:
fun <T> useAndClose(input: T) where T: AutoClosable, T: Appendable {
    input.append("hello ")
    input.close()
}

Star projection
Use star projection when you want to convey that you simply don’t know
enough about the type but nevertheless want type safety. The star projection
will permit only read-out and not write-in star projection here,
<*> , is equivalent to out T but is more concise to write

fun printValues (values: Array<*>) {
for (value in values) {
println(value)
}
    //values[0] = values[1] //ERROR, read-only
}
printValues(arrayOf(1, 2)) //1\n2

Reified type parameters:

 */
fun main() {
    open class Fruit
    class Banana : Fruit()
    class Orange : Fruit()

    val bananas: List<Banana> = listOf()
    /*fun printSize(fruits: List<Fruit>) = println("Number of fruits: ${fruits.size}")*/
    val fruitBasket1 = Array<Fruit>(3) { _ -> Fruit() }
    val fruitBasket2 = Array<Fruit>(3) { _ -> Fruit() }

    println("fruitbasket: $fruitBasket1")
    fun copyFromTo(from: Array<out Fruit>, to: Array<Fruit>) {
        for (i in from.indices) {
            to[i] = from[i]
        }
    }

    fun <T> useAndClose(input: T) where T : AutoCloseable, T : Appendable {
        input.append('x')
        input.close()
    }
}