package dev.punchcafe.sci.field.fn;

import dev.punchcafe.sci.vector.Vector2;

@FunctionalInterface
public interface CoordinateToScalarTransformer2D {
    Number transform(double x, double y);
}
