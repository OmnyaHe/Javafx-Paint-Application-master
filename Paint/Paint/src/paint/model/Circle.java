package paint.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;


public class Circle extends Ellipse{
    
    public Circle(Point2D startPos, Point2D endPos, Color strockColor) {
        super(startPos, endPos, strockColor);
        if(super.gethRadius()<super.getvRadius()){
            super.setvRadius(super.gethRadius());
        }else{
            super.sethRadius(super.getvRadius());
        }
        
    }

    public Circle() {
        
    }

@Override
public iShape clone() {
    Circle c = (Circle) super.clone();
    c.sethRadius(this.gethRadius());
    c.setvRadius(this.getvRadius());
    return c;
}

@Override
public String toString() {
    return "Circle [radius=" + gethRadius() + 
           ", color=" + getColor() + 
           ", fillColor=" + getFillColor() + "]";
}

    
    
    
}
