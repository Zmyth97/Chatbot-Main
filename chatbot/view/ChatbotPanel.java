package chatbot.view;

import java.awt.Color;

import chatbot.controller.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * The Interface Design and View, communicates with the base controller.
 * @author Zack Moss
 * @version 1.1
 */
public class ChatbotPanel extends JPanel
{
	/**
	 * Reference for Chatbot Controller
	 */
	private ChatbotAppController baseController;
	
	/**
	 * Establishes the different interface objects
	 */
	private JButton firstButton;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private JLabel lblCopyrightOfZack;
	private JTextField chatField;
	
	/**
	 * The constructor of the panel class, instantiates the different components
	 * @param baseController The reference to the controller object
	 */
	public ChatbotPanel(final ChatbotAppController baseController) 
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		firstButton = new JButton("Click the Button to Chat!");
		firstButton.setBackground(new Color(153, 153, 153));
	    chatArea = new JTextArea();
	    chatArea.setBackground(Color.LIGHT_GRAY);
	    chatPane = new JScrollPane(chatArea);
	    
	    setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	/**
	 * Sets up the pane (doh)
	 */
	private void setupPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
	/**
	 * Sets up the panel (doh)
	 */
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(chatPane);
		
	}
	
	/**
	 * Contains the different layout code that sets up the interface. 
	 */
	private void setupLayout()
	{
	    JLabel lblWelcomeToThe = new JLabel("Welcome to the Chatbot 2.0!");
	    baseLayout.putConstraint(SpringLayout.NORTH, lblWelcomeToThe, 37, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 12, SpringLayout.SOUTH, lblWelcomeToThe);
		baseLayout.putConstraint(SpringLayout.EAST, lblWelcomeToThe, 406, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, lblWelcomeToThe, 49, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 110, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -118, SpringLayout.EAST, this);
	    baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 286, SpringLayout.NORTH, this);
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblWelcomeToThe.setForeground(new Color(255, 255, 255));
		lblWelcomeToThe.setBackground(new Color(255, 51, 51));
		add(lblWelcomeToThe);
		
		setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		
		lblCopyrightOfZack = new JLabel("Copyright of Zack Moss/Canyons Tech Center");
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, -109, SpringLayout.NORTH, lblCopyrightOfZack);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, -21, SpringLayout.NORTH, lblCopyrightOfZack);
		lblCopyrightOfZack.setForeground(new Color(255, 255, 255));
		baseLayout.putConstraint(SpringLayout.WEST, lblCopyrightOfZack, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, lblCopyrightOfZack, 0, SpringLayout.SOUTH, this);
		add(lblCopyrightOfZack);
		
		chatField = new JTextField();
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 0, SpringLayout.WEST, chatField);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, 0, SpringLayout.EAST, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 53, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatField, -124, SpringLayout.NORTH, lblCopyrightOfZack);
		baseLayout.putConstraint(SpringLayout.EAST, chatField, -49, SpringLayout.EAST, this);
		add(chatField);
		chatField.setColumns(10);
	}
	
	/**
	 * Sets up the listeners and provides references to them
	 */
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String currentInput = chatField.getText();
				String result = baseController.getChatbotDialog(currentInput);
				showTextMessage(currentInput);
				showTextMessage(result);
				chatField.setText("");
			}
		});
	}
	
	public void showTextMessage(String userInput)
	{
		chatArea.append("\n" + userInput);
	}
}
