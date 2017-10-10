
package drawsuperhero;

import acm.program.*;
import acm.io.*;
import acm.graphics.*;
import java.awt.*;

public class SuperHeroes extends GraphicsProgram {

    GOval lanternFirstRing, lanternSecondRing, outerRing, innerRing;
    GRect lanternUpperBar, lanternLowerBar, firstVertLine,secondVertLine, 
            firstHorzLine, secondHorzLine, thirdHorzLine;
    
    
    public void createLantern() {
        GOval lanternFirstRing = new GOval(150, 150, 200, 200);
        lanternFirstRing.setFilled(true);
        lanternFirstRing.setColor(Color.GREEN);   
        GOval lanternSecondRing = new GOval(165, 165, 170, 170);
        lanternSecondRing.setFilled(true);
        lanternSecondRing.setColor(Color.WHITE);
        GRect lanternUpperBar = new GRect(150, 150, 200, 10);
        lanternUpperBar.setFilled(true);
        lanternUpperBar.setColor(Color.GREEN);
        GRect lanternLowerBar = new GRect(150, 350, 200, 10);
        lanternLowerBar.setFilled(true);
        lanternLowerBar.setColor(Color.GREEN);
        
        add(lanternFirstRing);
        add(lanternSecondRing);
        add(lanternUpperBar);
        add(lanternLowerBar);
    }
    
    public void createCaptain() { 
        GOval outerRing = new GOval(400, 115, 200, 200);
        outerRing.setFilled(true);
        outerRing.setColor(Color.BLACK);
        GOval innerRing = new GOval(415, 130, 170, 170);
        innerRing.setFilled(true);
        innerRing.setColor(Color.YELLOW);
        GRect firstVertLine = new GRect(530, 135, 10, 160);
        firstVertLine.setFilled(true);
        firstVertLine.setColor(Color.BLACK);
        GRect secondVertLine = new GRect(470, 125, 10, 180);
        secondVertLine.setFilled(true);
        secondVertLine.setColor(Color.BLACK);
        GRect firstHorzLine = new GRect(410, 180, 180, 10);
        firstHorzLine.setFilled(true);
        firstHorzLine.setFillColor(Color.BLACK);
        GRect secondHorzLine = new GRect(410, 220, 180, 10);
        secondHorzLine.setFilled(true);
        secondHorzLine.setColor(Color.BLACK);
        GRect thirdHorzLine = new GRect(420, 260, 160, 10);
        thirdHorzLine.setFilled(true);
        thirdHorzLine.setColor(Color.BLACK);
        
        add(outerRing);
        add(innerRing);
        add(firstVertLine);
        add(secondVertLine);
        add(firstHorzLine);
        add(secondHorzLine);
        add(thirdHorzLine);
    }
        
    public void run() {
        createLantern();
        createCaptain();

        IODialog dialog = getDialog();
        String firstName = dialog.readLine("Guess the superhero that wears "
                + "the left logo");
        String secondName = dialog.readLine("Guess the superhero that wears "
                + "the right logo? ");
        GLabel firstLabel = new GLabel(firstName, 150, 450);
        add(firstLabel);
        GLabel secondLabel = new GLabel(secondName, 400, 450);
        add(secondLabel);
        dialog.println("I hope you like my drawings!");
    }

    public static void main(String[] args) {
        new SuperHeroes().start(args);
    }
}
