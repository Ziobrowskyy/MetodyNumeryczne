import kotlin.math.pow

object Orthogonalization {
    fun orthogonalizationDefault(inMatrix: Matrix) {
        val resultMatrix = Matrix(inMatrix.m, inMatrix.n)
        inMatrix.forEach { it.reverse() }
        for (i in 0 until inMatrix.n) {
            for (j in 0 until inMatrix.m) {
                resultMatrix[i, j] =
                    Integrate.simpson(0.0, 1.0, 0.01) { x -> x.pow(i) * x.pow(j) * x }
            }
        }
        resultMatrix.print()

    }

    fun grahmSchmidt(fMatrix: Matrix, xs: Double = -1.0, xe: Double = 1.0): Matrix {
        val gMatrix = Matrix(fMatrix.n, fMatrix.m)
        //fill g[0]
        gMatrix[0] = doubleArrayOf(1.0)

        for (i in 1 until fMatrix.n) {

            gMatrix[i] = fMatrix[i]

            for (j in 0 until i) {
                val upper = Integrate.simpson(xs, xe) { x ->
                    Functions.makeHorner(fMatrix[i], true)(x) * Functions.makeHorner(gMatrix[j], true)(x)
                }
                val lower = Integrate.simpson(xs, xe) { x ->
                    Functions.makeHorner(gMatrix[j], true)(x).pow(2)
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
        run {

            pMatrix[0] = doubleArrayOf(1.0)
            val betaUpper = Integrate.simpson(a, b) { x ->
                x * Functions.makeHorner(pMatrix[0], true)(x) * Functions.makeHorner(pMatrix[0], true)(x)
            }
            val betaLower = Integrate.simpson(a, b) { x ->
                Functions.makeHorner(pMatrix[0], true)(x) * Functions.makeHorner(pMatrix[0], true)(x)
            }

            val beta = -betaUpper / betaLower
            pMatrix[1] = (xVector + beta) * pMatrix[0]
        }

        for (i in 2 until pMatrix.n) {
            //Pk (x) = (αk x + βk )Pk−1(x) + γkPk−2(x) k = 1, 2, . . . , n
            //P−1(x) := 0, P0(x) := a0
            //βk = − (xPk−1, Pk−1)/(Pk−1, Pk−2)
            //oraz
            //γk = −(Pk−1, Pk−1)/(Pk−2, Pk−2)
            val betaUpper = Integrate.simpson(a, b) { x ->
                x * Functions.makeHorner(pMatrix[i - 1], true)(x) * Functions.makeHorner(pMatrix[i - 1], true)(x)
            }
            val betaLower = Integrate.simpson(a, b) { x ->
                Functions.makeHorner(pMatrix[i - 1], true)(x) * Functions.makeHorner(pMatrix[i - 2], true)(x)
            }
            val beta = -betaUpper / betaLower

            val gammaUpper = Integrate.simpson(a, b) { x ->
                x * Functions.makeHorner(pMatrix[i - 1], true)(x) * Functions.makeHorner(pMatrix[i - 1], true)(x)
            }
            val gammaLower = Integrate.simpson(a, b) { x ->
                x * Functions.makeHorner(pMatrix[i - 2], true)(x) * Functions.makeHorner(pMatrix[i - 2], true)(x)
            }
            val gamma = -gammaUpper / gammaLower

            pMatrix[i] = (xVector * beta) * pMatrix[i - 1] + pMatrix[i - 2] * gamma
        }
        return pMatrix
    }

    fun orthogonalizationCheck(fMatrix: Matrix, xs: Double = -1.0, xe: Double = 1.0): Boolean {
        for (i in 0 until fMatrix.n) {
            for (j in i + 1 until fMatrix.n) {
                val result = Integrate.simpson(xs, xe) { x ->
                    Functions.makeHorner(fMatrix[i], true)(x) * Functions.makeHorner(fMatrix[j], true)(x)
                }
                if (!result.equals(0.0, 0.00001))
                    return false
            }
        }
        return true
    }
}