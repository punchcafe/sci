package dev.punchcafe.sci.field.fn;

import dev.punchcafe.sci.vector.Vector2;

@FunctionalInterface
public interface CoordinateWithTimeToVectorTransformer2D {
    Vector2 transform(double t, double x, double y);
}
