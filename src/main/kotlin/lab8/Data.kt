package lab8

import Matrix

object Data {
	fun getBaseXVectors(n: Int):Matrix {
		return Matrix(n, isTriangular = true) { i, j -> if(i == j) 1.0 else 0.0 }
	}
}