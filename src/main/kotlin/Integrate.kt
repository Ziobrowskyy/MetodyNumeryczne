object Integrate {
   private fun legendre(xs: Double, xe: Double, xis: DoubleArray, Ais: DoubleArray, f: (x: Double) -> Double): Double {
      assert(xis.size == Ais.size)
      val dx: Double = xe - xs
      val tis = xis.map { x -> dx / 2 * x + (xs + xe) / 2 }.toDoubleArray()
      var sum: Double = 0.0
      for (i in tis.indices) {
         sum += Ais[i] * f(tis[i])
      }
      return sum * dx / 2
   }
   fun legendre2(xs: Double, xe: Double, f: (x: Double) -> Double): Double {
      val xis: DoubleArray = doubleArrayOf(-0.57735, .57735)
      val Ais: DoubleArray = doubleArrayOf(1.0, 1.0)
      return legendre(xs, xe, xis, Ais, f)
   }

   fun legendre3(xs: Double, xe: Double, f: (x: Double) -> Double): Double {
      val xis: DoubleArray = doubleArrayOf(-0.774597, .0, .774597)
      val Ais: DoubleArray = doubleArrayOf(5.0 / 9.0, 8.0 / 9.0, 5.0 / 9.0)
      return legendre(xs, xe, xis, Ais, f)
   }

   fun legendre4(xs: Double, xe: Double, f: (x: Double) -> Double): Double {
      val xis: DoubleArray = doubleArrayOf(-0.861136, -0.339981, 0.339981, 0.861136)
      val Ais: DoubleArray = doubleArrayOf(0.347855, 0.652145, 0.652145, 0.347855)
      return legendre(xs, xe, xis, Ais, f)
   }

   fun legendre5(xs: Double, xe: Double, f: (x: Double) -> Double): Double {
      val xis: DoubleArray = doubleArrayOf(-0.906180, -0.538469, .0, 0.538469, 0.906180)
      val Ais: DoubleArray = doubleArrayOf(0.236927, 0.478629, 0.568889, 0.478629, 0.236927)
      return legendre(xs, xe, xis, Ais, f)
   }

   fun trapeze(xs: Double, xe: Double, dx: Double, f: (x: Double) -> Double): Double {
      var sum: Double = 0.0
      var x: Double = xs
      while (x < xe) {
         sum += f(x) + f(x + dx)
         x += dx
      }
      return dx * 0.5 * sum
   }

   fun trapeze(xs: DoubleArray, ys: DoubleArray): Double {
      assert(xs.size == ys.size)
      var sum: Double = 0.0
      for (i in 0 until xs.size - 1) {
         val dx = xs[i + 1] - xs[i]
         sum += 0.5 * dx * (ys[i] + ys[i + 1])
      }
      return sum
   }

   fun trapeze(xs: DoubleArray, f: (x: Double) -> Double): Double {
      var sum: Double = 0.0
      for (i in 0 until xs.size - 1) {
         val dx = xs[i + 1] - xs[i]
         // 0.5 * h * (a + b)
         sum += 0.5 * dx * (f(xs[i]) + f(xs[i + 1]))
      }
      return sum
   }

   fun simpson(xs: Double, xe: Double, dx: Double = 0.01, f: (x: Double) -> Double): Double {
      var sum: Double = 0.0
      var x: Double = xs
      while (x < xe) {
         sum += (f(x) + 4.0 * f(x + dx * 0.5) + f(x + dx))
         x += dx
      }
      return dx / 6 * sum
   }

   fun simpson(xs: DoubleArray, ys: DoubleArray): Double {
      assert(xs.size == ys.size)
      var sum: Double = 0.0
      for (i in 0 until xs.size - 1) {
         val dx = xs[i + 1] - xs[i]
         sum += dx / 6 * (ys[i] + 4.0 * 0.5 * (ys[i] + ys[i + 1]) + ys[i + 1])
      }
      return sum
   }

   fun simpson(xs: DoubleArray, f: (x: Double) -> Double): Double {
      var sum: Double = 0.0
      for (i in 0 until xs.size - 1) {
         val dx = xs[i + 1] - xs[i]
         sum += dx / 6 * (f(xs[i]) + 4.0 * (f(xs[i] + dx * 0.5)) + f(xs[i + 1]))
      }
      return sum
   }
}