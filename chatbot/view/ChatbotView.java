package chatbot.view;

import javax.swing.JOptionPane;

import chatbot.controller.ChatbotAppController;
/**
 * The Chatbot View Class. Used for controlling the visual aspects of the app.
 * @author Zack Moss
 * @Version 1.1 9/26/14
 */
public class ChatbotView 
{
	/**
	 * Calls the Controller
	 */
	private ChatbotAppController baseController;
	
	/**
	 * Creates a Chatbot View that calls the controller
	 * @param baseController The Controller of the app
	 */
	
	public ChatbotView(ChatbotAppController baseController)
	{
		this.baseController = baseController;
	}
	
	/**
	 * Creates a string from the Chatbot with the availability of user input.
	 * @param currentInput The Supplied String
	 * @return The users typed response
	 */
	
	public String showChatbotDialog(String currentInput)
	{
		String result = "";
		
		result = JOptionPane.showInputDialog(null, baseController.getMySillyChatbot().getName() + " says: " + currentInput);
		
		return result;
	}
	
	/**
	 * Shows a String from the Chatbot as a popup window.
	 * @param currentInput The string from the Chatbot
	 */
	
	public void showChatbotMessage(String currentInput)
	{
		JOptionPane.showMessageDialog(null, baseController.getMySillyChatbot().getName() + " says: " + currentInput);
	}
}
