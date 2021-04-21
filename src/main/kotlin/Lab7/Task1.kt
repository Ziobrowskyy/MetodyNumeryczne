package Lab7

import Task
import Functions
import printlnDouble

object Task1 : Task() {
   override val name: String = "Obliczanie wartości kwadratury podanych funkcji za pomocą kwadratury Gaussa-Legendre'a"

   override fun runTask() {
      println("n = 1")
      printThinSeparator()
      println("Funkcja liniowa")
      printlnDouble(Integrate.legendre2(Functions::lin, -1.0, 4.0))
      println("Funkcja sinusowa")
      printlnDouble(Integrate.legendre2(Functions::withSinus, .0, 4.5))
      println("Funkcja exp")
      printlnDouble(Integrate.legendre2(Functions::withExponent, -2.0, 2.0))
      println("Funkcja wielomianowa")
      printlnDouble(Integrate.legendre2(Functions.makeHorner(Data.polyCoof), -2.0, 2.0))

      printThinSeparator()
      println("n = 2")
      printThinSeparator()

      println("Funkcja liniowa")
      printlnDouble(Integrate.legendre3(Functions::lin, -1.0, 4.0))
      println("Funkcja sinusowa")
      printlnDouble(Integrate.legendre3(Functions::withSinus, .0, 4.5))
      println("Funkcja exp")
      printlnDouble(Integrate.legendre3(Functions::withExponent, -2.0, 2.0))
      println("Funkcja wielomianowa")
      printlnDouble(Integrate.legendre3(Functions.makeHorner(Data.polyCoof), -2.0, 2.0))

      printThinSeparator()
      println("n = 3")
      printThinSeparator()

      println("Funkcja liniowa")
      printlnDouble(Integrate.legendre4(Functions::lin, -1.0, 4.0))
      println("Funkcja sinusowa")
      printlnDouble(Integrate.legendre4(Functions::withSinus, .0, 4.5))
      println("Funkcja exp")
      printlnDouble(Integrate.legendre4(Functions::withExponent, -2.0, 2.0))
      println("Funkcja wielomianowa")
      printlnDouble(Integrate.legendre4(Functions.makeHorner(Data.polyCoof), -2.0, 2.0))

      printThinSeparator()
      println("n = 4")
      printThinSeparator()

      printlnDouble(Integrate.legendre5(Functions::lin, -1.0, 4.0))
      println("Funkcja sinusowa")
      printlnDouble(Integrate.legendre5(Functions::withSinus, .0, 4.5))
      println("Funkcja exp")
      printlnDouble(Integrate.legendre5(Functions::withExponent, -2.0, 2.0))
      println("Funkcja wielomianowa")
      printlnDouble(Integrate.legendre5(Functions.makeHorner(Data.polyCoof), -2.0, 2.0))
   }
}