/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acmprogramapplet;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author michaelgoldman
 */
public class ACMProgramApplet extends JApplet implements ActionListener {
   
    static JPanel selectPanel, mainPanel, displayPanel;
    JComboBox selection = null;
    JButton button;
    String[] programs = {"Draw Random Face", "Draw Super Hero Logo", "Bin Packing"};

    
    public void init() {
        
        selection = new JComboBox(programs);
        selection.setSelectedIndex(0);
        selectPanel = new JPanel();
        selectPanel.add(selection);
        button = new JButton("Start");
        button.addActionListener(this);   
        displayPanel = new JPanel();
        displayPanel.add(button);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,1,5,5));
	mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	mainPanel.add(selectPanel);
	mainPanel.add(displayPanel);
        getContentPane().add(mainPanel);
        
        
        
    }
    public void actionPerformed(ActionEvent e) {
        int choice = selection.getSelectedIndex();
        new ApplicationThread(choice).start();
    }
    


    
}
