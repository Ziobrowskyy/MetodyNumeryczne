package lab9

import Task

object Task1 : Task() {
	override val name: String = "Obliczanie wartosci kwadratury podanych funkcji za pomoca kwadratury Gaussa-Legendre'a"
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
		val base = Orthogonalization.getBaseXVectors(4)
		println("Wektory bazy:")
		base.print()

		printThinSeparator()
		
		val orthogonalTC = Orthogonalization.triModule(base, -1.0, 1.0)

		println("Baza zortogonalizowana:")
		orthogonalTC.print()
		printThinSeparator()
		
		println("Na przedziale (-1, 1)")
		println(Orthogonalization.orthogonalityCheck(orthogonalTC, -1.0, 1.0))
		printThinSeparator()
	}
}