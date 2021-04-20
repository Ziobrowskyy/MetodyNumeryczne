import java.util.*
import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.sin

object Intergate {
   fun trapeze(f: (Double) -> Double, xs: Double, xe: Double, dx: Double): Double {
      var sum: Double = 0.0
      var x: Double = xs
      while (x < xe) {
         sum += f(x) + f(x + dx)
         x += dx
      }
      return dx * 0.5 * sum
   }

   fun trapeze(xs: DoubleArray, ys: DoubleArray): Double {
      assert(xs.size == ys.size)
      var sum: Double = 0.0
      for (i in 0 until xs.size - 1) {
         val dx = xs[i + 1] - xs[i]
         sum += 0.5 * dx * (ys[i] + ys[i + 1])
      }
      return sum
   }

   fun trapeze(f: (Double) -> Double, xs: DoubleArray): Double {
      assert(xs.size == ys.size)
      var sum: Double = 0.0
      for (i in 0 until xs.size - 1) {
         val dx = xs[i + 1] - xs[i]
         sum += 0.5 * dx * (f(xs[i]) + f(xs[i + 1]))
      }
      return sum
   }

   fun NewtonCotes(f: (Double) -> Double, xs: Double, xe: Double, dx: Double): Double {
      var sum: Double = 0.0
      var x: Double = xs
      while (x < xe) {
         sum += (f(x) + 4.0 * f(x + dx * 0.5) + f(x + dx))
         x += dx
      }
      return dx / 6 * sum
   }

   fun NewtonCotes(xs: DoubleArray, ys: DoubleArray): Double {
      assert(xs.size == ys.size)
      var sum: Double = 0.0
      for (i in 0 until xs.size - 1) {
         val dx = xs[i + 1] - xs[i]
         sum += dx / 6 * (ys[i] + 4.0 * 0.5 * (ys[i] + ys[i + 1]) + ys[i + 1])
      }
      return sum
   }
   fun NewtonCotes(f: (Double) -> Double, xs: DoubleArray): Double {
      assert(xs.size == ys.size)
      var sum: Double = 0.0
      for (i in 0 until xs.size - 1) {
         val dx = xs[i + 1] - xs[i]
         sum += dx / 6 * (f(xs[i]) + 4.0 * 0.5 * (f(xs[i]) + f(xs[i + 1])) + f(xs[i + 1]))
      }
      return sum
   }
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
   printlnDouble(Intergate.trapeze(::poly, xsNonEquidistant))

   println("Poly NewtonCotes")
   printlnDouble(Intergate.NewtonCotes(::poly, -2.0, 2.0, .1))
   println("Poly NewtonCotes non equidistant")
   printlnDouble(Intergate.NewtonCotes(::poly, xsNonEquidistant))

   println("Sinus trapeze")
   printlnDouble(Intergate.trapeze(::withSinus, .0, 4.5, .1))

   println("Sinus NewtonCotes")
   printlnDouble(Intergate.NewtonCotes(::withSinus, .0, 4.5, .1))

   println("Expo trapeze")
   printlnDouble(Intergate.trapeze(::withExponent, -2.0, 2.0, .1))
   println("Expo trapeze non equidistant")
   printlnDouble(Intergate.trapeze(::withExponent, xsNonEquidistant))

   println("Expo NewtonCotes")
   printlnDouble(Intergate.NewtonCotes(::withExponent, -2.0, 2.0, .1))
   println("Expo NewtonCotes non equidistant")
   printlnDouble(Intergate.NewtonCotes(::withExponent, xsNonEquidistant))
}

fun printlnDouble(x: Double) {
   println(String.format(Locale.ENGLISH, "%.4f",x))
}

val xs: DoubleArray = doubleArrayOf(
   -2.0,
   -1.95,
   -1.9,
   -1.85,
   -1.8,
   -1.75,
   -1.7,
   -1.65,
   -1.6,
   -1.55,
   -1.5,
   -1.45,
   -1.4,
   -1.35,
   -1.3,
   -1.25,
   -1.2,
   -1.15,
   -1.1,
   -1.05,
   -1.0,
   -0.95,
   -0.9,
   -0.85,
   -0.8,
   -0.75,
   -0.7,
   -0.65,
   -0.6,
   -0.55,
   -0.5,
   -0.45,
   -0.4,
   -0.35,
   -0.3,
   -0.25,
   -0.2,
   -0.15,
   -0.1,
   -0.05,
   0.0,
   0.05,
   0.1,
   0.15,
   0.2,
   0.25,
   0.3,
   0.35,
   0.4,
   0.45,
   0.5,
   0.55,
   0.6,
   0.65,
   0.7,
   0.75,
   0.8,
   0.85,
   0.9,
   0.95,
   1.0,
   1.05,
   1.1,
   1.15,
   1.2,
   1.25,
   1.3,
   1.35,
   1.4,
   1.45,
   1.5,
   1.55,
   1.6,
   1.65,
   1.7,
   1.75,
   1.8,
   1.85,
   1.9,
   1.95,
   2.0
)
val ys: DoubleArray = doubleArrayOf(
   1.4,
   4.7942275,
   8.05784,
   11.1922775,
   14.19904,
   17.0796875,
   19.83584,
   22.4691775,
   24.98144,
   27.3744275,
   29.65,
   31.8100775,
   33.85664,
   35.7917275,
   37.61744,
   39.3359375,
   40.94944,
   42.4602275,
   43.87064,
   45.1830775,
   46.4,
   47.5239275,
   48.55744,
   49.5031775,
   50.36384,
   51.1421875,
   51.84104,
   52.4632775,
   53.01184,
   53.4897275,
   53.9,
   54.2457775,
   54.53024,
   54.7566275,
   54.92824,
   55.0484375,
   55.12064,
   55.1483275,
   55.13504,
   55.0843775,
   55.0,
   54.8856275,
   54.74504,
   54.5820775,
   54.40064,
   54.2046875,
   53.99824,
   53.7853775,
   53.57024,
   53.3570275,
   53.15,
   52.9534775,
   52.77184,
   52.6095275,
   52.47104,
   52.3609375,
   52.28384,
   52.2444275,
   52.24744,
   52.2976775,
   52.4,
   52.5593275,
   52.78064,
   53.0689775,
   53.42944,
   53.8671875,
   54.38744,
   54.9954775,
   55.69664,
   56.4963275,
   57.4,
   58.4131775,
   59.54144,
   60.7904275,
   62.16584,
   63.6734375,
   65.31904,
   67.1085275,
   69.04784,
   71.1429775,
   73.4
)
val xsNonEquidistant: DoubleArray = doubleArrayOf(
   -2.0,
   -1.75,
   -1.35,
   -1.1,
   -0.9,
   -0.85,
   -0.8,
   -0.6,
   -0.5,
   -0.45,
   -0.4,
   -0.05,
   0.0,
   0.05,
   0.1,
   0.5,
   0.55,
   0.6,
   0.65,
   0.7,
   0.75,
   0.8,
   0.85,
   0.9,
   0.95,
   1.0,
   1.1,
   1.15,
   1.2,
   1.25,
   1.3,
   1.5,
   1.55,
   1.6,
   1.7,
   1.85,
   2.0
)