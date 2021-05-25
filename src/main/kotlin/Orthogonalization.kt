import kotlin.math.pow

object Orthogonalization {
	
	fun getBaseXVectors(n: Int): Matrix {
		return Matrix(n, isTriangular = true) { i, j -> if (i == j) 1.0 else 0.0 }
	}

	
	fun grahmSchmidt(fMatrix: Matrix, xs: Double = -1.0, xe: Double = 1.0): Matrix {
		val gMatrix = Matrix(fMatrix.n, fMatrix.m)
		//fill g[0]
		gMatrix[0] = doubleArrayOf(1.0)
		
		for (i in 1 until fMatrix.n) {
			
			gMatrix[i] = fMatrix[i]
			
			for (j in 0 until i) {
				val upper = Integrate.simpson(xs, xe) { x ->
					Functions.horner(fMatrix[i], true)(x) * Functions.horner(gMatrix[j], true)(x)
				}
				val lower = Integrate.simpson(xs, xe) { x ->
					Functions.horner(gMatrix[j], true)(x).pow(2)
				}
				
				gMatrix[i] -= gMatrix[j] * (upper / lower)

			}

		}
		
		return gMatrix
	}
	
	fun triModule(fMatrix: Matrix, a: Double = -1.0, b: Double = 1.0): Matrix {
		assert(fMatrix.n >= 2)
		
		val pMatrix = Matrix(fMatrix.n, fMatrix.m)
		val xVector = doubleArrayOf(0.0, 1.0)
		val pIntegrationValues = mutableListOf<Double>()
		val pXIntegrationValues = mutableListOf<Double>()
		//helper lambdas
		
		val beta = { i: Int ->
			val betaUpper = pXIntegrationValues.getOrSet(i-1) {
				Integrate.simpson(a, b) { x ->
					x * Functions.horner(pMatrix[i-1], true)(x) * Functions.horner(pMatrix[i-1], true)(x)
				}
			}
			val betaLower = pIntegrationValues.getOrSet(i-1) {
				Integrate.simpson(a, b) { x ->
					Functions.horner(pMatrix[i-1], true)(x) * Functions.horner(pMatrix[i-1], true)(x)
				}
			}
			
			-betaUpper / betaLower
		}
		
		val gamma = { i: Int ->
			val gammaUpper = pIntegrationValues.getOrSet(i-1) {
				Integrate.simpson(a, b) { x ->
					Functions.horner(pMatrix[i-1], true)(x) * Functions.horner(pMatrix[i-1], true)(x)
				}
			}
			val gammaLower = pIntegrationValues.getOrSet(i-2) {
				Integrate.simpson(a, b) { x ->
					Functions.horner(pMatrix[i-2], true)(x) * Functions.horner(pMatrix[i-2], true)(x)
				}
			}
			-gammaUpper / gammaLower
		}
		
		//set p[0] and p[1]
		pMatrix[0] = doubleArrayOf(1.0)
		pMatrix[1] = (xVector + beta(1)) * pMatrix[0]
		
		for (i in 2 until pMatrix.n) {
			pMatrix[i] = (xVector + beta(i)) * pMatrix[i - 1] + pMatrix[i - 2] * gamma(i)
		}
		
		return pMatrix
	}
	
	fun orthogonalityCheck(fMatrix: Matrix, xs: Double = -1.0, xe: Double = 1.0): Boolean {
		for (i in 0 until fMatrix.n) {
			for (j in i + 1 until fMatrix.n) {
				val result = Integrate.simpson(xs, xe) { x ->
					Functions.horner(fMatrix[i], true)(x) * Functions.horner(fMatrix[j], true)(x)
				}
				if (!result.equals(0.0, 0.001))
					return false
			}
		}
		return true
	}
}