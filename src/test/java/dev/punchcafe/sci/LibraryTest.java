/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dev.punchcafe.sci;

import dev.punchcafe.sci.field.VectorField2D;
import dev.punchcafe.sci.vector.Vector2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'");
    }

    @Test
    void randomTest(){
        final var genericVector = VectorField2D.buildField((x,y) -> new Vector2(x+y, x-y), 10, 10);
        System.out.println(genericVector.toString());
        System.out.println(genericVector.transform((vec) -> new Vector2(vec.getY(), vec.getX())));
    }
}
