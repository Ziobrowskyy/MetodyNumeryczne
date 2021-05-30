package utils

import java.util.*
import kotlin.math.abs

object DoubleUtils {
    public fun printlnDouble(x: Double) {
        println(String.format(Locale.ENGLISH, "%.6f", x))
    }

    public fun Double.equals(other: Double, epsilon: Double = 0.00001) = abs(this - other) <= epsilon

}