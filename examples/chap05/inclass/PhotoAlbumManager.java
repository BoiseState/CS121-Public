package inclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The PhotoAlbumManager uses (depends on) the PhotoAlbum class.
 * Note that this could also be an aggregate class that has a PhotoAlbum.
 * 
 * How could we make this easier to read/maintain through better method
 * design?
 * 
 * @author CS121 Instructors
 */
public class PhotoAlbumManager
{
	/**
	 * Runs the program and handles all the menu options.
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.println("===========================");
		System.out.println("Welcome!");
		System.out.println("===========================");

		PhotoAlbum album = null;
		String option = "";
		
		while(album == null)
		{
			System.out.println("You must create an album to get started.");
			System.out.println("---------------------------");
			System.out.println("(f) load album from file");
			System.out.println("(n) create new album");
			System.out.println("---------------------------");
			System.out.print("Choose an option: ");
			option = scan.nextLine().trim();
			switch(option)
			{
				case "f":
					album = loadPhotoAlbum("inclass/album.txt");
					break;
				case "n":
					System.out.print("Photo album name: ");
					String name = scan.nextLine().trim();
					album = new PhotoAlbum(name);
					break;
				default:
					System.out.println("Invalid option.");
					break;
			}
		}

		System.out.println("Photo album added.");
		System.out.println(album);

		while(!option.equalsIgnoreCase("q"))
		{
			System.out.print("What do you want to do (type 'm' to show menu)? ");
			option = scan.nextLine().trim();

			switch(option)
			{
				case "m":
					printMenu();
					break;
				case "p":
					if(album.getNumPhotos() > 0) {
						System.out.println(album);
						System.out.print("Choose a photo id: ");
						int id = Integer.parseInt(scan.nextLine().trim());
						Photo photo = album.getPhoto(id);
						System.out.println("Photo " + id + ": " + photo);
					} else {
						System.out.println("Album is empty.");
					}
					break;
				case "a":
					Photo photo = readPhoto(scan);
					album.addPhoto(photo);
					System.out.println("Added photo: " + photo.getDescription());
					break;
				case "d":
					if(album.getNumPhotos() > 0) {
						System.out.println(album);
						System.out.print("Choose a photo id: ");
						int id = Integer.parseInt(scan.nextLine().trim());
						Photo removed = album.removePhoto(id);
						System.out.println("Removed photo: " + removed);
					} else {
						System.out.println("Photo Album is empty.");
					}
					break;
				case "l":
					System.out.println();
					System.out.println(album);
					break;
				case "q":
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid option.");
					break;
			}
		}
	}
	
	
	private static void printMenu()
	{
		System.out.println("(p) print photo");
		System.out.println("(l) list photos");
		System.out.println("(a) add photo");
		System.out.println("(d) delete photo");
		System.out.println("(q) quit");
	}
	
	/**
	 * Reads photo information from the user (via the scanner) and
	 * creates a new Photo object.
	 *
	 * @param scan The input scanner to read from.
	 * @return The new photo.
	 */
	public static Photo readPhoto(Scanner scan)
	{
		System.out.print("Enter description: ");
		String description = scan.nextLine().trim();

		System.out.print("Enter file name: ");
		String file = scan.nextLine().trim();
		
		System.out.print("Enter rating (1 - 5): ");
		int rating = Integer.parseInt(scan.nextLine().trim());

		Photo photo = new Photo(description, file, rating);
		return photo;
	}
	
	/**
	 * Loads a new photo album from a given file.
	 * @param filename The name of the file to read the photos from.
	 * @return A new album containing photos with the attributes given in the file.
	 */
	public static PhotoAlbum loadPhotoAlbum(String filename)
	{
		PhotoAlbum album = null;
		try {
			Scanner scan = new Scanner(new File(filename));
			String albumName = scan.nextLine().trim();
			album = new PhotoAlbum(albumName);
			while(scan.hasNextLine()) {
				String description = scan.nextLine().trim();
				String file = scan.nextLine().trim();
				int rating = Integer.parseInt(scan.nextLine().trim());

				album.addPhoto(new Photo(description, file, rating));
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.err.println("Failed to load album. " + e.getMessage());
		}
		return album;
	}
}
