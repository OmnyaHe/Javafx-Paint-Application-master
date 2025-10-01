// file: paint/controller/RectangleFactory.java
package paint.controller;

import java.util.HashMap;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import paint.model.Rectangle;
import paint.model.Shape;

public class RectangleFactory implements ShapeCreator {
    @Override
    public Shape create(Point2D start, Point2D end, Color color) {
        return new Rectangle(start, end, color);
    }
    @Override
    public Shape create(HashMap<String, Double> props) {
        Shape s = new Rectangle();
        s.setProperties(props);
        return s;
    }
}
