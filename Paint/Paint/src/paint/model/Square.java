package paint.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;


public class Square extends Rectangle{
    
    public Square(Point2D startPos, Point2D endPos, Color strockColor) {
        super(startPos, endPos, strockColor);
        if(super.getHeight()<super.getWidth()){
            super.setWidth(super.getHeight());
        }else{
            super.setHeight(super.getWidth());
        }
    }

    public Square() {
        
    }
    
// Square
@Override
public iShape clone() {
    Square s = (Square) super.clone();
    s.setWidth(this.getWidth());
    s.setHeight(this.getHeight());
    return s;
}

@Override
public String toString() {
    return "Square [width=" + getWidth() + 
           ", height=" + getHeight() + 
           ", color=" + getColor() + 
           ", fillColor=" + getFillColor() + "]";
}

}
