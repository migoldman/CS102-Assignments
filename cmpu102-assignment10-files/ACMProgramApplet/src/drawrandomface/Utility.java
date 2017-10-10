package drawrandomface;
import java.awt.*;

import java.util.Random;

public class Utility {

    public static boolean coinToss() {
        Random randomInts = new Random();  
        int face = randomInts.nextInt();
        int remainder = Math.abs(face) % 2;
        return remainder==1;
      }

    public static int dieRoll(int numSides) {
        Random randomInts = new Random();
        int side = randomInts.nextInt();
        int remainder = Math.abs(side) % numSides;
        return remainder;
      }
    
    public static Color randomColor() {
        Color color = null;
        switch (dieRoll(8)) {
            case 0: color = Color.BLACK; break;
            case 1: color = Color.BLUE; break;
            case 2: color = Color.CYAN; break;
            case 3: color = Color.GREEN; break;
            case 4: color = Color.MAGENTA; break;
            case 5: color = Color.RED; break;
            case 6: color = Color.YELLOW; break;
            case 7: color = Color.WHITE; break;
            default: color = Color.BLACK;
        }
        return color;
    }
    
    public static double randomDouble(double lBound, double uBound) {
        return lBound + Math.random()*(uBound-lBound);
    }     
    
}
