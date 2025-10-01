package paint.controller;

import java.util.HashMap;
import java.util.Map;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import paint.model.Shape;

public class ShapeFactory {

    private final Map<String, ShapeCreator> creators = new HashMap<>();

    public ShapeFactory() {
        creators.put("Circle",    new CircleFactory());
        creators.put("Ellipse",   new EllipseFactory());
        creators.put("Rectangle", new RectangleFactory());
        creators.put("Square",    new SquareFactory());
        creators.put("Line",      new LineFactory());
        creators.put("Triangle",  new TriangleFactory());
    }

    public Shape createShape(String ShapeType, Point2D start, Point2D end, Color color) {
        ShapeCreator c = creators.get(ShapeType);
        if (c == null) throw new IllegalArgumentException("Unknown shape type: " + ShapeType);
        return c.create(start, end, color);
    }

    public Shape createShape(String ShapeType, HashMap<String, Double> props) {
        ShapeCreator c = creators.get(ShapeType);
        if (c == null) throw new IllegalArgumentException("Unknown shape type: " + ShapeType);
        return c.create(props);
    }

}

