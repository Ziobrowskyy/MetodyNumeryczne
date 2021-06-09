package numerical

import utils.CollectionUtils.length

object Derivative {
    fun ofFunction(f: (Double) -> Double, range: ClosedRange<Double>): (Double) -> Double {
        return fun(x: Double): Double {
            return (f(x + range.length) - f(x - range.length)) / (2 * range.length)
        }
    }
    fun ofFunction(f: (Double) -> Double, point: Double): (Double) -> Double {
        return fun(x: Double): Double {
            return (f(x + point) - f(x - point)) / (2 * point)
        }
    }
}