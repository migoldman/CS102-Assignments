package drawrandomface;
import acm.graphics.*;
import java.awt.*;

public class Eye extends GCompound {
    
    public Eye(double xCenter, double yCenter, 
               double size, double ratio,Color color) {
        GOval eye = new GOval(xCenter-size/2,yCenter-size/2,size,size);
        eye.setFilled(false);
        eye.setColor(color);
        GOval iris = new GOval(xCenter-size*ratio/2,yCenter-size*ratio/2,size*ratio,size*ratio);
        iris.setFilled(true);
        iris.setColor(color);
        add(eye);        
        add(iris);
    }
    
}
