package drawrandomface;
import acm.graphics.*;
import java.awt.*;

public class Face extends GCompound {
    
    protected static final Color HEAD_COLOR = Color.LIGHT_GRAY;
    protected static final Color EYE_COLOR = Utility.randomColor();
    protected static final Color NOSE_COLOR = Utility.randomColor();
    protected static final Color EAR_COLOR = Utility.randomColor();
    protected static final Color MOUTH_COLOR = Utility.randomColor(); 
    protected static final Color SPECTACLES_COLOR = Utility.randomColor();   
    
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
