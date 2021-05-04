import java.lang.StringBuilder

typealias Vector = DoubleArray

class Matrix(val n: Int = 3, val m: Int = n, val isTriangular: Boolean = false, fillFunction: (i :Int, j: Int) -> Double) {
	constructor(n: Int = 3, m: Int = n, isTriangular: Boolean = false, fillValue: Double = 0.0) : this(
		n,
		m,
		isTriangular,
		{ _, _ -> fillValue }
	)
	
	val data: Array<Vector>
	
	init {
		if (isTriangular) {
			assert(n == m)
			data = Array(n) { i -> DoubleArray(i+1) { j -> fillFunction(i, j) } }
		} else {
			data = Array(n) { i -> DoubleArray(m) { j -> fillFunction(i, j) } }
		}
	}
	
	operator fun get(i: Int, j: Int) = data[i][j]
	
	operator fun set(i: Int, j: Int, value: Double) {
		data[i][j] = value
	}
	
	fun print() {
		data.forEach {
			println(vectorToString(it))
		}
	}
	fun vectorToString(array: DoubleArray): String {
		val sb = StringBuilder("[")
		for(i in 0 until array.size -1) {
			sb.append(array[i])
			sb.append(",")
		}
		sb.append(array.last())
		sb.append("]")
		return sb.toString()
	}
}