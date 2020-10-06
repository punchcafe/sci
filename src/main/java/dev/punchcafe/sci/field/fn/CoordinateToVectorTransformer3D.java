package dev.punchcafe.sci.field.fn;

import dev.punchcafe.sci.vector.Vector3;

@FunctionalInterface
public interface CoordinateToVectorTransformer3D {
    Vector3 transform(double x, double y, double z);
}
