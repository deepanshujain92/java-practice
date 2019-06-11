import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private HashMap<String, User> users = new HashMap<>();
	private Set<Book> bookList = new HashSet<>();
	private HashMap<Book, User> booksLoanRegister = new HashMap<>();

	public void registerUser(String userName, String emailId, String firstName, String lastName)
			throws UserAlreadyExistException {
		if (userName != null) {
			if (users.get(userName) == null) {
				User user = new User(userName,firstName, lastName, emailId);
				users.put(userName, user);
			} else
				throw new UserAlreadyExistException("Username "+userName+" already exist");
		}
	}
    
	public User getUser(String userName) {
		return users.get(userName);
	}

	public void activateUser(String userName) {
		User user = getUser(userName);
		user.setActive(true);
	}
	public void addBook(String name,String author,BookCatagory catagory) {
		Book book = new Book(author, name, catagory);
		bookList.add(book);
	}
	private List<Book> getFilterBooksByCatagory(BookCatagory filter) {
		List<Book> result = new ArrayList<>();
		for (Book book : bookList) {
			if (filter.equals(book.getCategory())) {
				result.add(book);
			}
		}
		return result;
	}
	private List<Book> getFilterBooksByAuthor(String filter) {
		List<Book> result = new ArrayList<>();
		for (Book book : bookList) {
			if ((book.getAuthor().toLowerCase().indexOf(filter.toLowerCase())>-1)) {
				result.add(book);
			}
		}
		return result;
	}
	private boolean LoanBook(Book book,User user)
	{
		if(booksLoanRegister.get(book)!=null)
		    return false;
		else 
		   booksLoanRegister.put(book, user);
		   System.out.println("Book "+book.getName()+" has been issued to "+user.getFirstName());
		   return true;
	}
	public void presetup() throws UserAlreadyExistException
	{
		loadUsers();
		loadBooks();
		//approving users for now 
		approveUsers();
	}
	private void loadUsers() throws UserAlreadyExistException {
        registerUser("deepanshu", "Deepanshu", "Jain", "deepanshu.gv@gmail.com");
        registerUser("raj", "raj", "mehta", "raj.mehta@gmail.com");
        registerUser("Murli", "Murli", "HR", "murali.a@gmail.com");
	}
	private void loadBooks() {
		addBook("Noel Markham", "Java Programming Interviews Exposed", BookCatagory.TECHNOLOGY);
		addBook("Gayle Laakmann McDowell", "Cracking the Coding Interview: 189 Programing Questions and Solutions", BookCatagory.TECHNOLOGY);
		addBook("Gayle Laakmann McDowell", "The Google Resume", BookCatagory.TECHNOLOGY);
		addBook("Angelica Banks", "Blueberry Pancakes Forever", BookCatagory.ADVENTURE);
	}
	private void approveUsers()
	{
		activateUser("deepanshu");
	    activateUser("raj");
	}

public static void main(String[] args) throws UserAlreadyExistException {
	Solution s =  new Solution();
	s.presetup();
	List<Book> list = s.getFilterBooksByAuthor("Angelica Banks");
	s.LoanBook(list.get(0),s.getUser("deepanshu"));
	
}	
	
}

class UserAlreadyExistException extends Exception {
	/**
	 * This exception indicates that already there username already exist
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistException(String s) {
		super(s);
	}
}

class User {
	public User(String userName,String firstName, String lastName, String emailId) {
		super();
		this.userName=userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
    //overriding hashcode on the basis of username
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (isActive != other.isActive)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	private String firstName;
	private String userName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	private String lastName;
	private String emailId;
	private boolean isActive;
}

enum BookCatagory {
	SATIRE, DRAMA, ADVENTURE, ROMANTIC, TECHNOLOGY, PHILOSOPHY
}

class Book {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (category != other.category)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	private String author;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BookCatagory getCategory() {
		return category;
	}

	public void setCategory(BookCatagory category) {
		this.category = category;
	}

	private String name;
	private BookCatagory category;

	public Book(String author, String name, BookCatagory category) {
		super();
		this.author = author;
		this.name = name;
		this.category = category;
	}

	
}
