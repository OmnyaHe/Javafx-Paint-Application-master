// file: paint/controller/SquareFactory.java
package paint.controller;

import java.util.HashMap;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import paint.model.Shape;
import paint.model.Square;

public class SquareFactory implements ShapeCreator {
    @Override
    public Shape create(Point2D start, Point2D end, Color color) {
        return new Square(start, end, color);
    }
    @Override
    public Shape create(HashMap<String, Double> props) {
        Shape s = new Square();
        s.setProperties(props);
        return s;
    }
}
