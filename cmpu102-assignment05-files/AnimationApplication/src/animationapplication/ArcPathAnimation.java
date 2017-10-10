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
public class ArcPathAnimation extends PathAnimation {

    GArc path;
    protected double x, y;
    protected double xc, yc;
    protected double w, h;
    protected double anglechange;
    protected double angle1, angle2;
    protected double anglec;
    protected double offsetx, offsety;

    ArcPathAnimation(GObject figure, GPoint offset, int duration, int delay, GArc path) {
        super(figure, offset, duration, delay);
        this.w = path.getWidth();
        this.h = path.getHeight();
        this.xc = path.getX() + w/2;
        this.yc = path.getY() + h/2;
        this.anglechange = (path.getSweepAngle() - path.getStartAngle()) / duration;
        this.offsetx = offset.getX();
        this.offsety = offset.getY();
        this.path = path;
    }

    protected GPoint position(int frame) {
        GPoint point;
        if (frame == 0) {
            angle1 = path.getStartAngle();
            x = xc - offsetx + ((w/2) * Math.cos(Math.toRadians(angle1)));
            y = yc - offsety - ((h/2) * Math.sin(Math.toRadians(angle1)));
            point = new GPoint (x,y);
        }
        else if (frame == duration - 1) {
            angle2 = path.getStartAngle() + path.getSweepAngle();
            x = xc -offsetx + ((w/2) * Math.cos(Math.toRadians(angle2)));
            y = yc - offsety - ((h/2) * Math.sin(Math.toRadians(angle2)));
            point = new GPoint (x,y);
        } else {
            anglec = anglechange * frame;
            x = xc -offsetx + ((w/2) * Math.cos(Math.toRadians(anglec)));
            y = yc - offsety - ((h/2) * Math.sin(Math.toRadians(anglec)));
            point = new GPoint (x,y);
        }
        return point;

    }

}
