package streams;

import java.util.List;
import java.util.Optional;

public class FoldReduce {

    /**
     * Reduce
     */
    Integer totalInt(List<Integer> areas) {

        return areas.stream()
                .reduce(0, (int1, int2) -> int1 + int2);
    }

    class Wagon {
        private int firstClass;
        private int secondClass;

        Wagon(int firstClass, int secondClass) {
            this.firstClass = firstClass;
            this.secondClass = secondClass;
        }
    }

    /**
     * Reduce
     */
    Optional<Wagon> totalArea(List<Wagon> wagons) {

        return wagons.stream()
                .reduce((wagon1, wagon2) ->
                        new Wagon(
                                wagon1.firstClass + wagon2.firstClass,
                                wagon1.secondClass + wagon2.secondClass
                        )
                );
    }

    /**
     * Fold
     */
    double totalChairs(List<Wagon> wagons) {

        return wagons.stream()
                .reduce(
                        0,
                        (integer, wagon) -> integer += wagon.firstClass + wagon.secondClass, //accumulator
                        (integer, integer2) -> integer + integer2  //combiner
                );
    }
}
