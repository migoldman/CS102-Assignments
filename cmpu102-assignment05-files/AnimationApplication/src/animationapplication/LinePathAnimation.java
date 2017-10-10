/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package animationapplication;
import acm.graphics.*;
import acm.program.*;

/**
 *
 * @author michaelgoldman
 */
public class LinePathAnimation extends PathAnimation {
    
    GLine path;
    protected double x, y;
    protected double xstart, ystart;
    protected double dx, dy;
    
    LinePathAnimation(GObject figure, GPoint offset, int duration, int delay, GLine path) {
        super(figure, offset, duration, delay);
        this.x = path.getEndPoint().getX() - offset.getX();
        this.y = path.getEndPoint().getY() - offset.getY();
        this.xstart = path.getStartPoint().getX() - offset.getX();
        this.ystart = path.getStartPoint().getY() - offset.getY();
        this.dx = Math.abs(x - xstart) / duration;
        this.dy = Math.abs(y - ystart) / duration;
        this.path = path;
    }
    
    protected GPoint position(int frame) {
        GPoint point;
        if (frame == 0) {
            point = path.getStartPoint();
        }
        else if(frame == duration-1) {
            point = path.getEndPoint();
        }
        else 
        {
            double tempx = xstart + frame * dx;
            double tempy = ystart + frame * dy;
            point = new GPoint(tempx, tempy);
        }
        return point;
    }
    
    
    
        
}
