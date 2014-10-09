package chatbot.model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * The Chatbot Model Class. Used for checking and manipulating strings.
 * 
 * @author Zack Moss
 * @version 1.2 10/9/14
 */
public class Chatbot
{
	private ArrayList<String> memeList;
	private String name;
	private int chatCount;

	/**
	 * Creates a Chatbot object with the supplied name and initializes the
	 * current number of chats to 0
	 * 
	 * @param name
	 *            The supplied name for the Chatbot
	 */
	public Chatbot(String name)
	{
		memeList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		fillTheMemeList();
	}

	/**
	 * Returns the name of the Chatbot Object
	 * 
	 * @return The current name of the Chatbot
	 */

	public String getName()
	{
		return name;
	}

	/**
	 * Returns the number of chats
	 * 
	 * @return The current number of chats
	 */

	public int getChatCount()
	{
		return chatCount;
	}

	/**
	 * Sets the name of the Chatbot
	 * 
	 * @param name The name of the Chatbot
	 */

	public void setName(String name)
	{
		this.name = name;
	}

	private void fillTheMemeList()
	{
		memeList.add("kitties");
		memeList.add("food");
		memeList.add("one does not simply");
		memeList.add("fail");
		memeList.add("use the force you must");
		memeList.add("skittles");
	}

	/**
	 * Processes input from the user against the checker methods. Returns the
	 * next output for the view.
	 * 
	 * @param currentInput
	 *            The supplied text.
	 * @return The processed text based on the checker or other methods.
	 */

	public String processText(String currentInput)
	{
		String result = "";

		int randomPosition = (int) (Math.random() * 3);
		if (currentInput != null)
		{
			if (randomPosition == 0)
			{
				if (stringChecker(currentInput))
				{
					result = "too long";
				}
				else
				{
					result = "short words";
				}
			}
			else if (randomPosition == 1)
			{
				if (contentChecker(currentInput))
				{
					result = "yup you know the secret";
				}
				else
				{
					result = "try again another time";
				}
			}
			else
			{
				if (memeChecker(currentInput))
				{
					result = "Wow, " + currentInput + " is a meme, wahoo!";
				}
				else
				{
					result = "Not a meme, try again";
				}
			}
		}
			else
			{
				result = "use words!";
			}

		return result;
	}


	/**
	 * Updates the Chatcount by 1 each chat to keep count of the amount of chats
	 */

	private void updateChatCount()
	{
		chatCount++;
	}

	/**
	 * Checks the length of the string and responds
	 * 
	 * @param input
	 *            the user's response
	 * @return the value depending on the length of the string.
	 */
	public boolean stringChecker(String input)
	{
		boolean stringTooLong = false;

		if (input != null && input.length() >= 20)
		{
			stringTooLong = true;
			JOptionPane.showMessageDialog(null, "Why are you typing so much!");
		}
		return stringTooLong;
	}

	public boolean memeChecker(String input)
	{
		boolean isAMeme = false;

		for (String currentMeme : memeList)
		{
			if (input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}

		/*
		 * Or this loop could be used as well: (for notes) for(int loopCounter =
		 * 0; loopCounter < memeList.size(); loopCounter++) {
		 * if(input.equalsIgnoreCase(memeList.get(loopCOunter))) { isAMeme =
		 * true; } }
		 */
		return isAMeme;
	}

	/**
	 * Checks to see if the user input is a topic of interest
	 * 
	 * @param input
	 *            the user's input that is part of a topic of interest
	 * @return true for a topic of interest was found
	 */
	public boolean contentChecker(String input)
	{
		boolean isTopicOfInterest = false;

		if (input != null && input.toLowerCase().contains("soccer"))
		{
			isTopicOfInterest = true;
		}

		return isTopicOfInterest;
	}

	/**
	 * Checks to see if it is ok to quit the application.
	 * 
	 * @param input
	 *            The input that allows the application to quit
	 * @return the value for being able to quit.
	 */

	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input != null && input.equalsIgnoreCase("Sayonara"))
		{
			okToQuit = true;
		}

		return okToQuit;
	}
}
