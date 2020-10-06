package dev.punchcafe.sci.field;

import dev.punchcafe.sci.vector.Vector2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalUtils {
    public static List<Vector2> createRow(final int rowIndex, final int rowWidth){
        return IntStream.range(0, rowWidth)
                .parallel()
                .mapToObj(columnIndex -> new Vector2(rowIndex, columnIndex))
                .collect(Collectors.toList());
    }
}
