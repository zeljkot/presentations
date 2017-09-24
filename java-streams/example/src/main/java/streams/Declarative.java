package streams;

import java.util.List;
import java.util.Optional;

public class Declarative {

    class Area {
        private int chairs;
        private int tables;

        Area(int chairs, int tables) {
            this.chairs = chairs;
            this.tables = tables;
        }
    }

    Integer totalInt(List<Integer> areas) {

        return areas.stream()
                .reduce(0, (int1, int2) -> int1 + int2);
    }

    // reduce
    Optional<Area> totalArea2(List<Area> areas) {

        return areas.stream()
                .reduce((area1, area2) ->
                        new Area(
                                area1.chairs + area2.chairs,
                                area1.tables + area2.tables
                        )
                );
    }

    // fold
    double chairsPerTable(List<Area> areas) {

        return areas.stream()
                .reduce(
                        0,
                        (integer, area) -> integer += area.chairs,
                        (integer, integer2) -> integer + integer2
                );
    }
}
