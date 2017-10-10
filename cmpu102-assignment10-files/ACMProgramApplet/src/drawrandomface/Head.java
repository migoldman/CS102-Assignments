package drawrandomface;
import acm.graphics.*;
import java.awt.*;

public class Head extends GCompound {
    
    public Head(Color color) {
        GOval head = new GOval(0,0,100,100);
        head.setFilled(true);
        head.setColor(color);
        add(head);        
    }
    
}
