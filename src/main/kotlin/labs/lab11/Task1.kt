package labs.lab11

import Task
import numerical.Differential
import numerical.ZeroCrossing

object Task1 : Task() {
    override val name: String = "Rowzwiązywanie równań różniczkowych - zmiana temperatury punktu w czasie"

    override fun runTask() {
        val range = (0.0..300.0)
        val h = 1.0
        val y0 = 1200.0

        Differential.euler(range, h, y0, Data::dT_dt)
            .forEach { println(it.second) }

        Differential.heun(range, h, y0, Data::dT_dt)
            .forEach { println(it.second) }

        Differential.eulerModified(range, h, y0, Data::dT_dt)
            .forEach { println(it.second) }

        Differential.runngegKutty(range, h, y0, Data::dT_dt)
            .forEach { println(it.second) }
    }
}