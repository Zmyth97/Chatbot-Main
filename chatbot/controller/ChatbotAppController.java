package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;

/**
 * Runs the Chatbot Project. Owns the model and associated views.
 * @author Zack Moss
 * @Version 1.2 10/2/14
 */

public class ChatbotAppController 
{
	private ChatbotView applicationView;
	private Chatbot mySillyChatbot;
	private String startMessage;
	private String quitMessage;
	
	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
		mySillyChatbot = new Chatbot("Royal");
		startMessage = "Welcome to the " + mySillyChatbot.getName() + " Chatbot. What is your name?";
		quitMessage = "Goodbye Cruel User :(";
	}
	
	public Chatbot getMySillyChatbot()
	{
		return mySillyChatbot;
	}
	
	/**
	 * Main part of program, runs app.
	 */
	
	public void start()
	{
		String result = applicationView.showChatbotDialog(startMessage);
		mySillyChatbot.stringChecker(result);
		while(!mySillyChatbot.quitChecker(result))
		{
			result = mySillyChatbot.processText(result);
			result = applicationView.showChatbotDialog(result);
		}
			quit();
	}
	/**
	 * Uses Quit Checker to see if it can quit, and if so, quits the app.
	 */
	private void quit()
	{
		applicationView.showChatbotMessage(quitMessage);
		System.exit(0);
	}
}
