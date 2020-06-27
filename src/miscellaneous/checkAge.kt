package miscellaneous

import java.util.Calendar

fun main() {
    print("Year of birth: ")
    val yearOfBirth = readLine()!!.toInt()
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    val age = currentYear - yearOfBirth

    println("Your age is $age year(s) old")
}