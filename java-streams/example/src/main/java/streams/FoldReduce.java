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

    class Area {
        private int chairs;
        private int tables;

        Area(int chairs, int tables) {
            this.chairs = chairs;
            this.tables = tables;
        }
    }

    /**
     * Reduce
     */
    Optional<Area> totalArea(List<Area> areas) {

        return areas.stream()
                .reduce((area1, area2) ->
                        new Area(
                                area1.chairs + area2.chairs,
                                area1.tables + area2.tables
                        )
                );
    }

    /**
     * Fold
     */
    double totalChairs(List<Area> areas) {

        return areas.stream()
                .reduce(
                        0,
                        (integer, area) -> integer += area.chairs, //accumulator
                        (integer, integer2) -> integer + integer2  //combiner
                );
    }
}
