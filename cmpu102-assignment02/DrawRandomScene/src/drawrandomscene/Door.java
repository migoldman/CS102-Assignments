/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawrandomscene;

import java.awt.*;
import acm.graphics.*;

/**
 *
 * @author michaelgoldman
 */
public class Door extends GCompound {

    public Door(Color color) {
        GRect door = new GRect(-30, 0, 5, 10);
        door.setFilled(true);
        door.setColor(color);
        add(door);
    }
}
