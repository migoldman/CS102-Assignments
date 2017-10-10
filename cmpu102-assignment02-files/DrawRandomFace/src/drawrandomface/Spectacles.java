package drawrandomface;
import acm.graphics.*;
import java.awt.*;

public class Spectacles extends GCompound {
    
    public Spectacles(double xCenter, double yCenter, 
                      double offset, double radius, Color color) {
      GOval leftSpect = new GOval(xCenter-offset-radius,yCenter-radius,2*radius,2*radius);
      leftSpect.setFilled(false);
      leftSpect.setColor(color);
      add(leftSpect);
      GOval rightSpect = new GOval(xCenter+offset-radius,yCenter-radius,2*radius,2*radius);
      rightSpect.setFilled(false);
      rightSpect.setColor(color);  
      add(rightSpect);
      GLine bridge = new GLine(xCenter-offset,yCenter-radius,xCenter+offset,yCenter-radius);
      bridge.setColor(color);     
      add(bridge);
    }
    
}
