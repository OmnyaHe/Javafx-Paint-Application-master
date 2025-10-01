package paint.controller;

import java.util.HashMap;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import paint.model.Line;
import paint.model.Shape;

public class LineFactory implements ShapeCreator {
    @Override
    public Shape create(Point2D start, Point2D end, Color color) {
        return new Line(start, end, color);
    }
    @Override
    public Shape create(HashMap<String, Double> props) {
        Shape s = new Line();
        s.setProperties(props);
        return s;
    }
}
