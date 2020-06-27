import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    getAirportStatus(listOf("SFO", "IAD", "IAH", "ORD", "LAX"))
        .forEach { println(it) }
}