package psi.componentwise.eval;
/**
 * Employee.java - a simple class for regulating employees
 * @author	Greg Smith
 * @version 1.7
 */
import java.util.Date;

public class Employee {

	private String name;
	private boolean managerFlag;
	private boolean partTimeFlag;
	private int id;
	private Date dateHired;
	
	/**
	 * Employee class constructor
	 */
	public Employee(String name, boolean managerFlag, boolean partTimeFlag, int id, Date dateHired)	{
		this.name = name;
		this.managerFlag = managerFlag;
		this.partTimeFlag = partTimeFlag;
		this.id = id;
		this.dateHired = dateHired;
	}

	/**
	 * Retrieve Employee name
	 * @return String variable
	 */
	public String getName()	{
		return name;
	}
	
	/**
	 * Retrieve Employee ID
	 * @return String variable
	 */
	public String getID()	{
		return Integer.toString(id);
	}
	
	/**
	 * Retrieve Employee manager status
	 * @return boolean variable
	 */
	public boolean isManger()	{
		return managerFlag;
	}
	
	/**
	 * Retrieve Employee date of hire
	 * @return Date variable
	 */
	public Date getDateHired()	{
		return dateHired;
	}
	
	/**
	 * Retrieve Employee part time status
	 * @return boolean
	 */
	public boolean isPartTime()	{
		return partTimeFlag;
	}
	
}
