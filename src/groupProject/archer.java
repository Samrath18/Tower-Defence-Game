package groupProject;

import java.awt.Image;
import java.io.File;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class archer {
	
	JLabel labelArcher = new JLabel("");

	
	
	public archer(Image image) {
		
		labelArcher.setIcon(new ImageIcon(image));
		labelArcher.setBounds(267, 250, 50, 50);
	}
}
