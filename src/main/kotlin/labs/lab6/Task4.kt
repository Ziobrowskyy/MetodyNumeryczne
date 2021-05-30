package labs.lab6

import Functions
import numericalMethods.Integrate
import Task
import utils.DoubleUtils.printlnDouble
import kotlin.math.abs

object Task4 : Task() {
   override val name: String = "Zadanie 4. \nKwadratura dla funkcji x^2 sin^3(x)"
   override fun runTask() {
      val expectedValue: Double = -4.402597402
      val epsilon: Double = 0.0001

      println("Wartość całki obliczona za pomocą WolframAlpha: $expectedValue")
      printThinSeparator()

      println("Metoda trapezów:")
      printThinSeparator()

      println("Funkcja obliczana ze stałym krokiem dx = 0.1")
      printlnDouble(Integrate.trapeze(.0, 4.5, .1, Functions::withSinus))
      println("Funkcja obliczana ze stałym krokiem dx = 0.01")
      printlnDouble(Integrate.trapeze(.0, 4.5, .01, Functions::withSinus))
      println("Funkcja obliczana ze stałym krokiem dx = 0.001")
      printlnDouble(Integrate.trapeze(.0, 4.5, .001, Functions::withSinus))

      printThinSeparator()

      println("Sprawdzanie dla jakiej wartości kroku błąd otrzymajnej wartości jest mniejszy od $epsilon")
      var step: Double = 1.0
      do {
         step /= 10
         val result = Integrate.trapeze(.0, 4.5, step, Functions::withSinus)
         val diff = abs(expectedValue-result)
         println("Różnica wartści dla wielkości kroku $step wynosi $diff")
      } while (diff >= epsilon)
      printThinSeparator()

      println("Metoda Simpsona:")
      printThinSeparator()

      println("Funkcja obliczana ze stałym krokiem dx = 0.1")
      printlnDouble(Integrate.simpson(.0, 4.5, .1, Functions::withSinus))
      println("Funkcja obliczana ze stałym krokiem dx = 0.01")
      printlnDouble(Integrate.simpson(.0, 4.5, .01, Functions::withSinus))
      println("Funkcja obliczana ze stałym krokiem dx = 0.001")
      printlnDouble(Integrate.simpson(.0, 4.5, .001, Functions::withSinus))
      printThinSeparator()

      println("Sprawdzanie dla jakiej wartości kroku błąd otrzymajnej wartości jest mniejszy od $epsilon")
      step = 1.0
      do {
         step /= 10
         val result = Integrate.simpson(.0, 4.5, step, Functions::withSinus)
         val diff = abs(expectedValue-result)
         println("Różnica wartści dla wielkości kroku $step wynosi $diff")
      } while (diff >= epsilon)

   }
}