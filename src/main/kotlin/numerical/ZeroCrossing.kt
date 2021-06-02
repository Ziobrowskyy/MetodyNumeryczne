package numerical

import utils.CollectionUtils.middle
import utils.DoubleUtils.equals
import kotlin.math.abs

object ZeroCrossing {
    private const val maxIterations = 500
    private const val epsilon = 1e-6

    fun newton(range: ClosedRange<Double>, f: (Double) -> Double, df: (Double) -> Double): Double? {
        var x: Double = range.middle
        for (i in 0 until maxIterations) {
            val xPrime = x - f(x) / df(x)
            if (xPrime.equals(x, epsilon))
                return x
            x = xPrime
        }
        return null
    }

    fun newton(range: ClosedRange<Double>, f: (Double) -> Double): Double? {
        val df = Derivative.ofFunction(f, range.middle)
        return newton(range, f, df)
    }

    fun secant(range: ClosedRange<Double>, f: (Double) -> Double): Double? {
        var x0 = range.start
        var x1 = range.endInclusive
        if ((f(x1) - f(x0)).equals(0.0, epsilon)) {
            val dx = abs(x1 - x0) * 0.1
            x0 += dx
            x1 += dx
        }
        for (i in 0 until maxIterations) {
            val x2 = x1 - f(x1) * (x1 - x0) / (f(x1) - f(x0))

            if (f(x2).equals(0.0, epsilon))
                return x2

            x0 = x1
            x1 = x2
        }
        return null
    }

    fun falsePosition(range: ClosedRange<Double>, f: (Double) -> Double): Double? {
        var a = range.start
        var b = range.endInclusive
        if ((f(b) - f(a)).equals(0.0, epsilon)) {
            val dx = abs(b - a) * 0.1
            a += dx
            b += dx
        }
        for (i in 0 until maxIterations) {
            val c = (a * f(b) - b * f(a)) / (f(b) - f(a))

            if (f(c).equals(0.0, epsilon))
                return c

            if (f(a) * f(c) < 0)
                b = c
            else
                a = c
        }
        return null
    }

    fun bisection(range: ClosedRange<Double>, f: (Double) -> Double): Double? {
        var x0 = range.start
        var x1 = range.endInclusive
//        if (x0 * x1 >= 0)
//            return null
        for (i in 0 until maxIterations) {
            val xPrime = (x0 + x1) * 0.5

            if (f(xPrime).equals(0.0, epsilon) || ((x1 - x0) * 0.5).equals(0.0, epsilon))
                return xPrime
            // if sign(f(c)) = sign(f(a)) then a ← c else b ← c // new interval
            if (f(x0) * f(xPrime) >= 0)
                x0 = xPrime
            else
                x1 = xPrime
        }
        return null
    }
}
