package labs.lab11

import Task
import numerical.Differential
import numerical.ZeroCrossing

object Task1 : Task() {
    override val name: String = "Wyznaczanie miejsc zerowych funckji oraz pochodnych"

    override fun runTask() {
//        Differential.euler((0.0..300.0), 1.0, 1200.0, Data::dT_dt)
//            .forEach { println(it.second) }
//        Differential.heun((0.0..300.0), 1.0, 1200.0, Data::dT_dt)
//            .forEach { println(it.second) }
//        Differential.eulerModified((0.0..300.0), 1.0, 1200.0, Data::dT_dt)
//            .forEach { println(it.second) }
        Differential.runngegKutty(0.0..300.0), 1.0, 1200.0, Data::dT_dt)
            .forEach { println(it.second) }
    }
}