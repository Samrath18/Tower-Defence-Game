/*
 * This file contains the code for the pause menu of the game.
 * Samrath Singh
 * 2023/05/07
 */
package groupProject;

//Import statements
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class pauseScreen extends JFrame {

	//Declare class variables
	private static JButton bResume, bQuit, bNo, bYes;
	private static JLabel lblOptions, lblConfirmQuit;
	private static JPanel contentPane;
	private static JFrame pauseFrame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pauseFrame = new pauseScreen();
					pauseFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private pauseScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 303, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Options page components
		lblOptions = new JLabel("Options");
		lblOptions.setFont(new Font("High Tower Text", Font.PLAIN, 50));
		lblOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblOptions.setBounds(61, 29, 167, 59);
		contentPane.add(lblOptions);
		
		bResume = new JButton("Resume");
		bResume.setFont(new Font("High Tower Text", Font.PLAIN, 24));
		bResume.setBounds(72, 144, 145, 42);
		contentPane.add(bResume);
		
		bQuit = new JButton("Quit");
		bQuit.setFont(new Font("High Tower Text", Font.PLAIN, 24));
		bQuit.setBounds(72, 239, 145, 42);
		contentPane.add(bQuit);
		
		//Confirm quit page components
		bNo = new JButton("No");
		bNo.setVerticalAlignment(SwingConstants.BOTTOM);
		bNo.setFont(new Font("High Tower Text", Font.PLAIN, 24));
		bNo.setBounds(10, 196, 137, 42);
		contentPane.add(bNo);
		
		bYes = new JButton("Yes");
		bYes.setFont(new Font("High Tower Text", Font.PLAIN, 24));
		bYes.setVerticalAlignment(SwingConstants.BOTTOM);
		bYes.setBounds(152, 196, 127, 42);
		contentPane.add(bYes);
		
		lblConfirmQuit = new JLabel("Are you sure you wan to quit?");
		lblConfirmQuit.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmQuit.setFont(new Font("High Tower Text", Font.PLAIN, 20));
		lblConfirmQuit.setBounds(10, 133, 269, 36);
		contentPane.add(lblConfirmQuit);
		
		//Set statuses
		bNo.setVisible(false);
		bYes.setVisible(false);
		lblConfirmQuit.setVisible(false);
		
		actionListeners(); //Method call
	}
	
	/**
	 * Create action listeners
	 */
	private static void actionListeners() {
		bResume.addActionListener(new ActionListener() { //Action listener for bResume
			public void actionPerformed(ActionEvent e) {
				pauseFrame.setVisible(false); //Set pauseFrame invisible
			}
		});
		bQuit.addActionListener(new ActionListener() { //Action listener for bQuit
			public void actionPerformed(ActionEvent e) {
				//Set statuses
				bNo.setVisible(true);
				bYes.setVisible(true);
				lblConfirmQuit.setVisible(true);

				lblOptions.setVisible(false);
				bResume.setVisible(false);
				bQuit.setVisible(false);
			}
		});
		bNo.addActionListener(new ActionListener() { //Action listener for bNo
			public void actionPerformed(ActionEvent e) {
				//Set statuses
				bNo.setVisible(false);
				bYes.setVisible(false);
				lblConfirmQuit.setVisible(false);

				lblOptions.setVisible(true);
				bResume.setVisible(true);
				bQuit.setVisible(true);
			}
		});
		bYes.addActionListener(new ActionListener() { //Action listener for bYes
			public void actionPerformed(ActionEvent e) {
				pauseFrame.setVisible(false); //Set pauseFrame invisible
			}
		});
	}
}
