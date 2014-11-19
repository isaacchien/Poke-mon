import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class PokémonFrame extends JFrame {
	JPanel outerPanel = new JPanel(new CardLayout());

	// INSTANTIATE CARDS
	JPanel loginPanel = new JPanel();
	JPanel startPanel = new JPanel();
	JPanel menuPanel = new JPanel();
	
	CardLayout cl = (CardLayout)(outerPanel.getLayout());
	
    ImageIcon logo = new ImageIcon("./src/images/logo.jpg");


	public PokémonFrame() {
		super("Pokémon");
		setSize(800,720);
		setLocation(300, 100);
		setMinimumSize(new Dimension(800,720));
		setMaximumSize(new Dimension(800, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// CREATE CARD FUNCTIONS
		createStartPanel();
		createLoginPanel();
		createMenuPanel();
		
		
		// ADD CARDS TO OUTERPANEL
		outerPanel.add(menuPanel, "Main Menu");
		outerPanel.add(startPanel, "Start");
		outerPanel.add(loginPanel, "Login");
		add(outerPanel);
		cl.show(outerPanel, "Start");
	
		
		setVisible(true);
	}
	private void createMenuPanel() {
		JButton choose = new JButton("Choose Pokémon"); 
		JButton store = new JButton("Go to item store"); 
		JButton bag = new JButton("View Bag"); 
		JButton join = new JButton("Join Game");
		JButton view = new JButton("View Game"); 
		JButton chat = new JButton("Chat"); 
		
		JLabel logoLabel = new JLabel(logo); 
		logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
		menuPanel.add(logoLabel); 
		
		choose.setSize(800, this.getHeight()/10);
		choose.setMaximumSize(choose.getSize());
		choose.setAlignmentX(Component.CENTER_ALIGNMENT); 
	
		store.setSize(this.getWidth(), this.getHeight()/10);
		store.setMaximumSize(store.getSize());
		store.setAlignmentX(Component.CENTER_ALIGNMENT); 
		bag.setSize(this.getWidth(), this.getHeight()/10);
		bag.setMaximumSize(bag.getSize());
		bag.setAlignmentX(Component.CENTER_ALIGNMENT); 
		join.setSize(this.getWidth(), this.getHeight()/10);
		join.setMaximumSize(join.getSize());
		join.setAlignmentX(Component.CENTER_ALIGNMENT); 
		view.setSize(this.getWidth(), this.getHeight()/10);
		view.setMaximumSize(view.getSize());
		view.setAlignmentX(Component.CENTER_ALIGNMENT); 
		chat.setSize(this.getWidth(), this.getHeight()/10);
		chat.setMaximumSize(chat.getSize());
		chat.setAlignmentX(Component.CENTER_ALIGNMENT); 
		
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		menuPanel.add(choose); 
		menuPanel.add(store); 
		menuPanel.add(bag); 
		menuPanel.add(join); 
		menuPanel.add(view); 
		menuPanel.add(chat); 
		
		add(menuPanel);
	}
	private void createLoginPanel() {
		loginPanel.setSize(100, 100);
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBorder(new TitledBorder("Login"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(new JLabel("Username:"), gbc);
        gbc.gridy++;
        loginPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        loginPanel.add(new JTextField(10), gbc);
        gbc.gridy++;
        loginPanel.add(new JTextField(10), gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        JButton loginButton = new JButton("Login");
        loginPanel.add(loginButton, gbc);
        gbc.gridx++;
        JButton cancelButton = new JButton("Cancel");
        loginPanel.add(cancelButton, gbc);
        
        // if login successful
        loginButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(outerPanel, "Main Menu");
			}
        });
        cancelButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(outerPanel, "Start");
			}
        });
        
        add(loginPanel);
	}
	private void createStartPanel() {
		startPanel.setLayout(new BorderLayout());
		JButton loginButton = new JButton("Login");
		// if login successful
		loginButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("show login");
				cl.show(outerPanel, "Login");
			}
		});

		JButton registerButton = new JButton("Sign Up");
		registerButton.setLocation(400, 500);
		
        JLabel imageLabel = new JLabel( logo );

        JPanel buttons = new JPanel();
        buttons.add(loginButton);
        buttons.add(registerButton);
        startPanel.add(imageLabel, BorderLayout.NORTH);
        startPanel.add(buttons, BorderLayout.CENTER);
	}
        
        
     
	public static void main (String args []){
		new PokémonFrame();
	}
}
