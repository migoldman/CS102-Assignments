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
public class DrawRandomScene extends GCompound {

    public void run() {
        Scene scene = new Scene();
        scene.scale(4);
        scene.move(150, 50);
        add(scene);
    }

    public static void main(String[] args) {
        new DrawRandomScene().start(args);
    }
}

