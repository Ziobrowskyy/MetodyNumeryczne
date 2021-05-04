package lab6

import Functions
import Task
import printlnDouble

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
      printlnDouble(Integrate.trapeze(Functions::poly, -2.0, 2.0, .1))

      println("Wielomian obliczany metodą Hornera oraz stałym krokiem dx = 0.1")
      printlnDouble(Integrate.trapeze(Functions.makeHorner(Data.polyCoof), -2.0, 2.0, .1))

      println("Wielomian obliczany metodą Hornera oraz dla podanych węzłów nierównoodległych")
      printlnDouble(Integrate.trapeze(Functions.makeHorner(Data.polyCoof), Data.xsNonEquidistant))

      printThinSeparator()

      println("Metoda Simpsona:")
      printThinSeparator()

      println("Podane wartości węzłów wielomianu oraz wartości funkcji w nich")
      printlnDouble(Integrate.simpson(Data.xs, Data.ys))

      println("Wielomian odliczany metodą naiwną i stałym krokiem dx = 0.1")
      printlnDouble(Integrate.simpson(Functions::poly, -2.0, 2.0, .1))

      println("Wielomian obliczany metodą Hornera oraz stałym krokiem dx = 0.1")
      printlnDouble(Integrate.simpson(Functions.makeHorner(Data.polyCoof), -2.0, 2.0, .1))

      println("Wielomian obliczany metodą Hornera oraz dla podanych węzłów nierównoodległych")
      printlnDouble(Integrate.simpson(Functions.makeHorner(Data.polyCoof), Data.xsNonEquidistant))

   }
}