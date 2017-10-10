package binpacking;
import acm.program.*;
import acm.graphics.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;

public class BinPacking extends GraphicsProgram {
  private static final int WINDOW_WIDTH = 800;
  private static final int WINDOW_HEIGHT = 800;
  private static final int BIN_OFFSET_X = 50;
  private static final int BIN_OFFSET_Y = 50;
  private static final int BIN_WIDTH = 500;
  private static final int BIN_HEIGHT = 600;
  private static final int BIN_RIGHT = BIN_OFFSET_X + BIN_WIDTH;
  private static final int BIN_LEFT = BIN_OFFSET_Y;
  private static final int BIN_BOTTOM = BIN_OFFSET_Y + BIN_HEIGHT;
  private static final int BIN_TOP = BIN_OFFSET_Y;  
  private static final int MAX_DISKS = 10;
  private static final int MIN_RADIUS = 5;
  private static final int MAX_RADIUS = 50;
  private static final int HOME_X = 650;
  private static final int HOME_Y = 100;
  private static final int MESSAGE_HEIGHT = 50;
  private static final int MESSAGE_WIDTH = BIN_WIDTH;  
  private static final int MESSAGE_OFFSET_X = BIN_OFFSET_X;
  private static final int MESSAGE_OFFSET_Y = WINDOW_HEIGHT-BIN_OFFSET_Y-MESSAGE_HEIGHT; 
  private static final int DELAY = 125;
  
  private static GRect bin;
  private static Random randomizer = new Random();
  private static boolean gameOver = false; 
  private static Disk[] diskArray;
  private static int disksPlaced = 0;
  
    public void run() {
        setUpPlayArea();
        addMouseListeners();
        diskArray = initialDiskArray(randomizer);
        showNextDisk();
        while (!gameOver) pause(DELAY);
        displayGameOverMessage();
    }
    
    private void setUpPlayArea() {
        bin = new GRect(BIN_OFFSET_X, BIN_OFFSET_Y, BIN_WIDTH, BIN_HEIGHT);
        add(bin);
    }

    private static Disk[] initialDiskArray(Random randomizer) {
        Disk[] diskArray = new Disk[MAX_DISKS];
        for (int diskNumber = 0; diskNumber < MAX_DISKS; diskNumber++) {
            diskArray[diskNumber] = new Disk(HOME_X, HOME_Y, randomRadius(randomizer), randomColor(randomizer));
        }
        return diskArray;
    }

    static public int randomRadius(Random randomizer) {
        return MIN_RADIUS + Math.abs(randomizer.nextInt()) % (MAX_RADIUS - MIN_RADIUS + 1);
    }

    static public Color randomColor(Random randomizer) {
        final int MAX_COLORS = 5;
        Color answer;
        switch (Math.abs(randomizer.nextInt()) % MAX_COLORS) {
            case 0:
                answer = Color.red;
                break;
            case 1:
                answer = Color.green;
                break;
            case 2:
                answer = Color.blue;
                break;
            case 3:
                answer = Color.yellow;
                break;
            default:
                answer = Color.black;
        }
        return answer;
    }
  

    
    private void showNextDisk() {
        if (disksPlaced==diskArray.length) {
            diskArray = expandedDiskArray(diskArray, randomizer);
        }
        Disk nextDisk = diskArray[disksPlaced];
        add(nextDisk);
    }
    
    Disk[] expandedDiskArray(Disk[] oldDiskArray, Random randomizer) {
        Disk[] newDiskArray = new Disk[2*oldDiskArray.length];
        for (int i=0; i<oldDiskArray.length;i++) {
            newDiskArray[i] = oldDiskArray[i];
        }
        for (int i=oldDiskArray.length; i<newDiskArray.length;i++) {
            newDiskArray[i] = new Disk(HOME_X, HOME_Y, randomRadius(randomizer), randomColor(randomizer));
        }
        return newDiskArray;
    }
    
    public void mousePressed(MouseEvent e) {
        if (!gameOver) {
            GPoint clickPoint = new GPoint(e.getX(), e.getY());
            Disk currentDisk = diskArray[disksPlaced];
            currentDisk.place(clickPoint);
            gameOver = !validPosition(currentDisk);
            disksPlaced++;
            showNextDisk();
        }
    } 
    
    private static boolean validPosition(Disk disk) {
        boolean answer = true; 
        if ( (disk.centerX()-disk.radius()) <= BIN_LEFT ) return false;
        if ( (disk.centerX()+disk.radius()) >= BIN_RIGHT ) return false;
        if ( (disk.centerY()-disk.radius()) <= BIN_TOP ) return false;
        if ( (disk.centerY()+disk.radius()) >= BIN_BOTTOM ) return false;
        for (int i = 0; i < disksPlaced; i++) {
            Disk oldDisk = diskArray[i];
            double distance = disk.separation(oldDisk);
            if (distance <= oldDisk.radius() + disk.radius()) {
                answer = false;
                break;
            }
        }      
        return answer;
    }
    
    private void displayGameOverMessage() {
        disksPlaced--;
        String messageText = disksPlaced + " Disks Placed Successfully: Game Over!";
        GLabel message = new GLabel(messageText,MESSAGE_OFFSET_X,MESSAGE_OFFSET_Y);
        message.setFont(new Font("Serif", Font.BOLD, 20));
        add(message);
    }
    
    public static void main(String[] args) {
        new BinPacking().start();
    }  
}








