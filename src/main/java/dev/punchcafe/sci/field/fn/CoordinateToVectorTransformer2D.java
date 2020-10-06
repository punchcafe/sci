package dev.punchcafe.sci.field.fn;

import dev.punchcafe.sci.vector.Vector2;

@FunctionalInterface
public interface CoordinateToVectorTransformer2D {
    Vector2 transform(double x, double y);
}
