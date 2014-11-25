package chatbot.model;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * The Chatbot Model Class. Used for checking and manipulating strings.
 * 
 * @author Zack Moss
 * @version 1.4 11/11/14 Updated proccessText and added a checker
 */
public class Chatbot
{
	private ArrayList<String> memeList;
	private ArrayList<String> userInputList;
	private String name;
	private int chatCount;
	private ChatbotUser myUser;

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
		userInputList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		myUser = new ChatbotUser();
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
	 * Gets the User info in Chatbot User
	 * 
	 * @return the user
	 */
	public ChatbotUser getMyUser()
	{
		return myUser;
	}

	/**
	 * Sets the User info in Chatbot User
	 * 
	 * @param the user
	 */
	public void setMyUser(ChatbotUser myUser)
	{
		this.myUser = myUser;
	}

	/**
	 * Sets the name of the Chatbot
	 * 
	 * @param name
	 *            The name of the Chatbot
	 */

	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Fills the meme list
	 */
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
	 * next output for the view. Also asks and stores the information about the
	 * user.
	 * 
	 * @param currentInput
	 *            The supplied text.
	 * @return The processed text based on the checker or other methods.
	 */

	public String processText(String currentInput)
	{
		String result = "";
		if (getChatCount() < 4)
		{
			result = introduceUser(currentInput);
		}
		else if (getChatCount() > 4 && getChatCount() < 7)
		{
			result = talkAboutUser(currentInput);

		}
		else if (currentInput != null && currentInput.length() > 0)
		{
			result = randomChatConversation(currentInput);

		}
		else
		{
			result = "use words!";
			chatCount--;
		}
		updateChatCount();
		return result;
	}

	/**
	 * Part of process text that asks about the user for later
	 * @param input
	 * @return
	 */
	private String introduceUser(String input)
	{
		String userQuestion = "";

		if (getChatCount() < 4)
		{
			if (getChatCount() == 0)
			{
				myUser.setUserName(input);
				userQuestion = "How many girls have you kissed?";
			}
			else if (getChatCount() == 1)
			{
				try
				{
					myUser.setGirlsKissed(Integer.parseInt(input));
				}
				catch (NumberFormatException p)
				{
					return "Sorry, didn't catch that. How many girls have you kissed?";
				}
				userQuestion = "Thats a lot! Do you like Soccer? (Yes/No)";
			}
			else if (getChatCount() == 2)
			{
				myUser.setLikesSoccer(input.toLowerCase().startsWith("y") ? true : false);
				userQuestion = myUser.isLikesSoccer() ? "That's great me too! " : "That's too bad... ";
				userQuestion = userQuestion.concat("Do you like to make out with girls?");
			}
			else if (getChatCount() == 3)
			{
				myUser.setLikesToMakeOut(input.toLowerCase().startsWith("y") ? true : false);
				userQuestion = "Very nice. Just be careful out there......";
			}
		}

		return userQuestion;
	}

	/**
	 * Part of process text that randomly talks about the user
	 * @param input
	 * @return Conversation about the user
	 */
	private String talkAboutUser(String input)
	{
		String talkAbout = "";
		
			if (getChatCount() == 4)
			{
				talkAbout = "Why did you parents name you " + myUser.getUserName() + "?";
			}
			if (getChatCount() == 9)
			{
				if (myUser.getGirlsKissed() == 0)
				{

					talkAbout = "You haven't kissed any girls? Why not!";
				}
				else if (myUser.getGirlsKissed() >= 0)
				{

					talkAbout = "You've only kissed " + myUser.getGirlsKissed() + " girls? You should kiss more!";
				}
			}
			if (getChatCount() == 5)
			{
				if (myUser.isLikesSoccer() == true)
				{
					talkAbout = "What do you like about soccer?";
				}
				else
				{
					talkAbout = "I\'m sorry, but you\'re a horrible human. Why don't you like soccer?";
				}
			}
			if (getChatCount() == 6)
			{
				if (myUser.isLikesToMakeOut() == true)
				{
					talkAbout = "So...you like to make out? Who do you make out with?";
				}
				else
				{
					talkAbout = "So, I bet the only reason you don't like to make out with girls is because you haven't yet ;)";
				}
			}
		return talkAbout;
	}
	
	/**
	 * Takes the user input and randomly checks it against the 3 checkers
	 * @param input
	 * @return
	 */
	private String randomChatConversation(String input)
	{
		String conversation = "";

			int randomPosition = (int) (Math.random() * 6);

			if (randomPosition == 0)
			{
				if (stringChecker(input))
				{
					conversation = "too long";
				}
				else
				{
					conversation = "short words";
				}
			}
			else if (randomPosition == 1)
			{
				if (contentChecker(input))
				{
					conversation = "yup you know the secret";
				}
				else
				{
					conversation = "try again another time";
				}
			}
			else if (randomPosition == 2)
			{
				if (memeChecker(input))
				{
					conversation = "Wow, " + input + " is a meme, wahoo!";
				}
				else
				{
					conversation = "Not a meme, try again";
				}
			}
			else if (randomPosition == 3)
			{
				// Add to list
				if (userInputChecker(input))
				{
					userInputList.add(input);
					conversation = "Thank you for the comment";
				}
				else if (randomPosition == 4)
				{
					if(mashChecker(input))
					{
						conversation = mashingDetected(input);
					}
					else
					{
						conversation = noMashingDetected(input);
					}
				}

				else
				{
					if (userInputChecker(input))
					{
						conversation = "That was nice - you removed it from the list";
					}
					else
					{
						conversation = "That wasn't in the conversation before";
					}
				}

			}
		return conversation;
	}
	
	private String mashingDetected(String input)
	{
		String mashed = "";
		
		mashed = input.substring(input.length()/2);
		mashed += input.substring(input.length()/2);
		mashed += input.substring(input.length()/2);
		mashed += input.substring(input.length()/2);
		mashed += input.substring(input.length()/2);
		
		return mashed;
	}
	
	private String noMashingDetected(String input)
	{
		String noMashing = "Thank you for not mashing your keyboard with ";
		if (input.length() > 1)
		{
		noMashing += input.substring(input.length()/3, input.length()/2);
		}
		
		return noMashing;
	}
	
	/**
	 * Checker for keyboard mashing
	 * @param userInput The user supplied text
	 * @return Whether mashing has been detected
	 */
	public boolean mashChecker(String userInput)
	{
		boolean isMashing = false;
		
		if (userInput.indexOf("sdf") > -1)
		{
			isMashing = true;
		}
			
		
		return isMashing;
	}

	/**
	 * Updates the Chatcount by 1 each chat to keep count of the amount of chats
	 */

	private void updateChatCount()
	{
		chatCount++;
	}

	private boolean userInputChecker(String userInput)
	{
		boolean matchesInput = false;

		for (int loopCount = 0; loopCount < userInputList.size(); loopCount++)
		{
			if (userInput.equalsIgnoreCase(userInputList.get(loopCount)))
			{
				matchesInput = true;
				userInputList.remove(loopCount);
				loopCount--; // Test Questions on this!!!
			}
		}

		return matchesInput;
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

	/**
	 * Checks the user's response for memes
	 * 
	 * @param input
	 *            The user's response
	 * @return the value, true or false
	 */
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

		if (input != null && (input.toLowerCase().contains("soccer") || input.toLowerCase().contains("Kody")))
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
