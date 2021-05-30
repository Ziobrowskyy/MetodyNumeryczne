package labs.lab9

import Functions
import numericalMethods.Approximation
import numericalMethods.Orthogonalization
import Task
import utils.StringUtils.vectorToFunctionString
import utils.StringUtils.vectorToString

object Task1 : Task() {
	override val name: String = "Aproksymacja funkcji z wykorzystaniem bazy standardowej oraz baz zortogonalizowanych"
	/*
	1 Zaimplementuj algorytm ortogonalizacji Grama-Schmidta dla bazy
	standardowej 1, x, x2, . . . w przestrzeni L2p[a, b], gdzie p(x) = 1
	
	2 Zaimplementuj regułę trójczłonową pozwalającą na generowanie
	bazy ortogonalnej w przestrzeni L2p[a, b], gdzie p(x) = 1
	
	3 Sprawdź ortogonalność wyliczonych baz na podstawie obydwu
	algorytmów dla przedziałów [−1, 1] oraz [0, 1]:
	Podaj wartości iloczynów skalarnych elementów bazy
	Narysuj wykresy otrzymanych elementów bazowych
	 */
	override fun runTask() {
		val base = Orthogonalization.getBaseXVectors(5)
		println("Wektory bazy:")
		base.print()
		printThinSeparator()

		println("Bazy zortogonalizowane")
		printThinSeparator()

		println("metodą Grahma-Schmidta:")
		val orthogonalGS = Orthogonalization.grahmSchmidt(base, -1.0, 1.0)
		orthogonalGS.print()
		printThinSeparator()

		println("metodą trójczłonową:")
		val orthogonalTC = Orthogonalization.triModule(base, -1.0, 1.0)
		orthogonalTC.print()

		printThinSeparator()

		printThickSeparator()

		println("Aproksymacja funkcji")
		printThinSeparator()

		println("Z wykorzystaniem bazy standardowej:")
		val baseSolution = Approximation.middleSquares(base, -1.0, 1.0, Functions::sinEPoly)
		println(vectorToString(baseSolution))
		println(vectorToFunctionString(baseSolution, base))

		printThinSeparator()

		println("Z wykorzystaniem bazy zortogonalizowanej metodą Grahma-Schmitda:")
		val gsSolution = Approximation.middleSquares(orthogonalGS, -1.0, 1.0, Functions::sinEPoly)
		println(vectorToString(gsSolution))
		println(vectorToFunctionString(gsSolution, orthogonalGS))

		printThinSeparator()

		println("Z wykorzystaniem bazy zortogonalizowanej metodą trójczłonową:")
		val tcSolution = Approximation.middleSquares(orthogonalTC, -1.0, 1.0, Functions::sinEPoly)
		println(vectorToString(tcSolution))
		println(vectorToFunctionString(tcSolution, orthogonalTC))

		printThinSeparator()
	}
}