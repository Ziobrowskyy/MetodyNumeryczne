package labs.lab2

import Matrix
import numericalMethods.Gauss
import Task
import utils.StringUtils.vectorToString

object Task1 : Task() {
	override val name: String = "Obliczanie wartosci kwadratury podanych funkcji za pomoca kwadratury Gaussa-Legendre'a"

	override fun runTask() {
		val aMatrix = Matrix(
			arrayOf(
				doubleArrayOf(0.00, -3.00, 4.00, 6.80, 9.00),
				doubleArrayOf(-3.00, 2.00, 4.60, 6.30, -10.0),
				doubleArrayOf(2.00, -1.00, 2.80, -8.40, -5.00),
				doubleArrayOf(-6.00, 2.00, 7.00, -0.50, -0.90),
				doubleArrayOf(5.00, -2.00, -0.50, 12.00, -4.00)
			)
		)
		val bVector = doubleArrayOf(66.64, -36.26, -4.32, 16.60, -12.90)
		println(vectorToString(Gauss.elimination(aMatrix, bVector)))
	}
}