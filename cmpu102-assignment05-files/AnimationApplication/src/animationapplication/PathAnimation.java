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
public abstract class PathAnimation {

    protected GObject figure;
    protected int duration, delay;
    protected GPoint offset;
    
    public PathAnimation(GObject figure, GPoint offset, int duration, int delay) {
            this.delay = delay;
            this.figure = figure;
            this.duration = duration;
            this.offset = offset;

             
    }
    
    
    public void animate() {
        for(int frame = 0; frame < duration-1; frame++) {
            figure.setLocation(position(frame));
            figure.pause(delay);
        }
    }
    
    public void show(GraphicsProgram gProgram) {
        gProgram.add(figure); 
    }
    
    public void hide(GraphicsProgram gProgram) {
        gProgram.remove(figure);
    }
    
    protected abstract GPoint position(int frame);
    

}
