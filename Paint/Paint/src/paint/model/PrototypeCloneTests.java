package paint.model;

import static org.junit.jupiter.api.Assertions.*;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

public class PrototypeCloneTests {

    @Test
    void rectangle_cloneProducesIndependentObject() {
        Rectangle r1 = new Rectangle(new Point2D(0, 0), new Point2D(100, 50), Color.RED);
        Rectangle r2 = (Rectangle) r1.clone();

        assertNotNull(r2);
        assertNotSame(r1, r2);
        assertEquals(Rectangle.class, r2.getClass());

        // same state copied
        assertEquals(r1.getWidth(),  r2.getWidth());
        assertEquals(r1.getHeight(), r2.getHeight());
        assertEquals(r1.getColor(),  r2.getColor());
        assertEquals(r1.getFillColor(), r2.getFillColor());

        // mutate clone — original must not change
        r2.setWidth(999);
        r2.setHeight(888);
        r2.setColor(Color.BLUE);

        assertEquals(100.0, r1.getWidth(), 1e-6);
        assertEquals(50.0,  r1.getHeight(), 1e-6);
        assertEquals(Color.RED, r1.getColor());
    }

    @Test
    void ellipse_and_circle_cloneCopyRadii_andAreIndependent() {
        Ellipse e1 = new Ellipse(new Point2D(0, 0), new Point2D(20, 10), Color.BLACK);
        Ellipse e2 = (Ellipse) e1.clone();
        assertNotSame(e1, e2);
        assertEquals(e1.gethRadius(), e2.gethRadius());
        assertEquals(e1.getvRadius(), e2.getvRadius());
        e2.sethRadius(123); e2.setvRadius(456);
        assertNotEquals(e1.gethRadius(), e2.gethRadius());

        Circle c1 = new Circle(new Point2D(0, 0), new Point2D(10, 10), Color.BLACK);
        Circle c2 = (Circle) c1.clone();
        assertNotSame(c1, c2);
        assertEquals(c1.gethRadius(), c2.gethRadius());
        assertEquals(c1.getvRadius(), c2.getvRadius());
    }

    @Test
    void triangle_cloneHasIndependentGeometry() {
        Triangle t1 = new Triangle(new Point2D(100, 100), new Point2D(120, 110), Color.GREEN);
        Triangle t2 = (Triangle) t1.clone();
        assertNotSame(t1, t2);

        // move only the clone; original points must stay
        Point2D origStart = t1.getPosition();
        Point2D origEnd   = t1.getEndPosition();

        t2.setTopLeft(t2.getTopLeft().add(10, 10));

        assertEquals(origStart, t1.getPosition());
        assertEquals(origEnd,   t1.getEndPosition());
    }

    @Test
    void line_cloneIsSeparate() {
        Line l1 = new Line(new Point2D(0, 0), new Point2D(10, 10), Color.BLACK);
        Line l2 = (Line) l1.clone();
        assertNotSame(l1, l2);

        l2.setTopLeft(new Point2D(5, 5));
        assertEquals(new Point2D(0, 0), l1.getPosition()); // original unaffected
    }

    @Test
    void cloneFactory_clonesPolymorphically() {
        CloneFactory cf = new CloneFactory();
        iShape s1 = new Rectangle(new Point2D(0, 0), new Point2D(1, 1), Color.BLACK);
        iShape s2 = cf.getClone(s1);

        assertNotNull(s2);
        assertNotSame(s1, s2);
        assertEquals(s1.getClass(), s2.getClass());
    }
}
