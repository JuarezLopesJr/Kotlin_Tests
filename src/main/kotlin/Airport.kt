import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import java.net.URL

data class Airport(
    @Json(name = "IATA")
    val code: String,

    @Json(name = "Name")
    val name: String,

    @Json(name = "Delay")
    val delay: Boolean
) {
    companion object {
        fun sort(airports: List<Airport>): List<Airport> = airports.sortedBy { it.name }

        /* the returning type from parse() is Airport? that's why i'm casting to Airport */
        fun getAirportData(code: String) =
            try {
                Klaxon().parse<Airport>(fetchData(code)) as Airport
            } catch (ex: Exception) {
                Airport(code, "Invalid Airport", false)
            }

        fun fetchData(code: String) =
            URL("https://soa.smext.faa.gov/asws/api/airport/status/$code")
                .readText()
    }
}