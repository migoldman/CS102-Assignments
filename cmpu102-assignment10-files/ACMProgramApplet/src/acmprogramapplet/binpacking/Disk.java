package binpacking;
import acm.graphics.*;
import java.awt.*;

class Disk extends GOval {

    private int radius;
    private boolean placed;
    private Color color;

    Disk(int cx, int cy, int r, Color c) {
        super(cx-r, cy-r, 2*r, 2*r);
        radius = r;
        color = c;
        setFillColor(c);
        setFilled(true);
        placed = false;
    }

    public int radius() {
        return radius;
    }

    public double centerX() {
        return getX() + getWidth()/2.0;
    }

    public double centerY() {
        return getY() + getHeight()/2.0;
    }

    public Color color() {
        return color;
    }

    public void place(GPoint point) {
        point.translate(-radius, -radius);
        setLocation(point);
        placed = true;
    }

    public boolean placed() {
        return placed;
    }
    
    public double separation(Disk otherDisk) {
        double dx = otherDisk.centerX() - centerX();
        double dy = otherDisk.centerY() - centerY();
        return Math.sqrt(dx*dx + dy*dy);
    }
    
}
