package drawrandomface;

import acm.graphics.*;
import java.awt.*;

public class Mouth extends GCompound {

    public Mouth(double width, double height, Color color) {
        GArc mouth = null;
        if (Utility.coinToss()) {
            mouth = new GArc(50 - width / 2, 70 - height / 2, width, height, 200, 140);
        } else {
            mouth = new GArc(50 - width / 2, 70, width, height, -200, -140);
        }
        mouth.setColor(color);
        add(mouth);
    }

}
