package chatbot.model;

/**
 * Stores the User Information
 * 
 * @author Zack Moss
 * @version 1.1
 */
public class ChatbotUser
{
	/**
	 * The string of the user's name
	 */
	private String userName;
	/**
	 * The amount of girls they have kissed
	 */
	private int girlsKissed;
	/** 
	 * Boolean for if the user likes to play soccer
	 */
	private boolean likesSoccer;
	/**
	 * The Boolean for if the user likes to make out
	 */
	private boolean likesToMakeOut;

	/**
	 * Sets the initial values for each user data member
	 */
	public ChatbotUser()
	{
		this.userName = "";
		this.girlsKissed = -1;
		this.likesSoccer = false;
		this.likesToMakeOut = false;
	}

	/**
	 * Sets the user Name
	 * @param userName The user's Name
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	/**
	 * Sets the amount of girls the user has kissed
	 * @param girlsKissed The amount of girls the user has kissed
	 */
	public void setGirlsKissed(int girlsKissed)
	{
		this.girlsKissed = girlsKissed;
	}

	/**
	 * Sets if the user likes soccer or not
	 * @param likesSoccer Whether he likes soccer or not
	 */
	public void setLikesSoccer(boolean likesSoccer)
	{
		this.likesSoccer = likesSoccer;
	}

	/**
	 * Sets whether the user likes to make out or not
	 * @param likesToMakeOut If the user likes to make out or not
	 */
	public void setLikesToMakeOut(boolean likesToMakeOut)
	{
		this.likesToMakeOut = likesToMakeOut;
	}

	/**
	 * Gets the user's name
	 * @return the user's name
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * Gets the amount of girls the user has kissed
	 * @return the amount of girls the user has kissed
	 */
	public int getGirlsKissed()
	{
		return girlsKissed;
	}

	/**
	 * Gets if the user likes soccer or not
	 * @return if the user likes soccer or not
	 */
	public boolean isLikesSoccer()
	{
		return likesSoccer;
	}

	/**
	 * Gets if the user likes to make out or not
	 * @return if the user likes to make out or not
	 */
	public boolean isLikesToMakeOut()
	{
		return likesToMakeOut;
	}

}
