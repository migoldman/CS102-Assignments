/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drawrandomscene;

import acm.program.*;
import acm.graphics.*;
import java.awt.*;


/**
 *
 * @author michaelgoldman
 */
public class Ground extends GCompound {

    public Ground(Color color) {
        GRect ground = new GRect(-150, 0, 300, 100);
        ground.setFilled(true);
        ground.setColor(color);
        add(ground);

    }

}
