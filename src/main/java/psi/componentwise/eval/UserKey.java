package psi.componentwise.eval;
/**
 * UserKey.java - a serializable class that contains a user name and ID to be inserted into a hash table
 * @author	Greg Smith
 * @version 1.7 
 */
import java.io.Serializable;

public class UserKey implements Serializable {

	private String name;
	private String userid;

	/**
	 * Constructor
	 * @param name a String variable
	 * @param userid a String variable
	 */
	public UserKey(String name, String userid)	{
		this.name = name;
		this.userid = userid;
	}
	
	/**
	 * Retrieve name String variable
	 * @return a String variable
	 */
	public String getName()	{
		return name;
	}
	
	/**
	 * Retrieve userid String variable
	 * @return a String variable
	 */
	public String getUserID()	{
		return userid;
	}
	
	/**
	 * Simple hash code for checking equality  
	 */
	@Override
	public int hashCode()	{
		return (int) name.hashCode() * userid.hashCode();
	}
	
	/**
	 * Override .equals to ensure functionality between separate objects
	 * @param obj Object variable 
	 */
	@Override
	public boolean equals(Object obj)	{

		// Return true if objects are from same point in memory
		if(obj == this)	{
			return true;
		}

		// Handle null
		if(obj == null)	{
			return false;
		}

		// If object is not a Userkey class
		if(obj.getClass() != this.getClass())	{
			return false;
		}

		// Typecast object to check data 
		UserKey key = (UserKey) obj;
		
		if((key.name != null) && (key.userid != null) && (this.name != null) && (this.userid != null))	{
		
				return (name.equals(key.name)) && (userid.equals(key.userid));
		}
		else return false;
	}
}
