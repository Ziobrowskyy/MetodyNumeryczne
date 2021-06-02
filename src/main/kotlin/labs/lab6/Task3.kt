package labs.lab6

import Functions
import numerical.Integrate
import Task
import utils.DoubleUtils.printlnDouble

object Task3 : Task(){
   override val name: String = "Zadanie 3. \nKwadratura dla funkcji wielomianowerj o współczynnikach podanych w pliku"
   override fun runTask() {
      val expectedValue: Double = 193.12

      println("Wartość całki obliczona za pomocą WolframAlpha: $expectedValue")
      printThinSeparator()

      println("Metoda trapezów:")
      printThinSeparator()

      println("Podane wartości węzłów wielomianu oraz wartości funkcji w nich")
      printlnDouble(Integrate.trapeze(Data.xs, Data.ys))

      println("Wielomian odliczany metodą nawiną i stałym krokiem dx = 0.1")
      printlnDouble(Integrate.trapeze(-2.0, 2.0, .1, Functions::poly))

      println("Wielomian obliczany metodą Hornera oraz stałym krokiem dx = 0.1")
      printlnDouble(Integrate.trapeze(-2.0, 2.0, .1, Functions.horner(Data.polyCoof)))

      println("Wielomian obliczany metodą Hornera oraz dla podanych węzłów nierównoodległych")
      printlnDouble(Integrate.trapeze(Data.xsNonEquidistant, Functions.horner(Data.polyCoof)))

      printThinSeparator()

      println("Metoda Simpsona:")
      printThinSeparator()

      println("Podane wartości węzłów wielomianu oraz wartości funkcji w nich")
      printlnDouble(Integrate.simpson(Data.xs, Data.ys))

      println("Wielomian odliczany metodą naiwną i stałym krokiem dx = 0.1")
      printlnDouble(Integrate.simpson(-2.0, 2.0, .1, Functions::poly))

      println("Wielomian obliczany metodą Hornera oraz stałym krokiem dx = 0.1")
      printlnDouble(Integrate.simpson(-2.0, 2.0, .1, Functions.horner(Data.polyCoof)))

      println("Wielomian obliczany metodą Hornera oraz dla podanych węzłów nierównoodległych")
      printlnDouble(Integrate.simpson(Data.xsNonEquidistant, Functions.horner(Data.polyCoof)))

   }
}