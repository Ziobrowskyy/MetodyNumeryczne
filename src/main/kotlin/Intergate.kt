object Intergate {
   fun trapeze(f: (Double) -> Double, xs: Double, xe: Double, dx: Double): Double {
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

   fun trapeze(f: (Double) -> Double, xs: DoubleArray): Double {
      var sum: Double = 0.0
      for (i in 0 until xs.size - 1) {
         val dx = xs[i + 1] - xs[i]
         sum += 0.5 * dx * (f(xs[i]) + f(xs[i + 1]))
      }
      return sum
   }

   fun NewtonCotes(f: (Double) -> Double, xs: Double, xe: Double, dx: Double): Double {
      var sum: Double = 0.0
      var x: Double = xs
      while (x < xe) {
         sum += (f(x) + 4.0 * f(x + dx * 0.5) + f(x + dx))
         x += dx
      }
      return dx / 6 * sum
   }

   fun NewtonCotes(xs: DoubleArray, ys: DoubleArray): Double {
      assert(xs.size == ys.size)
      var sum: Double = 0.0
      for (i in 0 until xs.size - 1) {
         val dx = xs[i + 1] - xs[i]
         sum += dx / 6 * (ys[i] + 4.0 * 0.5 * (ys[i] + ys[i + 1]) + ys[i + 1])
      }
      return sum
   }
   fun NewtonCotes(f: (Double) -> Double, xs: DoubleArray): Double {
      var sum: Double = 0.0
      for (i in 0 until xs.size - 1) {
         val dx = xs[i + 1] - xs[i]
         sum += dx / 6 * (f(xs[i]) + 4.0 * (f(xs[i] + dx * 0.5 )) + f(xs[i + 1]))
      }
      return sum
   }
}