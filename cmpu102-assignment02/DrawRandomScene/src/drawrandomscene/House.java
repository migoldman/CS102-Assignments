/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawrandomscene;

import java.awt.*;
import acm.graphics.*;

public class House extends GCompound {

    public House(Color base, double height, double width) {
        GRect house = new GRect(-40, -20, height, width);
        house.setFilled(true);
        house.setColor(base);
        add(house);

    }

}
