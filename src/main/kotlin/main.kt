import java.util.*
import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.sin

fun printlnDouble(x: Double) {
   println(String.format(Locale.ENGLISH, "%.4f", x))
}

fun main(args: Array<String>) {

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

   println("Poly trapeze")
   printlnDouble(Intergate.trapeze(::poly, -2.0, 2.0, .1))
   println("Poly trapeze non equidistant")
   printlnDouble(Intergate.trapeze(::poly, Data.xsNonEquidistant))

   println("Poly NewtonCotes")
   printlnDouble(Intergate.NewtonCotes(::poly, -2.0, 2.0, .1))
   println("Poly NewtonCotes non equidistant")
   printlnDouble(Intergate.NewtonCotes(::poly, Data.xsNonEquidistant))

   println("Sinus trapeze")
   printlnDouble(Intergate.trapeze(::withSinus, .0, 4.5, .1))

   println("Sinus NewtonCotes")
   printlnDouble(Intergate.NewtonCotes(::withSinus, .0, 4.5, .1))

   println("Expo trapeze")
   printlnDouble(Intergate.trapeze(::withExponent, -2.0, 2.0, .1))
   println("Expo trapeze non equidistant")
   printlnDouble(Intergate.trapeze(::withExponent, Data.xsNonEquidistant))

   println("Expo NewtonCotes")
   printlnDouble(Intergate.NewtonCotes(::withExponent, -2.0, 2.0, .1))
   println("Expo NewtonCotes non equidistant")
   printlnDouble(Intergate.NewtonCotes(::withExponent, Data.xsNonEquidistant))
}

