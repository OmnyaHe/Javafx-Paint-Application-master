package paint.model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {
    private Point2D thirdPoint;

    public Triangle() {}

    public Triangle(Point2D startPos, Point2D endPos, Color strockColor) {
        super(startPos, endPos, strockColor);
        double temp = Math.abs(startPos.getX() - endPos.getX());
        if (getPosition().getX() < getEndPosition().getX()) {
            thirdPoint = new Point2D(endPos.getX() - (temp * 2), endPos.getY());
        } else {
            thirdPoint = new Point2D(endPos.getX() + (temp * 2), endPos.getY());
        }
    }

    @Override
    public void setTopLeft(Point2D x) {
        Point2D temp = x.subtract(getPosition());
        setPosition(x);
        setEndPosition(getEndPosition().add(temp));
        thirdPoint = thirdPoint.add(temp);
        super.setTopLeft(x);
    }

    @Override
    protected void getPropertiesToMap() {
        super.getPropertiesToMap();
        addToProperties("thirdPointX", thirdPoint.getX());
        addToProperties("thirdPointY", thirdPoint.getY());
    }

    @Override
    protected void setPropertiesToVariables() {
        super.setPropertiesToVariables();
        thirdPoint = new Point2D(getFromMap("thirdPointX"), getFromMap("thirdPointY"));
    }

    @Override
    public void draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double x1 = getPosition().getX();
        double y1 = getPosition().getY();
        double x2 = getEndPosition().getX();
        double y2 = getEndPosition().getY();
        double x3 = thirdPoint.getX();
        double y3 = thirdPoint.getY();

        gc.setStroke(getColor());
        gc.strokePolygon(new double[]{x1, x2, x3}, new double[]{y1, y2, y3}, 3);
        gc.setFill(getFillColor());
        gc.fillPolygon(new double[]{x1, x2, x3}, new double[]{y1, y2, y3}, 3);
    }

    @Override
    public iShape clone() {
        Triangle cloned = (Triangle) super.clone();
        cloned.thirdPoint = new Point2D(this.thirdPoint.getX(), this.thirdPoint.getY());
        return cloned;
    }

    @Override
    public String toString() {
        return "Triangle [start=" + getPosition() + ", end=" + getEndPosition() +
               ", thirdPoint=" + thirdPoint + ", color=" + getColor() + "]";
    }
}
