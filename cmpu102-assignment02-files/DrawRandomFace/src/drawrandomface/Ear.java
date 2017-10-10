package drawrandomface;
import acm.graphics.*;
import java.awt.*;

public class Ear extends GCompound {
    
    public Ear(double xCenter, double yCenter, 
               double width, double height, Color color) {
        GOval ear = new GOval(xCenter-width/2,yCenter-height/2,width,height);
        ear.setFilled(true);
        ear.setColor(color);
        add(ear);  
        GOval earRing; 
        if (Utility.coinToss()) {
            earRing = new GOval(100,50+height/2-height/4,width/8,height/8);
            earRing.setFilled(true);
            earRing.setColor(Utility.randomColor());
            add(earRing);
        }          
    }
    
}
