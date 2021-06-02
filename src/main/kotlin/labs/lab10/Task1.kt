package labs.lab10

import Task
import numerical.ZeroCrossing

object Task1 : Task() {
    override val name: String = "Wyznaczanie miejsc zerowych funckji oraz pochodnych"

    private fun testFun(range: ClosedRange<Double>, f: (Double) -> Double, df: ((Double) -> Double)? = null) {
        printThinSeparator()
        if (df != null) {
            println("Metoda Newtona z podana analitycznie pochodna:")
            println(ZeroCrossing.newton(range, f, df))
        }
        println("Metoda Newtona z pochodna wyznaczona numerycznie:")
        println(ZeroCrossing.newton(range, f))

        println("Metoda bisekcji:")
        println(ZeroCrossing.bisection(range, f))

        println("Metoda siecznych:")
        println(ZeroCrossing.secant(range, f))

        println("Metoda regula falsi:")
        println(ZeroCrossing.falsePosition(range, f))

        printThinSeparator()
    }

    override fun runTask() {
        println("Miejsca zerowe dla funkcji y = x^3 + x^2 -3x -3")
        testFun((0.0..5.0), Data::function1st, Data::function1stDeriv)
        printThickSeparator()

        println("Miejsca zerowe dla funkcji y = x^2 - 2")
        testFun((0.0..5.0), Data::function2nd, Data::function2ndDeriv)
        printThickSeparator()

        println("Miejsca zerowe dla funkcji y = sin(x^2) - x^2")
        testFun((-0.01..0.001), Data::function3rd, Data::function3rdDeriv)
        printThickSeparator()

        println("Miejsca zerowe dla funkcji y = sin(x^2) - x^2 + 1/2")
        testFun((0.0..5.0), Data::function4th,Data::function4thDeriv)
        printThickSeparator()
    }
}