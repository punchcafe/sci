package dev.punchcafe.sci.field.fn;

import dev.punchcafe.sci.vector.Vector2;

@FunctionalInterface
public interface VectorTransformer2D {
    Vector2 transform(Vector2 vector);
}
