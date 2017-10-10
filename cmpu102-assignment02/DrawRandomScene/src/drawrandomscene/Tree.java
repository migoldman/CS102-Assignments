/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawrandomscene;

import acm.graphics.GCompound;
import acm.graphics.*;
import acm.graphics.GRect;
import java.awt.Color;

/**
 *
 * @author michaelgoldman
 */
public class Tree extends GCompound {

    public Tree(Color color, double height, double width) {
        GRect tree;
        GOval leaves;
        if (Utility.coinToss()) {
            tree = new GRect(27, -20, height, width);
            leaves = new GOval(15, -40, 30, 30);
        } else {
            tree = new GRect(-100, -20, height, width);
            leaves = new GOval(-110, -40, 30, 30);
        }

        tree.setFilled(true);
        tree.setColor(color);
        add(tree);

        leaves.setFilled(true);
        leaves.setColor(Color.GREEN);
        add(leaves);
    }
}
