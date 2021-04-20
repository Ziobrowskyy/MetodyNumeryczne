package Tasks

import Functions
import printlnDouble
import kotlin.math.abs

object Task5 : Task(){
   override val name: String = "Zadanie 5. \nKwadratura dla funkcji exp(x^2)(x-1)"
   override fun runTask() {
      val expectedValue: Double =-32.905255531
      val epsilon: Double = 0.0001

      println("Wartość całki obliczona za pomocą WolframAlpha: $expectedValue")
      printThinSeparator()

      println("Metoda trapezów:")
      printThinSeparator()

      println("Funkcja obliczana ze stałym krokiem dx = 0.1")
      printlnDouble(Intergate.trapeze(Functions::withExponent, -2.0, 2.0, .1))
      println("Funkcja obliczana ze stałym krokiem dx = 0.01")
      printlnDouble(Intergate.trapeze(Functions::withExponent, -2.0, 2.0, .01))
      println("Funkcja obliczana ze stałym krokiem dx = 0.001")
      printlnDouble(Intergate.trapeze(Functions::withExponent, -2.0, 2.0, .001))

      printThinSeparator()

      println("Sprawdzanie dla jakiej wartości kroku błąd otrzymajnej wartości jest mniejszy od $epsilon")
      var step: Double = 1.0
      do {
         step /= 10
         val result = Intergate.trapeze(Functions::withExponent, -2.0, 2.0, step)
         val diff = abs(expectedValue-result)
         println("Różnica wartści dla wielkości kroku $step wynosi $diff")
      } while (diff >= epsilon)

      printThinSeparator()
      println("Metoda Simpsona:")
      printThinSeparator()

      println("Funkcja obliczana ze stałym krokiem dx = 0.1")
      printlnDouble(Intergate.simpson(Functions::withExponent, -2.0, 2.0, .1))
      println("Funkcja obliczana ze stałym krokiem dx = 0.01")
      printlnDouble(Intergate.simpson(Functions::withExponent, -2.0, 2.0, .01))
      println("Funkcja obliczana ze stałym krokiem dx = 0.001")
      printlnDouble(Intergate.simpson(Functions::withExponent, -2.0, 2.0, .001))
      printThinSeparator()

      println("Sprawdzanie dla jakiej wartości kroku błąd otrzymajnej wartości jest mniejszy od $epsilon")
      step = 1.0
      do {
         step /= 10
         val result = Intergate.simpson(Functions::withExponent, -2.0, 2.0, step)
         val diff = abs(expectedValue-result)
         println("Różnica wartści dla wielkości kroku $step wynosi $diff")
      } while (diff >= epsilon)
   }
}