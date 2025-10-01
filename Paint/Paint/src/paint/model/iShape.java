package paint.model;

import java.util.Map;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public interface iShape {

    void setPosition(Point2D position);
    Point2D getPosition();

    void setProperties(Map<String, Double> properties);
    Map<String, Double> getProperties();

    void setColor(Color color);
    Color getColor();

    void setFillColor(Color color);
    Color getFillColor();

    void draw(Canvas canvas);

    iShape clone() throws CloneNotSupportedException;
}
