package drawrandomface;
import acm.graphics.*;
import java.awt.*;

public class Nose extends GCompound {
    
    public Nose(double width, double height, Color color) {
        GPolygon nose = new GPolygon();
        nose.addVertex(50,47.5-height/2);
        nose.addVertex(56-width/2,47.5+height/2);
        nose.addVertex(5+width/2,47.5+height/2);
        nose.setFilled(true);
        nose.setColor(color);
        add(nose);        
    }
    
}