package dev.punchcafe.sci.field;

import dev.punchcafe.sci.field.fn.CoordinateToVectorTransformer2D;
import dev.punchcafe.sci.field.fn.VectorTransformer2D;
import dev.punchcafe.sci.vector.Vector2;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VectorField2D implements Field2D<Vector2> {
    //TODO: replace with array?

    final Vector2[][] internalArray;

    public static VectorField2D buildField(final CoordinateToVectorTransformer2D transformer,
                                           final int width,
                                           final int height) {
        final var internalArray = new Vector2[width][height];
        IntStream.range(0, height)
                .parallel()
                .forEach(row -> Arrays.fill(internalArray[row], new Vector2(0,0)));
        return new VectorField2D(internalArray)
                .transform(transformer);
    }

    public VectorField2D transform(final CoordinateToVectorTransformer2D transformer) {
        final int height = internalArray.length;
        final int length = internalArray[0].length;
        final var list2D = IntStream.range(0, height)
                .parallel()
                .mapToObj(row ->
                        IntStream.range(0, length)
                                .parallel()
                                .mapToObj(column -> transformer.transform(row, column))
                                .collect(toList()))
                .collect(toList());
        return buildFieldFromList2d(list2D);
    }

    public VectorField2D transform(final VectorTransformer2D transformer){
        final int height = internalArray.length;
        final int length = internalArray[0].length;
        final var list2D = IntStream.range(0, height)
                .parallel()
                .mapToObj(row ->
                        IntStream.range(0, length)
                                .parallel()
                                .mapToObj(column -> transformer.transform(this.internalArray[row][column]))
                                .collect(toList()))
                .collect(toList());
        return buildFieldFromList2d(list2D);
    }

    private VectorField2D buildFieldFromList2d(List<List<Vector2>> list2D){
        final var newArray = new Vector2[height()][length()];
        for(int j = 0; j < height(); j++){
            newArray[j] = list2D.get(j).toArray(newArray[j]);
        }
        return new VectorField2D(newArray);
    }

    private int height(){
        return internalArray.length;
    }

    private int length(){
        return internalArray[0].length;
    }

    @Override
    public Vector2 get(int x, int y) {
        return internalArray[y][x];
    }

    @Override
    public String toString(){
        final int height = internalArray.length;
        final int length = internalArray[0].length;
        final StringBuilder sb = new StringBuilder();
        for(int j = 0; j < height; j++){
            for(int i = 0; i < length; i++){
                sb.append(String.format("{x : %f, y : %f} ", internalArray[j][i].getX(), internalArray[j][i].getY()));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
