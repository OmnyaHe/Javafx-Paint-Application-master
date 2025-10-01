package paint.model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape 
{
    private double width;
    private double height;

    public Rectangle() {}

    public Rectangle(Point2D startPos, Point2D endPos, Color strockColor) {
        super(startPos, endPos, strockColor);
        width = Math.abs(startPos.getX() - endPos.getX());
        height = Math.abs(startPos.getY() - endPos.getY());
    }

    public void setWidth(double width) { this.width = width; }
    public void setHeight(double height) { this.height = height; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }

    @Override
    protected void getPropertiesToMap() {
        super.getPropertiesToMap();
        addToProperties("width", width);
        addToProperties("height", height);
    }

    @Override
    protected void setPropertiesToVariables() {
        super.setPropertiesToVariables();
        width = getFromMap("width");
        height = getFromMap("height");
    }

    @Override
    public void draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(getColor());
        gc.strokeRect(getTopLeft().getX(), getTopLeft().getY(), width, height);
        gc.setFill(getFillColor());
        gc.fillRect(getTopLeft().getX(), getTopLeft().getY(), width, height);
    }

    @Override
    public iShape clone() {
        System.out.println("Rectangle is Being Cloned");
        Rectangle rect = (Rectangle) super.clone();
        rect.width = this.width;
        rect.height = this.height;
        return rect;
    }

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height +
               ", color=" + getColor() + ", fillColor=" + getFillColor() + "]";
    }
}
