import java.lang.StringBuilder
import java.util.*
import kotlin.math.abs
import kotlin.math.max

typealias Vector = DoubleArray

fun printlnDouble(x: Double) {
    println(String.format(Locale.ENGLISH, "%.6f", x))
}

fun Double.equals(other: Double, epsilon: Double = 0.00001) = abs(this - other) <= epsilon

infix operator fun Vector.plusAssign(value: Double) {
    for (i in this.indices)
        this[i] += value
}

infix operator fun Vector.minusAssign(value: Double) = this.plusAssign(-value)

infix operator fun Vector.plusAssign(other: Vector) {
    for (i in this.indices)
        this[i] += other.getOrElse(i) { 0.0 }
}

infix operator fun Vector.minusAssign(other: Vector) {
    for (i in this.indices)
        this[i] -= other.getOrElse(i) { 0.0 }
}

@Override
infix operator fun Vector.plus(value: Double): Vector = this.map { it + value }.toDoubleArray()

infix operator fun Vector.plus(other: Vector): Vector = Vector(max(this.size, other.size)) { i ->
    this.getOrElse(i) { 0.0 } + other.getOrElse(i) { 0.0 }
}

infix operator fun Vector.times(value: Double): Vector = this.map { it * value }.toDoubleArray()

infix operator fun Vector.times(other: Vector): Vector {
    val result = Vector(this.size + other.size - 1) { 0.0 }
    for (i in this.indices) {
        for (j in other.indices) {
            result[i + j] += this[i] * other[j]
        }
    }
    return result
}

fun vectorToString(array: DoubleArray): String {
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

fun <E> MutableList<E>.getOrSet(i: Int, f: (Int) -> E): E =
    this.getOrElse(i) { _ ->
        this.add(i, f(i))
        this[i]
    }
