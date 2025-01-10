package groupProject;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EndGamePanel extends JPanel{
	static JLabel lblNewLabel;
	public EndGamePanel() {
		
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		lblNewLabel = new JLabel("GAME OVER");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Wide Latin", Font.PLAIN, 30));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(40, 119, 377, 77);
		add(lblNewLabel);
	}
}
