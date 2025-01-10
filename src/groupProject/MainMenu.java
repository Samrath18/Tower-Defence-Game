package groupProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.util.concurrent.TimeUnit;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	
	static int helpPageNum = 0;
	
	static JScrollPane[] helpPages = new JScrollPane[3];
	
	public static MainMenu frame = new MainMenu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setTitle("Tower Defense Game");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel MenuPanel = new JPanel();
		MenuPanel.setBounds(0, 0, 434, 306);
		contentPane.add(MenuPanel);
		MenuPanel.setLayout(null);
		
		JLabel MenuTitleText = new JLabel("Tower Defense Game");
		MenuTitleText.setForeground(Color.WHITE);
		MenuTitleText.setFont(new Font("High Tower Text", Font.BOLD, 38));
		MenuTitleText.setHorizontalAlignment(SwingConstants.CENTER);
		MenuTitleText.setBounds(32, 22, 370, 47);
		MenuPanel.add(MenuTitleText);
		
		JLabel MenuFooterText = new JLabel("ICS4U0 Final Group Project 2023");
		MenuFooterText.setForeground(Color.WHITE);
		MenuFooterText.setHorizontalAlignment(SwingConstants.CENTER);
		MenuFooterText.setFont(new Font("High Tower Text", Font.BOLD, 14));
		MenuFooterText.setBounds(44, 259, 346, 28);
		MenuPanel.add(MenuFooterText);
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setBorder(null);
		ButtonPanel.setOpaque(false);
		ButtonPanel.setBounds(77, 80, 280, 167);
		MenuPanel.add(ButtonPanel);
		ButtonPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DifficultyScreen.main(new String[0]);
				frame.dispose();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton.setBounds(0, 0, 98, 28);
		ButtonPanel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Play minigames until you lose.");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(110, 45, 170, 27);
		ButtonPanel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Help");
		btnNewButton_1.setBounds(0, 92, 98, 28);
		ButtonPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Learn how to play the game.");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(110, 92, 159, 27);
		ButtonPanel.add(lblNewLabel_1_1);
		
		JButton btnNewButton_2 = new JButton("Quit");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0); // terminate the program when exitButton is pressed
			}
		});
		btnNewButton_2.setBounds(0, 139, 98, 28);
		ButtonPanel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Quit the game.");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setBounds(110, 139, 82, 27);
		ButtonPanel.add(lblNewLabel_1_2);
		
		JButton btnInfiniteMinigame = new JButton("Minigames");
		btnInfiniteMinigame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frame.dispose();
				InfiniteMinigame.infMinigameStarted = 1;
				InfiniteMinigame.main(new String[0]);
			}
		});
		btnInfiniteMinigame.setBounds(0, 45, 98, 28);
		ButtonPanel.add(btnInfiniteMinigame);
		
		JLabel lblNewLabel_1_3 = new JLabel("Start defending your tower.");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setBounds(110, 1, 154, 27);
		ButtonPanel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("graphics/game_Background_mainmenu.png"));
		lblNewLabel.setBounds(0, 0, 434, 306);
		MenuPanel.add(lblNewLabel);
		
		JPanel HelpPanel = new JPanel();
		HelpPanel.setOpaque(false);
		HelpPanel.setBounds(0, 0, 434, 306);
		contentPane.add(HelpPanel);
		HelpPanel.setLayout(null);
		
		JButton HelpBackButton = new JButton("Back");
		HelpBackButton.setBounds(17, 16, 86, 28);
		HelpPanel.add(HelpBackButton);
		
		JLabel HelpTitleText = new JLabel("How to Play");
		HelpTitleText.setForeground(Color.WHITE);
		HelpTitleText.setHorizontalAlignment(SwingConstants.CENTER);
		HelpTitleText.setFont(new Font("High Tower Text", Font.BOLD, 32));
		HelpTitleText.setBounds(58, 12, 318, 42);
		HelpPanel.add(HelpTitleText);
		
		JPanel HelpInfoPanel = new JPanel();
		HelpInfoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		HelpInfoPanel.setBounds(17, 58, 400, 189);
		HelpPanel.add(HelpInfoPanel);
		HelpInfoPanel.setLayout(null);
		
		JScrollPane Help1 = new JScrollPane();
		Help1.setBorder(null);
		Help1.setName("Help1");
		Help1.setBounds(9, 4, 382, 180);
		HelpInfoPanel.add(Help1);
		
		JTextPane Help1Text = new JTextPane();
		Help1Text.setBackground(SystemColor.menu);
		Help1.setViewportView(Help1Text);
		Help1Text.setText("A swarm of monsters are heading directly toward the castle to steal our fortune! \r\n\r\nYou are the commander of the kingdom's army. Command your troops to battle and secure victory.\r\n\r\nProtect the front tower and ensure the monsters do not enter the kingdom.");
		Help1Text.setFont(new Font("High Tower Text", Font.PLAIN, 16));
		Help1Text.setEditable(false);
		Help1Text.setCaretPosition(0);
		
		JScrollPane Help2 = new JScrollPane();
		Help2.setBorder(null);
		Help2.setName("Help2");
		Help2.setBounds(9, 4, 382, 180);
		HelpInfoPanel.add(Help2);
		
		JTextPane Help2Text = new JTextPane();
		Help2Text.setBackground(SystemColor.menu);
		Help2.setViewportView(Help2Text);
		Help2Text.setText("You’ll start with 100 health points and 5 coins. \r\n5 coins will regenerate every 5 seconds. \r\n\r\nHere are your troops: \r\n\r\nRaider (red)\r\n\tSpeed: 10 (Highest)\r\n\tHealth Points: 1 HP\r\n\tAttack Points: 1 Attack\r\n\tAttack Style: Melee\r\n\tCost: 10 coins\r\n\r\nPuncher (blue)\r\n\tSpeed: 7\r\n\tHealth Points: 2 HP\r\n\tAttack Points: 1 Attack\r\n\tAttack Style: Melee\r\n\tCost: 18 coins\r\n\r\nSoldier (green)\r\n\tSpeed: 5\r\n\tHealth Points: 4 HP\r\n\tAttack Points: 2 Attack\r\n\tAttack Style: Melee\r\n\tCost: 25 coins\r\n\r\nArcher (brown)\r\n\tSpeed: 5\r\n\tHealth Points: 3 HP\r\n\tAttack Points: 2 Attack\r\n\tAttack Style: Ranged \r\n\t(Attacks from a short distance)\r\n\tCost: 25 coins\r\n\r\nShotgunner (purple)\r\n\tSpeed: 3\r\n\tHealth Points: 5 HP\r\n\tAttack Points: 5 Attack\r\n\tAttack Style: Ranged \r\n\t(Attacks from a medium distance)\r\n\tCost: 35 coins\r\n\r\nSniper (pink)\r\n\tSpeed: 2\r\n\tHealth Points: 5 HP\r\n\tAttack Points: 6 Attack\r\n\tAttack Style: Ranged \r\n\t(Attacks from a long distance)\r\n\tCost: 45 coins\r\n\r\nSuper Warrior (orange)\r\n\tSpeed: 1\r\n\tHealth Points: 12 HP\r\n\tAttack Points: 8 Attack\r\n\tAttack Style: Melee\r\n\tCost: 60 coins\r\n");
		Help2Text.setFont(new Font("High Tower Text", Font.PLAIN, 16));
		Help2Text.setEditable(false);
		Help2Text.setCaretPosition(0);
		
		JScrollPane Help3 = new JScrollPane();
		Help3.setBorder(null);
		Help3.setName("Help3");
		Help3.setBounds(9, 4, 382, 180);
		HelpInfoPanel.add(Help3);
		
		JTextPane Help3Text = new JTextPane();
		Help3Text.setBackground(SystemColor.menu);
		Help3.setViewportView(Help3Text);
		Help3Text.setText("You must know the enemy's weaknesses and strengths to use your troops efficiently. \r\n\r\nHere is the information we have collected on the enemy's army:\r\n\r\nGoblin (Small)\r\n\tSpeed: 10 (Highest)\r\n\tHealth Points: 3 HP\r\n\tAttack Points: 2 Attack\r\n\tAttack Style: Melee\r\n\r\nWizard (Medium)\r\n\tSpeed: 6\r\n\tHealth Points: 8 HP\r\n\tAttack Points: 5 Attack\r\n\tAttack Style: Ranged\r\n\t(Attacks from a medium distance)\r\n\r\nGiant (Large)\r\n\tSpeed: 1\r\n\tHealth Points: 20 HP\r\n\tAttack Points: 10 Attack\r\n\tAttack Style: Melee\r\n");
		Help3Text.setFont(new Font("High Tower Text", Font.PLAIN, 16));
		Help3Text.setEditable(false);
		Help3Text.setCaretPosition(0);
		
		JPanel HelpPageButtons = new JPanel();
		HelpPageButtons.setOpaque(false);
		HelpPageButtons.setBounds(33, 260, 367, 29);
		HelpPanel.add(HelpPageButtons);
		HelpPageButtons.setLayout(null);
		
		JButton PrevPageButton = new JButton("Previous");
		PrevPageButton.setBounds(0, 0, 86, 28);
		HelpPageButtons.add(PrevPageButton);
		
		JButton NextPageButton = new JButton("Next");
		NextPageButton.setBounds(281, 1, 86, 28);
		HelpPageButtons.add(NextPageButton);
		
		JLabel PageText = new JLabel("0/0");
		PageText.setForeground(Color.WHITE);
		PageText.setBounds(159, 0, 49, 28);
		HelpPageButtons.add(PageText);
		PageText.setHorizontalAlignment(SwingConstants.CENTER);
		PageText.setFont(new Font("High Tower Text", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("graphics/game_Background_help.png"));
		lblNewLabel_2.setBounds(0, 0, 434, 306);
		HelpPanel.add(lblNewLabel_2);
		
		btnNewButton_1.addMouseListener(new MouseAdapter() { // help button on main menu
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPanel.setVisible(false);
				HelpPanel.setVisible(true);
				Help1.setVisible(true);
				helpPageNum = 0;
				PageText.setText((helpPageNum + 1) + "/" + HelpInfoPanel.getComponentCount());
			}
		});
		
		HelpBackButton.addMouseListener(new MouseAdapter() { // back button in help menu
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPanel.setVisible(true);
				HelpPanel.setVisible(false);
			}
		});
		
		for(int i = 0; i < HelpInfoPanel.getComponentCount(); i++)
		{
			helpPages[i] = (JScrollPane)HelpInfoPanel.getComponent(i);
			helpPages[i].setVisible(false);
		}
		NextPageButton.addMouseListener(new MouseAdapter() { // next page button in help panel
			@Override
			public void mouseClicked(MouseEvent e) {
				if(helpPageNum < HelpInfoPanel.getComponentCount() - 1)
				{
					helpPageNum++;
					helpPages[helpPageNum - 1].setVisible(false);
					helpPages[helpPageNum].setVisible(true);
					PageText.setText((helpPageNum + 1) + "/" + HelpInfoPanel.getComponentCount());
				}
				
				else if(helpPageNum == HelpInfoPanel.getComponentCount() - 1)
				{
					helpPages[helpPageNum].setVisible(false);
					helpPageNum = 0;
					helpPages[helpPageNum].setVisible(true);
					PageText.setText((helpPageNum + 1) + "/" + HelpInfoPanel.getComponentCount());
				}
			}
		});
		
		PrevPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!(helpPageNum == 0))
				{
					helpPageNum--;
					helpPages[helpPageNum].setVisible(true);
					helpPages[helpPageNum + 1].setVisible(false);
					PageText.setText((helpPageNum + 1) + "/" + HelpInfoPanel.getComponentCount());
				}
				
				else if(helpPageNum == 0)
				{
					helpPages[helpPageNum].setVisible(false);
					helpPageNum = 2;
					helpPages[helpPageNum].setVisible(true);
					PageText.setText((helpPageNum + 1) + "/" + HelpInfoPanel.getComponentCount());
				}
			}
		});
		
		HelpPanel.setVisible(false);
	}
}