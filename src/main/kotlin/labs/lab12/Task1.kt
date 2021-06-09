package labs.lab12

import Task
import numerical.Integrate
import utils.CollectionUtils.length

object Task1 : Task() {
    override val name: String = "Rowzwiązywanie całek numerycznych"
    private fun testFunction(range: ClosedRange<Double>, f: (Double) -> Double) {
        printThinSeparator()
        println("Metodą Monte Carlo generatorem losowym biblioteki standardowej")
        printThinSeparator()
        println("dla 10 iteracji: " + Integrate.monteCarlo(range, range.length / 10, f))
        println("dla 100 iteracji: " + Integrate.monteCarlo(range, range.length / 100, f))
        println("dla 1_000 iteracji: " + Integrate.monteCarlo(range, range.length / 1_000, f))
        println("dla 1_000_000 iteracji: " + Integrate.monteCarlo(range, range.length / 1_000_000, f))
        printThinSeparator()

        println("Metodą Monte Carlo generatorem losowym SecureRandom")
        printThinSeparator()
        println("dla 10 iteracji: " + Integrate.monteCarloSecureRandom(range, range.length / 10, f))
        println("dla 100 iteracji: " + Integrate.monteCarloSecureRandom(range, range.length / 100, f))
        println("dla 1_000 iteracji: " + Integrate.monteCarloSecureRandom(range, range.length / 1_000, f))
        println("dla 1_000_000 iteracji: " + Integrate.monteCarloSecureRandom(range, range.length / 1_000_000, f))
        printThinSeparator()

        println("Metodą Simpsona")
        printThinSeparator()
        println("dla 10 iteracji: " + Integrate.simpson(range.start, range.endInclusive, range.length / 10, f))
        println("dla 100 iteracji: " + Integrate.simpson(range.start, range.endInclusive, range.length / 100, f))
        println("dla 1000 iteracji: " + Integrate.simpson(range.start, range.endInclusive, range.length / 1_000, f))
        println(
            "dla 1_000_000 iteracji: " + Integrate.simpson(
                range.start,
                range.endInclusive,
                range.length / 1_000_000,
                f
            )
        )
        printThinSeparator()

        println("Metodą Trapezów")
        printThinSeparator()
        println("dla 10 iteracji: " + Integrate.trapeze(range.start, range.endInclusive, range.length / 10, f))
        println("dla 100 iteracji: " + Integrate.trapeze(range.start, range.endInclusive, range.length / 100, f))
        println("dla 1000 iteracji: " + Integrate.trapeze(range.start, range.endInclusive, range.length / 1_000, f))
        println(
            "dla 1_000_000 iteracji: " + Integrate.trapeze(
                range.start,
                range.endInclusive,
                range.length / 1_000_000,
                f
            )
        )
        printThickSeparator()
    }

    fun averageForMonteCarlo(iterations: Int = 100, range: ClosedRange<Double>, f: (Double) -> Double) {
        printThickSeparator()
        run {
            var sum = 0.0
            for (i in 0 until iterations)
                sum += Integrate.monteCarlo(range, range.length / 1000, f)
            println("Metoda Monte Carlo standardowym generatorem liczb losowych")
            println(sum / iterations)
        }
        printThinSeparator()
        run {
            var sum = 0.0
            for (i in 0 until iterations)
                sum += Integrate.monteCarloSecureRandom(range, range.length / 1000, f)
            println("Metoda Monte Carlo generatorem liczb losowych SecureRandom")
            println(sum / iterations)
        }
    }

    override fun runTask() {
        val range1 = (0.0..4.5)
        val range2 = (-2.0..2.0)

//        averageForMonteCarlo(10, range1, Data::powSin)
//        averageForMonteCarlo(100, range2, Data::powExp)
//        return
        println("Obliczanie wartości funkcji x^2 * sin^3(x) na przedziale (0..4.5)")
        testFunction(range1, Data::powSin)
        return
        println("Obliczanie wartości funkcji x^2 * exp(x^2) * (x-1) na przediale (-2..2)")
        testFunction(range2, Data::powExp)

    }
}