package streams

class FoldReduce {

    /**
     * Reduce
     */
    internal fun totalInt(areas: List<Int>): Int? =
            areas.reduce { int1, int2 -> int1!! + int2!! }

    internal inner class Wagon(val firstClass: Int, val secondClass: Int)

    /**
     * Reduce
     */
    internal fun totalArea(wagons: List<Wagon>) =
            wagons.reduce { wagon1, wagon2 ->
                Wagon(
                        wagon1.firstClass + wagon2.firstClass,
                        wagon1.secondClass + wagon2.secondClass
                )
            }

    /**
     * Fold
     */
    internal fun totalChairs(wagons: List<Wagon>) =
            wagons.fold(
                    0,
                    { integer, wagon -> integer + wagon.firstClass + wagon.secondClass } //accumulator
            )
}
