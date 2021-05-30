import utils.StringUtils.vectorToString
import utils.Vector
import java.util.*

data class Matrix(
    val n: Int = 3,
    val m: Int = n,
    val isTriangular: Boolean = false,
    private val fillFunction: (i: Int, j: Int) -> Double
) : Iterable<Vector> {

    constructor(n: Int = 3, m: Int = n, isTriangular: Boolean = false, fillValue: Double = 0.0) : this(
        n,
        m,
        isTriangular,
        { _, _ -> fillValue }
    )

    constructor(values: Array<Vector>) : this(
        n = values.size,
        m = values.first().size,
        isTriangular = false,
        { i, j -> values[i][j] }
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

    override fun toString(): String {
        return data.map { vectorToString(it) }.reduce { acc, s -> acc.plus(s).plus('\n') }
    }

    override fun iterator(): Iterator<Vector> = this.data.iterator()
}