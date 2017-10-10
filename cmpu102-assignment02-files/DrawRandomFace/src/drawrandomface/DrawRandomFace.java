package drawrandomface;
import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class DrawRandomFace extends GraphicsProgram { 
    
    public void run() {
            Face face = new Face();
            face.scale(4);
            face.move(150,50);
            add(face);
    }  

    public static void main(String[] args) {
        new DrawRandomFace().start(args);
    }
          
}