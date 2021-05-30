package utils

import kotlin.math.abs

typealias Vector = DoubleArray

object CollectionUtils {
    fun <E> MutableList<E>.getOrSet(index: Int, defaultValue: (Int) -> E): E =
        this.getOrElse(index) { _ ->
            this.add(index, defaultValue(index))
            this[index]
        }
    val ClosedRange<Double>.middle
        get() = (start + endInclusive) * 0.5
    val ClosedRange<Double>.lenght
        get() = endInclusive-start
}
