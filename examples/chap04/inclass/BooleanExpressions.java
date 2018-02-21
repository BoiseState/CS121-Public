package inclass;

/**
 * Demonstrates boolean expressions using comparison
 * and logical operators.
 * 
 * @author CS121 Instructors
 */
public class BooleanExpressions
{
	public static void main(String[] args)
	{
		System.out.println("Is (3 == 3)? " + (3 == 3));
		System.out.println("Is (3 >= 4)? " + (3 >= 4));
		System.out.println("Is (3 != 4)? " + (3 != 4));
		
		int x = 10;
		int y = 20;
		
		boolean result = (x <= y);
		System.out.println("Is (x <= y)? " + result);
		
		// Access to a page is granted if you are logged in AND
		// you have the correct permission.
		boolean loggedIn = true;
		boolean hasPermission = false;
		
		boolean accessGranted = loggedIn && hasPermission;
		System.out.println("Access Granted? " + accessGranted);
		
		
		// Pictures are only visible if you are a friend OR if the
		// picture is flagged as public.
		boolean isFriend = false;
		boolean isPublic = true;
		
		boolean visible = isFriend || isPublic;
		System.out.println("Visible? " + visible);
	}
}
