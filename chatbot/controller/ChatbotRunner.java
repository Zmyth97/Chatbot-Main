package chatbot.controller;

public class ChatbotRunner 
{
	
	/**
	 * The Runner of the App. Runs the App
	 * @param args
	 */
	
	public static void main(String [] args)
	{
		ChatbotAppController appController = new ChatbotAppController();
		appController.start();
	}

}
