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
public class Scene extends GCompound {

    protected static final Color HOUSE_COLOR = Utility.randomColor();
    protected static final Color GROUND_COLOR = Color.GREEN;
    protected static final Color SUN_COLOR = Color.YELLOW;
    protected static final Color DOOR_COLOR = Utility.randomColor();
    protected static final Color SKY_COLOR = Color.CYAN;
    protected static final Color TREE_BARK = new Color(156, 93, 82);
    protected static final Color TREE_LEAVES = Color.GREEN;

    //protected static final double HOUSE_HEIGHT = Utility.randomDouble(30,60);
    //protected static final double HOUSE_WIDTH = Utility.randomDouble(30,60);
    //protected static final double ROOF_HEIGHT = Utility.randomDouble(30, 60);
    //protected static final double ROOF_WIDTH = Utility.randomDouble(30, 60);
    protected Ground ground;
    protected Sun sun;
    protected House house;
    protected Door door;
    protected Sky sky;
    protected Tree tree, leaves;

    public Scene() {
        createComponents();
        addComponents();
    }

    public void createComponents() {
        this.ground = new Ground(GROUND_COLOR);
        this.sun = new Sun(SUN_COLOR);
        this.house = new House(HOUSE_COLOR, 30, 30);
        this.sky = new Sky(SKY_COLOR);
        this.tree = new Tree(TREE_BARK, 7, 30);
        this.door = new Door(DOOR_COLOR);

    }

    public void addComponents() {
        add(sky);
        add(ground);
        add(sun);
        add(house);
        add(tree);
        add(door);
    }

}

//public class Face extends GCompound {
/*     
 protected static final double MOUTH_WIDTH = Utility.randomDouble(30,70);
 protected static final double MOUTH_HEIGHT = Utility.randomDouble(10,50);
 protected static final double NOSE_WIDTH = Utility.randomDouble(15,25);
 protected static final double NOSE_HEIGHT = Utility.randomDouble(20,30);    
    
 protected Head head;
 protected Eye leftEye, rightEye;
 protected Nose nose;
 protected Ear leftEar, rightEar;
 protected Mouth mouth;     
 protected Spectacles spectacles;
    
 public Face() {
 createComponents();
 addComponents();
 }    
    
 public void createComponents() {
 this.head = new Head(HEAD_COLOR);
 this.leftEye = new Eye(25,35,20,0.5,EYE_COLOR);
 this.rightEye = new Eye(75,35,20,0.5,EYE_COLOR);
 this.nose = new Nose(NOSE_WIDTH,NOSE_HEIGHT,NOSE_COLOR);
 this.leftEar = new Ear(0,50,20,40,EAR_COLOR);
 this.rightEar = new Ear(100,50,20,40,EAR_COLOR);
 this.mouth = new Mouth(MOUTH_WIDTH,MOUTH_HEIGHT,MOUTH_COLOR);
 if (Utility.coinToss()) {
 this.spectacles = new Spectacles(50,35,25,20,SPECTACLES_COLOR); 
 } else {
 this.spectacles = null; 
 }
        
 }

 public void addComponents() {
 add(leftEar);
 add(rightEar);
 add(head);
 add(leftEye);
 add(rightEye);
 add(nose);
 add(mouth);   
 if (this.spectacles != null) {
 add(spectacles);
 }
 }

 }
 */
