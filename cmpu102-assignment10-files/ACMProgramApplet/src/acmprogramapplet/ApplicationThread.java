/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acmprogramapplet;

/**
 *
 * @author michaelgoldman
 */
public class ApplicationThread extends Thread {
    int choice;
    
    public ApplicationThread(int choice) {
        this.choice = choice;
    }
    
    public void run() {
        switch(choice) {
            case 0: new drawrandomface.DrawRandomFace().start();
                break;
            case 1: new drawsuperhero.SuperHeroes().start();
                break;            
            case 2: new binpacking.BinPacking().start();
                break;
        }
    }
    
    
}
