package labs.lab10

import Task
import numericalMethods.ZeroCrossing

object Task1 : Task() {
    override val name: String = "Wyznaczanie miejsc zerowych funckji oraz pochodnych"

    private fun testFun(range: ClosedRange<Double>, f: (Double) -> Double, df: ((Double) -> Double)? = null) {
        printThinSeparator()

        if (df != null) {
            println("Metodą Newtona z podaną analitycznie pochodną:")
            println(ZeroCrossing.newton(f, df, range))
        }
        println("Metodą Newtona z pochodną wyznaczoną numerycznie:")
        println(ZeroCrossing.newton(f, range))

        println("Metodą bisekcji:")
        println(ZeroCrossing.bisection(f, range))

        println("Metodą siecznych:")
        println(ZeroCrossing.secant(f, range))

        println("Metodą regula falsi:")
        println(ZeroCrossing.falsePosition(f, range))

        printThinSeparator()
    }

    override fun runTask() {
        println("Miejsca zerowe dla funkcji y = x^3 + x^2 -3x -3")
        testFun((0.0..5.0), Data::function1st, Data::function1stDeriv)
        printThickSeparator()

        println("Miejsca zerowe dla funkcji y = x^2 - 2")
        testFun((0.0..5.0), Data::function2nd)
        printThickSeparator()

        println("Miejsca zerowe dla funkcji y = sin(x^2) - x^2")
        testFun((-0.01..0.001), Data::function3rd, Data::function3rdDeriv)
        printThickSeparator()

        println("Miejsca zerowe dla funkcji y = sin(x^2) - x^2 + 1/2")
        testFun((0.0..5.0), Data::function4th,Data::function4thDeriv)
        printThickSeparator()
        println(ZeroCrossing.secant(Data::g, (10.0..30.0)))
    }
}