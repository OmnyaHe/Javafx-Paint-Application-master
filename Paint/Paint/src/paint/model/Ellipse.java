package paint.model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ellipse extends Shape {
    private double hRadius;
    private double vRadius;

    public Ellipse() {}

    public Ellipse(Point2D startPos, Point2D endPos, Color strockColor) {
        super(startPos, endPos, strockColor);
        hRadius = Math.abs(startPos.getX() - endPos.getX()) / 2;
        vRadius = Math.abs(startPos.getY() - endPos.getY()) / 2;
    }

    public void sethRadius(double hRadius) { this.hRadius = hRadius; }
    public void setvRadius(double vRadius) { this.vRadius = vRadius; }
    public double gethRadius() { return hRadius; }
    public double getvRadius() { return vRadius; }

    @Override
    protected void getPropertiesToMap() {
        super.getPropertiesToMap();
        addToProperties("hRadius", hRadius);
        addToProperties("vRadius", vRadius);
    }

    @Override
    protected void setPropertiesToVariables() {
        super.setPropertiesToVariables();
        hRadius = getFromMap("hRadius");
        vRadius = getFromMap("vRadius");
    }

    @Override
    public void draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(getColor());
        gc.strokeOval(getTopLeft().getX(), getTopLeft().getY(), hRadius * 2, vRadius * 2);
        gc.setFill(getFillColor());
        gc.fillOval(getTopLeft().getX(), getTopLeft().getY(), hRadius * 2, vRadius * 2);
    }

    @Override
    public iShape clone() {
        System.out.println("Ellipse is Being Cloned");
        Ellipse e = (Ellipse) super.clone();
        e.hRadius = this.hRadius;
        e.vRadius = this.vRadius;
        return e;
    }

    @Override
    public String toString() {
        return "Ellipse [hRadius=" + hRadius + ", vRadius=" + vRadius +
               ", color=" + getColor() + ", fillColor=" + getFillColor() + "]";
    }
}
