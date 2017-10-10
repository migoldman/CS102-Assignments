/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawrandomscene;

import acm.graphics.GCompound;
import acm.graphics.GRect;
import java.awt.Color;

/**
 *
 * @author michaelgoldman
 */
public class Sky extends GCompound {

    public Sky(Color color) {
        GRect sky = new GRect(-150, -150, 600, 600);
        sky.setFilled(true);
        sky.setColor(color);
        add(sky);
    }

}
