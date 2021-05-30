package utils

import utils.DoubleUtils.equals
import Matrix
import java.lang.StringBuilder
import java.util.*

object StringUtils {

    public fun vectorToFunctionString(vector: Vector, base: Matrix): String {
        val sb = StringBuilder(
            String.format(
                Locale.ENGLISH,
                "%.4f * (%s)",
                vector.first(),
                vectorToFunctionString(base.first())
            )
        )
        for (i in 1 until vector.size) {
            sb.append(String.format(Locale.ENGLISH, " + %.4f * (%s)", vector[i], vectorToFunctionString(base[i])))
        }
        return sb.toString()
    }

    public fun vectorToFunctionString(vector: Vector): String {
        val sb = StringBuilder()
        var first = true
        for (i in vector.indices) {
            if (vector[i].equals(0.0, 0.001))
                continue
            val xString = when {
                i == 0 -> ""
                i == 1 -> "x"
                else -> "x^$i"
            }
            sb.append(String.format(Locale.ENGLISH, "%s%.4f %s", if (first) "" else " + ", vector[i], xString))
            first = false
        }
        return sb.toString()
    }

    public fun vectorToString(array: DoubleArray): String {
        val sb = StringBuilder("[")
        for (i in 0 until array.size - 1) {
//            sb.append(array[i])
            sb.append(String.format(Locale.ENGLISH, "%.4f", array[i]))
            sb.append(",")
        }
        sb.append(String.format(Locale.ENGLISH, "%.4f", array.last()))
        sb.append("]")
        return sb.toString()
    }

}