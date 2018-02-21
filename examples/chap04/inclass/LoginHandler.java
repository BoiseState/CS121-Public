package inclass;

import java.util.Scanner;

/**
 * Demonstrates use of nested conditionals for verifying user credentials.
 * Note: The idea correct, but it is not a real login handler and is not
 * considered secure.
 * 
 * @author CS121 Instructors
 *
 */
public class LoginHandler
{

	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		
		System.out.print("Username: ");
		String username = kbd.nextLine();
		
		if(username.equals("snoopy"))
		{
			System.out.print("Password: ");
			String password = kbd.nextLine();
			
			if(password.equals("iL0v3tr3@ts"))
			{
				System.out.println("Welcome " + username);
			}
			else
			{
				System.out.println("Invalid password.");
			}
		}
		else
		{
			System.out.println("Invalid username.");
		}
		kbd.close();
	}
}