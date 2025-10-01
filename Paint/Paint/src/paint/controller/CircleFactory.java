// file: paint/controller/CircleFactory.java
package paint.controller;

import java.util.HashMap;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import paint.model.Circle;
import paint.model.Shape;

public class CircleFactory implements ShapeCreator {
    @Override
    public Shape create(Point2D start, Point2D end, Color color) {
        return new Circle(start, end, color);
    }
    @Override
    public Shape create(HashMap<String, Double> props) {
        Shape s = new Circle();
        s.setProperties(props);
        return s;
    }
}
