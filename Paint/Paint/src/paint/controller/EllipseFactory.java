// file: paint/controller/EllipseFactory.java
package paint.controller;

import java.util.HashMap;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import paint.model.Ellipse;
import paint.model.Shape;

public class EllipseFactory implements ShapeCreator {
    @Override
    public Shape create(Point2D start, Point2D end, Color color) {
        return new Ellipse(start, end, color);
    }
    @Override
    public Shape create(HashMap<String, Double> props) {
        Shape s = new Ellipse();
        s.setProperties(props);
        return s;
    }
}
