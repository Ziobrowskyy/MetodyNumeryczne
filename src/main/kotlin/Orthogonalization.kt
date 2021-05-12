import kotlin.math.pow

object Orthogonalization {
    fun orthogonalizationDefault(fMatrix: Matrix, f: (x: Double) -> Double) {
        val aMatrix = Matrix(fMatrix.m, fMatrix.n)
        val bVector = Vector(fMatrix.m)

        fMatrix.forEach { it.reverse() }
        for (i in 0 until fMatrix.n) {
            for (j in 0 until fMatrix.m) {
                aMatrix[i, j] =
                    Integrate.simpson(0.0, 1.0, 0.01) { x ->
                        fMatrix[i, j]
                    }
            }
        }
        aMatrix.print()

    }

    fun grahmSchmidt(xs: Double = -1.0, xe: Double = 1.0, f: (x: Double) -> Double) {
//       val gVector = Vector()
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

//                for (k in gMatrix[i].indices) {
//                    gMatrix[i, k] -= gMatrix[j, k] * upper / lower;
//                }
            }

//            gMatrix[i] = gCoof
        }

        return gMatrix
    }

    fun triModule(fMatrix: Matrix, a: Double = 0.0, b: Double = 1.0): Matrix {
        assert(fMatrix.n >= 2)

        val pMatrix = Matrix(fMatrix.n, fMatrix.m)
        val xVector = doubleArrayOf(0.0, 1.0)

        //set p[0] and p[1]
        val beta = { i: Int ->
            val betaUpper = Integrate.simpson(a, b) { x ->
                x * Functions.horner(pMatrix[i - 1], true)(x) * Functions.horner(pMatrix[i - 1], true)(x)
            }
            val betaLower = Integrate.simpson(a, b) { x ->
                Functions.horner(pMatrix[i - 1], true)(x) * Functions.horner(pMatrix[i - 1], true)(x)
            }
            -betaUpper / betaLower
        }

        val gamma = { i: Int ->
            val gammaUpper = Integrate.simpson(a, b) { x ->
                Functions.horner(pMatrix[i - 1], true)(x) * Functions.horner(pMatrix[i - 1], true)(x)
            }
            val gammaLower = Integrate.simpson(a, b) { x ->
                Functions.horner(pMatrix[i - 2], true)(x) * Functions.horner(pMatrix[i - 2], true)(x)
            }
            -gammaUpper / gammaLower
        }

        pMatrix[0] = doubleArrayOf(1.0)
        pMatrix[1] = (xVector + beta(1)) * pMatrix[0]

        for (i in 2 until pMatrix.n) {
            pMatrix[i] = (xVector * beta(i)) * pMatrix[i - 1] + pMatrix[i - 2] * gamma(i)
        }

        return pMatrix
    }

    fun orthogonalizationCheck(fMatrix: Matrix, xs: Double = -1.0, xe: Double = 1.0): Boolean {
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