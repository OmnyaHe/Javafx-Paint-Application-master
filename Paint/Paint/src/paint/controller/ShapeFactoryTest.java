package paint.controller;

import static org.junit.jupiter.api.Assertions.*;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import paint.model.Shape;



public class ShapeFactoryTest {

    @Test
    void createsCircleAndRectangle_usingPoints() {
        ShapeFactory f = new ShapeFactory();

        Shape c = f.createShape("Circle", new Point2D(10,10), new Point2D(30,30), Color.BLUE);
        Shape r = f.createShape("Rectangle", new Point2D(0,0), new Point2D(40,20), Color.RED);

        assertNotNull(c);
        assertNotNull(r);
        assertEquals("Circle", c.getClass().getSimpleName());
        assertEquals("Rectangle", r.getClass().getSimpleName());
    }

}

