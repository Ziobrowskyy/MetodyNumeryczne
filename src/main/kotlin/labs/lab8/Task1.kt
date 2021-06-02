package labs.lab8

import numerical.Orthogonalization
import Task

object Task1 : Task() {
	override val name: String = "Ortogonalizacja baz z wykorzystaniem metody Grahma-Schmitda i metody trójczłonowej"
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
		val base = Orthogonalization.getBaseXVectors(3)
		println("Wektory bazy:")
		base.print()

		printThinSeparator()

		val orthogonalGS = Orthogonalization.grahmSchmidt(base)
		val orthogonalTC = Orthogonalization.triModule(orthogonalGS)

		println("Baza zortogonalizowana:")
		printThinSeparator()

		println("Dla algorytmu Grahma-Schmita:")
		orthogonalGS.print()
		printThinSeparator()

		println("Dla resuly trojczlonowej:")
		orthogonalTC.print()

		printThickSeparator()

		println("Sprawdzanie ortogonalizacji")
		printThinSeparator()

		println("Dla algorytmu Grahama-Schmita:")
		printThinSeparator()

		println("Na przedziale (-1, 1)")
		println(Orthogonalization.orthogonalityCheck(orthogonalGS, -1.0, 1.0))
		printThinSeparator()

		println("Na przedziale (0, 1)")
		val orthogonal2 = Orthogonalization.grahmSchmidt(base, 0.0, 1.0)
		println(Orthogonalization.orthogonalityCheck(orthogonal2, 0.0, 1.0))
		printThinSeparator()

		println("Dla algorytmu trojczlonowego:")
		printThinSeparator()

		println("Na przedziale (-1, 1)")
		val orthogonalTC2 = Orthogonalization.triModule(base,-1.0,1.0)
		println(Orthogonalization.orthogonalityCheck(orthogonalTC2, -1.0, 1.0))
		printThinSeparator()

		println("Na przedziale (0, 1)")
		println(Orthogonalization.orthogonalityCheck(orthogonalTC, 0.0, 1.0))
		printThinSeparator()
	}
}