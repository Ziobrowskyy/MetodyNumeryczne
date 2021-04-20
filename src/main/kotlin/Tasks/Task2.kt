package Tasks

import Functions
import printlnDouble

object Task2 : Task(){
   override val name: String = ""
   override fun runTask() {
      println("Poly trapeze")
      printlnDouble(Intergate.trapeze(Functions::poly, -2.0, 2.0, .1))

      println("Poly trapeze horner")
      printlnDouble(Intergate.trapeze(Functions.makeHorner(Data.polyCoof), -2.0, 2.0, .1))

      println("Poly trapeze horner non equidistant")
      printlnDouble(Intergate.trapeze(Functions.makeHorner(Data.polyCoof), Data.xsNonEquidistant))

   }
}