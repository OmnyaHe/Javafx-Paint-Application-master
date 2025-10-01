// file: paint/controller/TriangleFactory.java
package paint.controller;

import java.util.HashMap;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import paint.model.Shape;
import paint.model.Triangle;

public class TriangleFactory implements ShapeCreator {
    @Override
    public Shape create(Point2D start, Point2D end, Color color) {
        return new Triangle(start, end, color);
    }
    @Override
    public Shape create(HashMap<String, Double> props) {
        Shape s = new Triangle();
        s.setProperties(props);
        return s;
    }
}
