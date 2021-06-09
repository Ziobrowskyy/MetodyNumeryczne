package labs.lab12

import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.sin

object Data {
    fun powSin(x: Double): Double {
        return x.pow(2) * sin(x).pow(3)
    }

    fun powExp(x: Double): Double {
        return x.pow(2) * exp(x.pow(2)) * (x - 1.0)
    }
}