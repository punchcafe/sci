package dev.punchcafe.sci.field;

import dev.punchcafe.sci.field.fn.CoordinateToVectorTransformer2D;
import dev.punchcafe.sci.field.fn.VectorTransformer2D;
import dev.punchcafe.sci.vector.Vector2;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class FunctionalVectorField2D implements Field2D<Vector2> {

    private List<VectorTransformer2D> transformers = new ArrayList<>();

    public Vector2 get(final int x, final int y){
        if(transformers.isEmpty()){
            return new Vector2(0,0);
        } else {
            var mappedIterator = new Vector2(x, y);
            for(VectorTransformer2D transformer : transformers){
                mappedIterator = transformer.transform(mappedIterator);
            }
            return mappedIterator;
        }
    }

    public FunctionalVectorField2D transformBy(VectorTransformer2D transformer2D){
        transformers.add(transformer2D);
        return this;
    }

}
