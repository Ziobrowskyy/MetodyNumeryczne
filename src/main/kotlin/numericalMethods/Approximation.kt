package numericalMethods

import Functions
import Matrix
import utils.Vector

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
//        println("A:")
//        aMatrix.print()
//        println("B:")
//        println(vectorToString(bVector))
        //solve using gaussian elimination method and return
        return Gauss.elimination(aMatrix, bVector)
    }

}