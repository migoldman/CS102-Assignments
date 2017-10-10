package animationapplication;

import acm.program.*;
import acm.graphics.*;

public class AnimationApplication extends GraphicsProgram {
    
    public void run() {

        GObject ball = new GOval(0, 0, 100, 100);
        GPoint offset = new GPoint(50,50);

        GLine line = new GLine(100, 300, 600, 300);
        add(line);
        
        GArc arc = new GArc(100, 200, 500, 200, 0, 360);
        add(arc);        
        
        PathAnimation animation1 = new LinePathAnimation(ball, offset, 200, 25, line);
        animation1.show(this);
        animation1.animate();
        animation1.hide(this);

        PathAnimation animation2 = new ArcPathAnimation(ball, offset, 400, 25, arc);
        animation2.show(this);
        animation2.animate();
        animation2.hide(this);
 
    }

    public static void main(String[] args) {
        new AnimationApplication().start();
    }
}
