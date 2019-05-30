// formula taken from https://en.wikipedia.org/wiki/Haversine_formula

const val R = 3958.8 // Earth radius in miles

fun distance(c1: Coordinate, c2: Coordinate): Double {
    return 2 * R * Math.asin(
        Math.sqrt(
            Math.pow(
                Math.sin(Math.abs(c1.lat - c1.lat) / 2),
                2.0
            ) + Math.cos(c1.lat) * Math.cos(c2.lat) *
                    Math.pow(
                        Math.sin(Math.abs(c1.lng - c2.lng) / 2),
                        2.0
                    )
        )
    )
}

class Coordinate(_lat: Double, _long: Double) {
    // Google uses degrees, but Java trig functions expect radians
    val lat = Math.toRadians(_lat)
    val lng = Math.toRadians(_long)
}