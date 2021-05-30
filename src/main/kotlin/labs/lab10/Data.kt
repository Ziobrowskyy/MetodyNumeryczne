package labs.lab10

import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

object Data {
    fun g(x: Double): Double {
        return x.pow(2) - 612
    }
    fun function1st(x: Double): Double {
        return Functions.horner(doubleArrayOf(-3.0, -3.0, 1.0, 1.0), true)(x)
    }

    fun function1stDeriv(x: Double): Double {
        return Functions.horner(doubleArrayOf(-3.0, 2.0, 3.0), true)(x)
    }

    fun function2nd(x: Double): Double {
        return Functions.horner(doubleArrayOf(-2.0, 0.0, 1.0), true)(x)
    }

    fun function2ndDeriv(x: Double): Double {
        return Functions.horner(doubleArrayOf(0.0, 2.0), true)(x)
    }

    fun function3rd(x: Double): Double {
        return sin(x.pow(2)) - x.pow(2)
    }

    fun function3rdDeriv(x: Double): Double {
        return 2.0 * x * cos(x.pow(2)) - 2.0 * x
    }

    fun function4thDeriv(x: Double): Double {
        return 2.0 * x * cos(x.pow(2)) - 2.0 * x
    }

    fun function4th(x: Double): Double {
        return sin(x.pow(2)) - x.pow(2) + 0.5
    }
}