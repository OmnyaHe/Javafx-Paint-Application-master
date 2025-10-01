package paint.controller;

import java.util.HashMap;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import paint.model.Shape;

public interface ShapeCreator {
    Shape create(Point2D start, Point2D end, Color color);
    Shape create(HashMap<String, Double> props);
}
