import java.util.*
import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.sin

fun printlnDouble(x: Double) {
   println(String.format(Locale.ENGLISH, "%.4f", x))
}


fun main(args: Array<String>) {
   val polyCoof:DoubleArray = doubleArrayOf(0.4, 5.0, -6.0, -2.0, 55.0)


   println("Poly trapeze")
   printlnDouble(Intergate.trapeze(Functions::poly, -2.0, 2.0, .1))

   println("Poly trapeze horner")
   printlnDouble(Intergate.trapeze(Functions.makeHorner(polyCoof), -2.0, 2.0, .1))

   println("Poly trapeze non equidistant")
   printlnDouble(Intergate.trapeze(Functions.makeHorner(polyCoof), Data.xsNonEquidistant))

   println("Poly NewtonCotes")
   printlnDouble(Intergate.NewtonCotes(Functions::poly, -2.0, 2.0, .1))

   println("Poly NewtonCotes non equidistant")
   printlnDouble(Intergate.NewtonCotes(Functions::poly, Data.xsNonEquidistant))

   println("Sinus trapeze")
   printlnDouble(Intergate.trapeze(Functions::withSinus, .0, 4.5, .1))

   println("Sinus NewtonCotes")
   printlnDouble(Intergate.NewtonCotes(Functions::withSinus, .0, 4.5, .1))

   println("Expo trapeze")
   printlnDouble(Intergate.trapeze(Functions::withExponent, -2.0, 2.0, .1))
   println("Expo trapeze non equidistant")
   printlnDouble(Intergate.trapeze(Functions::withExponent, Data.xsNonEquidistant))

   println("Expo NewtonCotes")
   printlnDouble(Intergate.NewtonCotes(Functions::withExponent, -2.0, 2.0, .1))
   println("Expo NewtonCotes non equidistant")
   printlnDouble(Intergate.NewtonCotes(Functions::withExponent, Data.xsNonEquidistant))
}

