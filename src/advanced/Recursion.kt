package advanced

/* recursion reminders */

/*
fun sort(numbers: List<Int>): List<Int> =
    if (numbers.isEmpty())
        numbers
    else {
        val pivot = numbers.first()
        val tail = numbers.drop(1)
        val lessOrEqual = tail.filter { e -> e <= pivot }
        val larger = tail.filter { e -> e > pivot }
        sort(lessOrEqual) + pivot + sort(larger)
    }
    println(sort(listOf(12, 5, 15, 12, 8, 19)))
*/

/* factorial example
fun factorialRec(n: Int): BigInteger =
    if (n <= 0) 1.toBigInteger() else n.toBigInteger() * factorialRec(n - 1)

fun factorialIterative (n: Int) =
(1..n).fold(BigInteger( "1" )) { product, e -> product * e.toBigInteger() }

tailrec fun factorial(
    n: Int,
    result: BigInteger = 1.toBigInteger()
): BigInteger =
    if (n <= 0) result else factorial(n - 1, result * n.toBigInteger())
*/

/* memoization
// Fibonacci without memoization
fun fib (n: Int) : Long = when (n) {
0, 1 -> 1L
else -> fib(n - 1) + fib(n - 2)
}

 */



