package paint.model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape {
    private double length;

    public Line() {}

    public Line(Point2D start, Point2D end, Color color) {
        super(start, end, color);
        length = start.distance(end);
    }

    @Override
    public void setFillColor(Color color) {
        setColor(color);
    }

    @Override
    public void setTopLeft(Point2D x) {
        Point2D temp = x.subtract(getPosition());
        setPosition(x);
        setEndPosition(getEndPosition().add(temp));
        super.setTopLeft(x);
    }

    @Override
    public void draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(getColor());
        gc.strokeLine(getPosition().getX(), getPosition().getY(),
                      getEndPosition().getX(), getEndPosition().getY());
    }

    @Override
    public iShape clone() {
        System.out.println("Line is Being Cloned");
        Line l = (Line) super.clone();
        l.length = this.length;
        return l;
    }

    @Override
    public String toString() {
        return "Line [start=" + getPosition() + ", end=" + getEndPosition() +
               ", color=" + getColor() + "]";
    }
}
