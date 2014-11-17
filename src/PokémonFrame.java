import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.*;


public class PokémonFrame extends JFrame {
	JPanel outerPanel = new JPanel(new CardLayout());
	JPanel loginPanel = new JPanel();
	
	CardLayout cl = (CardLayout)(outerPanel.getLayout());

	public PokémonFrame() {
		super("Pokémon");
		setSize(800,720);
		setLocation(300, 100);
		setMinimumSize(new Dimension(800,720));
		setMaximumSize(new Dimension(800, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createLoginPanel();
		
		outerPanel.add(loginPanel, "Login");
		add(outerPanel);
		cl.first(outerPanel);
	
		
		setVisible(true);
	}
	private void createLoginPanel() {
		loginPanel.setLayout(new BorderLayout());
		JButton loginButton = new JButton("Login");
		loginButton.setLocation(400, 400);

		JButton registerButton = new JButton("Sign Up");
		registerButton.setLocation(400, 500);
		
        ImageIcon logo = new ImageIcon("./src/images/logo.jpg");
        JLabel imageLabel = new JLabel( logo );
        imageLabel.setLocation(10, 200);
        
        loginPanel.add(loginButton);
        loginPanel.add(registerButton);
        loginPanel.add(imageLabel);
	}
        
        
     
	public static void main (String args []){
		new PokémonFrame();
	}
}
