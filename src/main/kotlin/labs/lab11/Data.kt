package labs.lab11

import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

object Data {
    const val alpha = -1e-10
    const val beta = 0.0

    //dT/dt = alpha * (T^4 - beta)
    //T(0) = temp_0
    fun dT_dt(t: Double): Double {
        return alpha * (t.pow(4) - beta)
    }
}