package numerical

import Matrix
import utils.Vector
import kotlin.math.abs

object Gauss {
    fun elimination(aMatrix: Matrix, bVector: Vector): Vector {
        assert(aMatrix.n == bVector.size)
        val aCopy = aMatrix.copy()

        //create mapping
        val mapping = IntArray(aMatrix.m) { i -> i }

        fun updateMapping(i: Int) {
            var max = 0.0
            var maxIndex = -1
            for (j in 0 until aMatrix.m) {
                val x = abs(aCopy[i][mapping[j]])
                if (x > max) {
                    max = x
                    maxIndex = j
                }
            }
            if (maxIndex != -1) {
                val old = mapping[i]
                mapping[i] = mapping[maxIndex]
                mapping[maxIndex] = old
            }
        }

        //elimination
        for (i in 0 until aMatrix.n - 1) {
            // i - row added to current row
            // k - current row
            // j - index of current row

            //find max value of row and update mapping
            updateMapping(i)

            for (k in i + 1 until aMatrix.n) {
                val ratio = aCopy[k, mapping[i]] / aCopy[i, mapping[i]]

                for (j in 0 until aMatrix.m) {
                    aCopy[k, mapping[j]] -= ratio * aCopy[i, mapping[j]]
                }
                bVector[k] -= ratio * bVector[i]
            }
        }
        return solve(aCopy, bVector, mapping)
    }

    private fun solve(aMatrix: Matrix, bVector: Vector, mapping: IntArray): Vector {
        val solution = Vector(aMatrix.n) { 0.0 }
        for (i in aMatrix.n - 1 downTo 0) {
            //set initial value that matches B cell in AuB
            var tmp = bVector[i]
            for (j in aMatrix.m - 1 downTo i) {
                tmp -= aMatrix[i][mapping[j]] * solution[mapping[j]]
            }
            tmp /= aMatrix[i][mapping[i]]
            solution[mapping[i]] = tmp
        }
        return solution
    }
}