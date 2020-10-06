package dev.punchcafe.sci.field.fn;

@FunctionalInterface
public interface CoordinateToScalarTransformer3D {
    Number transform(double x, double y, double z);
}
