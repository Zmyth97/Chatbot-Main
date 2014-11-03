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
	public ChatbotPanel(ChatbotAppController baseController) 
	{
		this.baseController = baseController;
		
		firstButton = new JButton("Click the Button to Chat!");
		firstButton.setBackground(new Color(153, 153, 153));
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 110, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -118, SpringLayout.EAST, this);
	    chatPane = new JScrollPane();
	    chatArea = new JTextArea();
	    
	    setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
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
		chatArea = new JTextArea(5, 20);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -49, SpringLayout.EAST, this);
		chatArea.setBackground(new Color(153, 153, 153));
		add(chatArea);
		
	}
	
	/**
	 * Contains the different layout code that sets up the interface. 
	 */
	private void setupLayout()
	{
	    baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 25, SpringLayout.NORTH, this);
	    baseLayout.putConstraint(SpringLayout.WEST, chatPane, 200, SpringLayout.WEST, this);
	    JLabel lblWelcomeToThe = new JLabel("Welcome to the Chatbot 2.0!");
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, lblWelcomeToThe);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 12, SpringLayout.SOUTH, lblWelcomeToThe);
		baseLayout.putConstraint(SpringLayout.EAST, lblWelcomeToThe, 406, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, lblWelcomeToThe, 10, SpringLayout.SOUTH, chatPane);
		baseLayout.putConstraint(SpringLayout.WEST, lblWelcomeToThe, 49, SpringLayout.WEST, this);
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblWelcomeToThe.setForeground(new Color(255, 255, 255));
		lblWelcomeToThe.setBackground(new Color(255, 51, 51));
		add(lblWelcomeToThe);
		
		setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		
		lblCopyrightOfZack = new JLabel("Copyright of Zack Moss/Canyons Tech Center");
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -6, SpringLayout.NORTH, lblCopyrightOfZack);
		lblCopyrightOfZack.setForeground(new Color(255, 255, 255));
		baseLayout.putConstraint(SpringLayout.WEST, lblCopyrightOfZack, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, lblCopyrightOfZack, 0, SpringLayout.SOUTH, this);
		add(lblCopyrightOfZack);
		
		chatField = new JTextField();
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 4, SpringLayout.WEST, chatArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatField, -24, SpringLayout.NORTH, chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatArea);
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
