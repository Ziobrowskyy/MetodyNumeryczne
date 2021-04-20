import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.sin

object Functions {
   fun makeHorner(coof: DoubleArray): (Double) -> Double {

      fun horner(x: Double): Double {
         var sum: Double = coof.first()
         for (i in 1 until coof.size) {
            sum *= x
            sum += coof[i]
         }
         return sum
      }

      return ::horner
   }

   fun lin(x: Double): Double {
      return x.pow(2) + 2 * x + 10.0
   }

   fun poly(x: Double): Double {
      return 0.4 * x.pow(4) + 5.0 * x.pow(3) - 6.0 * x.pow(2) - 2.0 * x + 55.0

   }

   fun withSinus(x: Double): Double {
      return x.pow(2) * sin(x).pow(3)
   }

   fun withExponent(x: Double): Double {
      return exp(x.pow(2)) * (x - 1.0)
   }
}