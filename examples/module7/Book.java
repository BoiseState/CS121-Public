import java.util.Date;

/**
 * @author amit
 * 
 */
public class Book
{
	private String title;
	private String author;
	private Date pubDate;

	/**
	 * Create a book object
	 * 
	 * @param title
	 * @param author
	 * @param pubDate
	 */
	public Book(String title, String author, Date pubDate)
	{
		this.title = title;
		this.author = author;
		this.pubDate = pubDate;
	}

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor()
	{
		return author;
	}

	/**
	 * @param author  the author to set
	 */
	public void setAuthor(String author)
	{
		this.author = author;
	}

	/**
	 * @return the pubDate  the publication date
	 */
	public Date getPubDate()
	{
		return pubDate;
	}

	/**
	 * @param pubDate   the publication date to set
	 */
	public void setPubDate(Date pubDate)
	{
		this.pubDate = pubDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Book [" + (author != null ? "author=" + author + ", " : "")
				+ (pubDate != null ? "pubDate=" + pubDate + ", " : "")
				+ (title != null ? "title=" + title : "") + "]";
	}
	
	

}
