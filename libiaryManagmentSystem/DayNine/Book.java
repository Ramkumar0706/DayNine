package libiaryManagmentSystem.DayNine;

public class Book {
	
	private int isbn;
	private String titie;
	private String author;
	private String publisher;
	private int year;
	
	public Book(int isbn, String titie, String author, String publisher, int year) {
		this.isbn = isbn;
		this.titie = titie;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
	}
	
	public int getIsbn() {
		return isbn;
	}
	
	public String getTitie() {
		return titie;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", titie=" + titie + ", author=" + author + ", publisher=" + publisher + ", year="
				+ year + "]";
	}
}
