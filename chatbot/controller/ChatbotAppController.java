package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotPanel;

/**
 * Runs the Chatbot Project. Owns the model and associated views.
 * @author Zack Moss
 * @version 1.2 10/2/14
 */

public class ChatbotAppController 
{

	private Chatbot mySillyChatbot;
	private String startMessage;
	private String quitMessage;	
	private ChatbotFrame appFrame;
	
	/**
	 * Constructor for the AppController. Initializes the Model and View Components
	 */
	public ChatbotAppController()
	{
		appFrame = new ChatbotFrame(this);
		mySillyChatbot = new Chatbot("Royal");
		startMessage = "Welcome to the " + mySillyChatbot.getName() + " Chatbot. What is your name?";
		quitMessage = "Goodbye Cruel User :(";
	}
	
	/**
	 * Gets SillyChatbot
	 * @return SillyChatbot
	 */
	public Chatbot getMySillyChatbot()
	{
		return mySillyChatbot;
	}
	
	/**
	 * Main part of program, runs app.
	 */
	
	public void start()
	{
   	    ((ChatbotPanel) appFrame.getContentPane()).showTextMessage(startMessage);
       //	ChatbotPanel testPanel = (ChatbotPanel) appFrame.getContentPane();
       	
	}
	
	/**
	 * Controls the text processing. 
	 * @param input The user response
	 * @return the result after process text
	 */
	public String getChatbotDialog(String input)
	{
		String result = "";
		if(mySillyChatbot.quitChecker(input))
		{
			quit();
		}
		result = mySillyChatbot.processText(input);
			
		return result;
	}
	
	/**
	 * Uses Quit Checker to see if it can quit, and if so, quits the app.
	 */
	private void quit()
	{
		System.exit(0);
	}
}
