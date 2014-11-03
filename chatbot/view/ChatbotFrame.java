package chatbot.view;

import java.awt.Color;
import javax.swing.JFrame;
import chatbot.controller.ChatbotAppController;

/**
 * GUI Frame Class for a Chatbot. Shows the basic framework code for a JFrame extension.
 * @author Zack Moss
 * @version 1.1
 */
public class ChatbotFrame extends JFrame
{
	/**
	 * Reference for the ChatbotPanel of GUI.
	 */
	private ChatbotPanel basePanel;
	
	/**
	 * Creates a ChatbotFrame with a reference to the ChatbotAppController to pass to the panel for MVC.
	 * @param baseController The reference to the controller object.
	 */
	public ChatbotFrame(ChatbotAppController baseController) 
	{
		basePanel = new ChatbotPanel(baseController);
		
		setupFrame();
	}
	
	/**
	 * Helper method to load panel into frame, set size, and visibility.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500, 300);
		this.setResizable(false);
		setVisible(true);
	}

}
