package lunarphases;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

public class LunarPhases implements ActionListener {
    final static int NUM_IMAGES = 8;
    final static int START_INDEX = 3;

    ImageIcon[] images = new ImageIcon[NUM_IMAGES];
    JPanel mainPanel, selectPanel, displayPanel;

    JComboBox phaseChoices = null;
    JLabel phaseIconLabel = null;

    public LunarPhases() {
	selectPanel = new JPanel();
	displayPanel = new JPanel();
        initSelectPanel();
        initDisplayPanel();
	mainPanel = new JPanel();
	mainPanel.setLayout(new GridLayout(2,1,5,5));
	mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	mainPanel.add(selectPanel);
	mainPanel.add(displayPanel);
    }

    private void initDisplayPanel() {
 	for (int i = 0; i < NUM_IMAGES; i++) {
	    String imageName = "images/image" + i + ".jpg";
	    URL iconURL = ClassLoader.getSystemResource(imageName);
	    images[i] = new ImageIcon(iconURL);;
	}        
	phaseIconLabel = new JLabel();
	phaseIconLabel.setHorizontalAlignment(JLabel.CENTER);
	phaseIconLabel.setVerticalAlignment(JLabel.CENTER);
	phaseIconLabel.setVerticalTextPosition(JLabel.CENTER);
	phaseIconLabel.setHorizontalTextPosition(JLabel.CENTER);
	phaseIconLabel.setBorder(BorderFactory.createCompoundBorder(
			    BorderFactory.createLoweredBevelBorder(),
			    BorderFactory.createEmptyBorder(5,5,5,5)));	
	phaseIconLabel.setBorder(BorderFactory.createCompoundBorder(
			    BorderFactory.createEmptyBorder(0,0,10,0),
			    phaseIconLabel.getBorder())); 
	phaseIconLabel.setIcon(images[START_INDEX]);
	phaseIconLabel.setText("");    
        displayPanel.add(phaseIconLabel);
    }
    
    private void initSelectPanel() {
 	String[] phases = { "New", "Waxing Crescent", "First Quarter", 
			    "Waxing Gibbous", "Full", "Waning Gibbous", 
			    "Third Quarter", "Waning Crescent" };
	phaseChoices = new JComboBox(phases);
	phaseChoices.setSelectedIndex(START_INDEX);
	selectPanel.setBorder(BorderFactory.createCompoundBorder(
		BorderFactory.createTitledBorder("Select Phase"), 
		BorderFactory.createEmptyBorder(5,5,5,5)));
    	displayPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Display Phase"), 
            BorderFactory.createEmptyBorder(5,5,5,5)));    
 	phaseChoices.addActionListener(this);       
 	selectPanel.add(phaseChoices);       
    }

    public void actionPerformed(ActionEvent event) {
	if ("comboBoxChanged".equals(event.getActionCommand())) {
	    phaseIconLabel.setIcon(images[phaseChoices.getSelectedIndex()]);
	}
    }

    public static void main(String[] args) {
	LunarPhases phases = new LunarPhases();
	JFrame lunarPhasesFrame = new JFrame("Lunar Phases");
	lunarPhasesFrame.setContentPane(phases.mainPanel);
        lunarPhasesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	lunarPhasesFrame.pack();
	lunarPhasesFrame.setVisible(true);
    }
}

