package utils

object VectorUtils {

    public infix operator fun Vector.plusAssign(value: Double) {
        for (i in this.indices)
            this[i] += value
    }

    public infix operator fun Vector.minusAssign(value: Double) = this.plusAssign(-value)

    public infix operator fun Vector.plusAssign(other: Vector) {
        for (i in this.indices)
            this[i] += other.getOrElse(i) { 0.0 }
    }

    public infix operator fun Vector.minusAssign(other: Vector) {
        for (i in this.indices)
            this[i] -= other.getOrElse(i) { 0.0 }
    }

    @Override
    public infix operator fun Vector.plus(value: Double): Vector = this.map { it + value }.toDoubleArray()

    public infix operator fun Vector.plus(other: Vector): Vector = Vector(kotlin.math.max(this.size, other.size)) { i ->
        this.getOrElse(i) { 0.0 } + other.getOrElse(i) { 0.0 }
    }

    public infix operator fun Vector.times(value: Double): Vector = this.map { it * value }.toDoubleArray()

    public infix operator fun Vector.times(other: Vector): Vector {
        val result = Vector(this.size + other.size - 1) { 0.0 }
        for (i in this.indices) {
            for (j in other.indices) {
                result[i + j] += this[i] * other[j]
            }
        }
        return result
    }

}