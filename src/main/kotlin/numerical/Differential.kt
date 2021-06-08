package numerical

object Differential {
    fun euler(range: ClosedRange<Double>, dx: Double, y0: Double, f: (Double) -> Double): List<Pair<Double, Double>> {
        val ys = mutableListOf<Pair<Double, Double>>()
        var x = range.start
        var y = y0
        while (x <= range.endInclusive) {
            ys.add(Pair(x,y))
            y += dx * f(y)

            x += dx
        }
        return ys
    }
    fun heun(range: ClosedRange<Double>, dx: Double, y0: Double, f: (Double) -> Double):List<Pair<Double,Double>> {
        val ys = mutableListOf<Pair<Double,Double>>()
        var x = range.start
        var y = y0
        while (x <= range.endInclusive) {
            ys.add(Pair(x,y))
            //yi+1 = yi +1/2 * h(f (xi, yi) + f (xi + h, yi + hf (xi, yi)))
            y += dx * 0.5 * f(y) + f(y + dx * f(y))
            x += dx
        }

        return ys
    }
    fun eulerModified(range: ClosedRange<Double>, dx: Double, y0: Double, f: (Double) -> Double):List<Pair<Double,Double>> {
        val ys = mutableListOf<Pair<Double,Double>>()
        var x = range.start
        var y = y0
        while (x <= range.endInclusive) {
            ys.add(Pair(x,y))
            //yi+1 = yi +1/2 * h(f (xi, yi) + f (xi + h, yi + hf (xi, yi)))
            y += dx * f(y + 0.5 * dx * f(y))
            x += dx
        }

        return ys
    }
    fun runngegKutty(range: ClosedRange<Double>, dx: Double, y0: Double, f: (Double) -> Double):List<Pair<Double,Double>> {
        val ys = mutableListOf<Pair<Double,Double>>()
        var x = range.start
        var y = y0

        return ys
    }
}

