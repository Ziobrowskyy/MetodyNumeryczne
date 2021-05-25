object Approximation {
    fun middleSquares(base: Matrix, a: Double, b: Double, function: (Double) -> Double): Vector {
        //pre-calculate functions of base using horner method
        val baseFunctions = List(base.n) { i ->
            Functions.horner(base[i], true)
        }
        //fill a matrix
        val aMatrix = Matrix(n = base.n) { i, j ->
            Integrate.simpson(a, b, 0.01) { x ->
                baseFunctions[i](x) * baseFunctions[j](x)
            }
        }
        //fill b vector
        val bVector = Vector(base.n) { i ->
            Integrate.simpson(a, b, 0.01) { x ->
                baseFunctions[i](x) * function(x)
            }
        }

        //solve using gaussian elimination method and return
        return Gauss.elimination(aMatrix, bVector)
    }
    /*
    fun middleSquares(baseMatrix: Matrix, a: Double, b: Double) {
//		val aValues = doubleArrayOf()
//		val bVector = Vector(baseMatrix.m)
//		val fPIntegrationValues = mutableListOf<Double>()
//		val pIntegrationValues = mutableListOf<Double>()
//
//		//lambda helpers
//
//		val getFPIntegration = { i: Int ->
//		}
//
//		val getPIntegration = {i: Int ->
//		}
//
//		val alpha = {i: Int ->
//		}
//		baseMatrix.forEach { it.reverse() }
//		for (i in 0 until baseMatrix.n) {
//			for (j in 0 until baseMatrix.m) {
//				aMatrix[i, j] =
//					Integrate.simpson(0.0, 1.0, 0.01) { x ->
//						baseMatrix[i, j]
//					}
//			}
//		}
//		aMatrix.print()

	}
     */
}