package labs.lab7

import Task
import Functions
import numericalMethods.Integrate
import utils.DoubleUtils.printlnDouble

object Task1 : Task() {
   override val name: String = "Obliczanie wartości kwadratury podanych funkcji za pomocą kwadratury Gaussa-Legendre'a"

   override fun runTask() {
      println("n = 1")
      printThinSeparator()
      println("Funkcja liniowa")
      printlnDouble(Integrate.legendre2(-1.0, 4.0, Functions::lin))
      println("Funkcja sinusowa")
      printlnDouble(Integrate.legendre2(.0, 4.5, Functions::withSinus))
      println("Funkcja exp")
      printlnDouble(Integrate.legendre2(-2.0, 2.0, Functions::withExponent))
      println("Funkcja wielomianowa")
      printlnDouble(Integrate.legendre2(-2.0, 2.0, Functions.horner(Data.polyCoof)))

      printThinSeparator()
      println("n = 2")
      printThinSeparator()

      println("Funkcja liniowa")
      printlnDouble(Integrate.legendre3(-1.0, 4.0, Functions::lin))
      println("Funkcja sinusowa")
      printlnDouble(Integrate.legendre3(.0, 4.5, Functions::withSinus))
      println("Funkcja exp")
      printlnDouble(Integrate.legendre3(-2.0, 2.0, Functions::withExponent))
      println("Funkcja wielomianowa")
      printlnDouble(Integrate.legendre3(-2.0, 2.0, Functions.horner(Data.polyCoof)))

      printThinSeparator()
      println("n = 3")
      printThinSeparator()

      println("Funkcja liniowa")
      printlnDouble(Integrate.legendre4(-1.0, 4.0, Functions::lin))
      println("Funkcja sinusowa")
      printlnDouble(Integrate.legendre4(.0, 4.5, Functions::withSinus))
      println("Funkcja exp")
      printlnDouble(Integrate.legendre4(-2.0, 2.0, Functions::withExponent))
      println("Funkcja wielomianowa")
      printlnDouble(Integrate.legendre4(-2.0, 2.0, Functions.horner(Data.polyCoof)))

      printThinSeparator()
      println("n = 4")
      printThinSeparator()

      printlnDouble(Integrate.legendre5(-1.0, 4.0, Functions::lin))
      println("Funkcja sinusowa")
      printlnDouble(Integrate.legendre5(.0, 4.5, Functions::withSinus))
      println("Funkcja exp")
      printlnDouble(Integrate.legendre5(-2.0, 2.0, Functions::withExponent))
      println("Funkcja wielomianowa")
      printlnDouble(Integrate.legendre5(-2.0, 2.0, Functions.horner(Data.polyCoof)))
   }
}