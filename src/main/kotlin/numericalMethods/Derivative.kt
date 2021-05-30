package numericalMethods

import utils.CollectionUtils.lenght

object Derivative {
    fun ofFunction(f: (Double) -> Double, range: ClosedRange<Double>): (Double) -> Double {
        return fun(x: Double): Double {
            return (f(x + range.lenght) - f(x - range.lenght)) / (2 * range.lenght)
        }
    }
    fun ofFunction(f: (Double) -> Double, point: Double): (Double) -> Double {
        return fun(x: Double): Double {
            return (f(x + point) - f(x - point)) / (2 * point)
        }
    }
}