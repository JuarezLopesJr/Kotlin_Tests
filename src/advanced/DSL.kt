package advanced

/*import advanced.DateUtil.Tense
import advanced.DateUtil.Tense.**/


/*
/* operator overload */
operator fun Pair<Int, Int>.plus(other: Pair<Int, Int>) =
    Pair(first + other.first, second + other.second)
    val sum = Pair(6, 9)
    val sum1 = Pair(4, 2)

    println(sum + sum1)
*/

/* method injection using extension function *//*

data class Point(val x: Int, val y: Int)
data class Circle(val cx: Int, val cy: Int, val radius: Int)

fun Circle.contains(point: Point) =
    (point.x - cx) * (point.x - cx) + (point.y - cy) * (point.y - cy) < radius * radius

    val circle = Circle(100, 100, 25)
    val point1 = Point(110, 110)
    val point2 = Point(10, 100)

    println(circle.contains(point1)) //true
    println(circle.contains(point2)) //false
*/

/*

*/
/* injecting inner methods *//*


class Point(x: Int, y: Int) {
    private val pair = Pair(x, y)
    private val firstsign = if (pair.first < 0) "" else "+"
    private val secondsign = if (pair.second < 0) "" else "+"

    override fun toString() = pair.point2String()

    */
/* inner extension function *//*

    fun Pair<Int, Int>.point2String() =
        "(${firstsign}${first}, ${this@Point.secondsign}${this.second})"
}
*/
/*
 fluency example
class DateUtil(val number: Int, val tense: Tense) {
    enum class Tense {
        ago, from_now
    }

    override fun toString(): String {
        val today = Calendar.getInstance()
        when (tense) {
            ago -> today.add(Calendar.DAY_OF_MONTH, -number)
            from_now -> today.add(Calendar.DAY_OF_MONTH, number)
        }
        return today.getTime().toString()
    }
}

infix fun Int.days(timing: Tense) = DateUtil(this, timing)
    println(6 days from_now)
    println(9 days ago)*/

/* building fluency with DSL
open class MeetingTime(var time: String = "") {
    protected fun convertToString(time: Double) = String.format("%.02f", time)
}

class StartTime : MeetingTime() {
    infix fun at(theTime: Double) {
        time = convertToString(theTime)
    }
}

class EndTime : MeetingTime() {
    infix fun by(theTime: Double) {
        time = convertToString(theTime)
    }
}

class Meeting(val title: String) {
    val start = StartTime()
    val end = EndTime()
    override fun toString() =
        "$title Meeting starts ${start.time} ends ${end.time}"
}

infix fun String.meeting(block: Meeting.() -> Unit) {
    val meeting = Meeting("morning meeting")
    meeting.block()

    println(meeting)
}
"meeting" meeting {
        start at 6.0
        end by 9.0
    }
    */



