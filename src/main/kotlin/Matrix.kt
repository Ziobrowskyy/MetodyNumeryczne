import java.lang.StringBuilder
import java.util.*
import kotlin.math.max

class Matrix(
    val n: Int = 3,
    val m: Int = n,
    val isTriangular: Boolean = false,
    fillFunction: (i: Int, j: Int) -> Double
) : Iterable<Vector> {
    constructor(n: Int = 3, m: Int = n, isTriangular: Boolean = false, fillValue: Double = 0.0) : this(
        n,
        m,
        isTriangular,
        { _, _ -> fillValue }
    )

    private val data: Array<Vector> = if (isTriangular) {
        assert(n == m)
        Array(n) { i -> DoubleArray(i + 1) { j -> fillFunction(i, j) } }
    } else {
        Array(n) { i -> DoubleArray(m) { j -> fillFunction(i, j) } }
    }

    operator fun get(i: Int, j: Int) = data[i].getOrElse(j) { 0.0 }
    operator fun get(i: Int) = data[i]

    operator fun set(i: Int, j: Int, value: Double) {
        data[i][j] = value
    }

    operator fun set(i: Int, value: Vector) {
        data[i] = value
    }

    fun print() {
        data.forEach {
            println(vectorToString(it))
        }
    }

    override fun iterator(): Iterator<Vector> = this.data.iterator()
}