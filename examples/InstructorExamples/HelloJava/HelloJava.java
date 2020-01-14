
/**
 * This file contains a small amount of "code" - instructions that make up a Java
 * program - and a large amount of text in "comments" that are completely ignored
 * by the computer, but invaluable to human beings for making sense of code. It
 * is not common to have so much explanation for code, but this is all for
 * instructional purposes and it doesn't affect the code in the slightest.
 * 
 * This particular kind of comment is called a "Javadoc comment." Javadocs are
 * special comments that describe (usually) classes and methods and can be used to
 * generate nicely formatted web page documentation for programs. All classes and
 * methods should be accompanied by a Javadoc comment that comes immediately above
 * the class or method header it describes.
 * 
 * If you look below this comment, you will see the line "public class HelloJava".
 * That line is the "class header" for class HelloJava. Notice that the name of
 * this file is "HelloJava.java" - exactly the same as the name of the class. That
 * is a requirement. A class must be defined in a .java file with exactly the same
 * name.
 * 
 * A class usually represents a "thing" or kind of thing that is part of the program.
 * One class in each program actually represents the program, itself. HelloWorld is
 * such a class. Other classes may represent things that the program needs.
 * 
 * The "body" of a class begins with an open curly brace and ends with a close
 * curly brace { }. Everything inside that open-close pair belongs to the class.
 * This class contains one method - main(). A class may contain many methods and
 * other elements that you will see in other examples.
 * 
 * A method is a named set of related statements to do a job or provide a service.
 * Some methods may be defined in the class you're looking at, but many will belong
 * to classes coming from other files and written by other people. You will have to
 * get used to the idea that you're never seeing everything and that is okay!
 * 
 * @author mvail
 */
public class HelloJava 
{

	/**
	 * Every program has to begin somewhere and that somewhere is the main() method.
	 * A class that contains main() and provides a starting point for a program is
	 * called a "driver class." HelloJava has a main() method and is, therefore, a
	 * driver class. You could say that the HelloJava class represents a program called
	 * HelloJava.
	 * 
	 * Look at the "method header" below. main() is preceded by several key words that
	 * describe where it can be seen (public), whether it belongs to a specific object
	 * of type HelloJava or is independent of any particular object (static - meaning
	 * it doesn't belong to any object), and what it is expected to return (void - 
	 * meaning it doesn't return anything when it is finished). Inside the parentheses
	 * that follow the name of the method is its list of "formal parameters." Some 
	 * methods have no parameters, some have many parameters, but main() has exactly 
	 * one: an array of Strings (String[]) called args. We will not use this parameter
	 * for a while, but a valid main() is required to expect it.
	 *   
	 * Like a class, a method body begins with an open curly brace and ends with a
	 * close curly brace - { }. Anything inside these curly braces belongs to the method.
	 * This main() contains a single statement, but methods may contain any number of
	 * statements.
	 * 
	 * @param args unused for now
	 */
	public static void main( String[] args )
	{
		/*
		 * The statement below is a single call to a println() method belonging to
		 * a class called System.out that is connected to a text console. The
		 * println() method, pronounced "print line", does what its name suggests:
		 * it prints its parameter to the console and then moves to the next line.
		 * In println()'s parentheses, we are passing it some text as a parameter
		 * in double-quotes.
		 * 
		 * Text in double quotes is called a "String literal". We will eventually
		 * come back to Strings in more detail, but for now you simply need to know
		 * that text must be in double-quotes. If you noticed that "String" looks
		 * like the same kind of thing main() was expecting as a parameter, you are
		 * correct. It is also not a coincidence that String is capitalized, like
		 * HelloWorld and System. Like these, String is the name of a class and
		 * defines methods of its own.
		 * 
		 * A statement in Java is an instruction. You can also think of statements
		 * as being similar to one sentence in any other written language. It is
		 * like one unit of communication - one complete thought. Like a sentence,
		 * we indicate the end of a statement with a piece of punctuation - a
		 * semicolon.
		 * 
		 * You may have noticed (if not, do so now) that this comment isn't exactly
		 * like the comments above HelloJava or main(). Javadoc comments are not
		 * appropriate inside of a method, so this is a regular "block comment." It
		 * begins with a slash and single asterisk /*.
		 */
		System.out.println( "Hello Java!" );

	}

}
