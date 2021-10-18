package exceptions;
/**
 * 
 * @author 835489,563621
 * Used to catch tree issues.
 *
 */
public class TreeException extends Exception {
	public TreeException()
	{
		super();
	}

	/**
	 * @param message error message specific to cause of error.
	 */
	public TreeException(String message)
	{
		super(message);
	}
}
