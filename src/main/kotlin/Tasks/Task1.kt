package Tasks

import Functions
import printlnDouble

object Task1 : Task(){
   override val name: String = "Metoda trapezów dla funkcji f"
   override fun runTask() {
      val polyCoof:DoubleArray = doubleArrayOf(0.4, 5.0, -6.0, -2.0, 55.0)

      println("Poly trapeze and simple polynomial")
      printlnDouble(Intergate.trapeze(Functions::poly, -2.0, 2.0, .05))

      println("Poly trapeze Horner and equidistant nodes")
      printlnDouble(Intergate.trapeze(Functions.makeHorner(polyCoof), -2.0, 2.0, .05))

      println("Poly trapeze Horner non equidistant nodes")
      printlnDouble(Intergate.trapeze(Functions.makeHorner(polyCoof), Data.xsNonEquidistant))

   }
}