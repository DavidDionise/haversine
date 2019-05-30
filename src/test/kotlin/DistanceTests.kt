import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.lang.Math.PI
import java.math.RoundingMode
import java.text.DecimalFormat

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DistanceTests {
    lateinit var df: DecimalFormat

    @BeforeAll
    fun init() {
        // Need to trim down the number of decimal places
        //  to get equality
        df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
    }

    @Test
    fun `Should get distance between two coordinates on equator`() {
        // These points are exactly 90 degrees from each other,
        //  making them the distance of exactly 1/4 of the circumference
        //  of the earths radius
        val c1 = Coordinate(0.0, 0.0)
        val c2 = Coordinate(0.0, 90.0)

        val distance = distance(c1, c2)
        assertEquals(
            df.format(distance),
            // asserting that the distance is the same as 1/4 of the
            //  distance of the circumference of earth
            df.format(circumference(R) / 4)
        )
    }
}

fun circumference(radius: Double) = 2 * PI * radius