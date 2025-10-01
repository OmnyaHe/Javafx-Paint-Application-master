package paint.model;

import java.util.HashMap;
import java.util.Map;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public abstract class Shape implements iShape, Cloneable {

    private Point2D startPosition;
    private Point2D endPosition;
    private Point2D topLeft;
    private Color color;
    private Color fillColor;
    private Map<String, Double> properties = new HashMap<>();

    public Shape() {}

    public Shape(Point2D startPos, Point2D endPos, Color strockColor) {
        this.startPosition = startPos;
        this.endPosition = endPos;
        this.color = strockColor;
        this.fillColor = Color.TRANSPARENT;
        this.topLeft = calculateTopLeft();
    }

    @Override
    public void setPosition(Point2D position) {
        this.startPosition = position;
    }

    public void setEndPosition(Point2D position) {
        this.endPosition = position;
    }

    @Override
    public Point2D getPosition() {
        return this.startPosition;
    }

    public Point2D getEndPosition() {
        return this.endPosition;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        this.properties = properties;
        setPropertiesToVariables();
    }

    protected void setPropertiesToVariables() {
        if (properties.isEmpty()) return;

        double startX = properties.get("startPositionX");
        double startY = properties.get("startPositionY");
        double endX = properties.get("endPositionX");
        double endY = properties.get("endPositionY");
        double topLeftX = properties.get("topLeftX");
        double topLeftY = properties.get("topLeftY");

        this.startPosition = new Point2D(startX, startY);
        this.endPosition = new Point2D(endX, endY);
        this.topLeft = new Point2D(topLeftX, topLeftY);

        this.color = Color.color(properties.get("strockR"), properties.get("strockG"), properties.get("strockB"));
        this.fillColor = Color.color(properties.get("fillR"), properties.get("fillG"), properties.get("fillB"));
    }

    protected double getFromMap(String s) {
        return properties.getOrDefault(s, Double.POSITIVE_INFINITY);
    }

    @Override
    public Map<String, Double> getProperties() {
        getPropertiesToMap();
        return this.properties;
    }

    protected void getPropertiesToMap() {
        properties.put("startPositionX", startPosition.getX());
        properties.put("startPositionY", startPosition.getY());
        properties.put("endPositionX", endPosition.getX());
        properties.put("endPositionY", endPosition.getY());
        properties.put("topLeftX", topLeft.getX());
        properties.put("topLeftY", topLeft.getY());
        properties.put("strockR", color.getRed());
        properties.put("strockG", color.getGreen());
        properties.put("strockB", color.getBlue());
        properties.put("fillR", fillColor.getRed());
        properties.put("fillG", fillColor.getGreen());
        properties.put("fillB", fillColor.getBlue());
    }

    public void addToProperties(String s, Double x) {
        properties.put(s, x);
    }

    public Shape cloneShape() throws CloneNotSupportedException {
        Shape temp = null;
        temp = (Shape) super.clone();
        return temp;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return this.fillColor;
    }

    @Override
    public void draw(Canvas canvas) {}

    public Point2D calculateTopLeft() {
        double x = Math.min(this.getPosition().getX(), this.getEndPosition().getX());
        double y = Math.min(this.getPosition().getY(), this.getEndPosition().getY());
        return new Point2D(x, y);
    }

    public Point2D getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point2D pos) {
        this.topLeft = pos;
    }

    @Override
    public iShape clone()
 {
    try {
        return (Shape) super.clone();
    } catch (CloneNotSupportedException e) {
        e.printStackTrace();
        return null;
    }
}



}