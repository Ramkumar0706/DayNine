package libiaryManagmentSystem.DayNine;

import java.time.LocalDate;

public class Library {
	private static final int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private Member[] members = new Member[MAX_SIZE];
	private BorrowTransaction[] transactions = new BorrowTransaction[MAX_SIZE];
	public static final int FINE_PER_DAY = 10;

	private int bookCount = 0;
	private int memberCount = 0;
	private int transactionCount = 0;

	public void addBook(Book book) {
		for (int i = 0; i < bookCount; i++) {
			if (books[i].getIsbn() == book.getIsbn()) {
				System.out.println("The book is already added in the Library");
				return;
			}
		}
		if (bookCount < MAX_SIZE) {
			books[bookCount++] = book;
		} else {
			System.out.println("The library is full, cannot add more books.");
		}
	}

	public void removeBook(int isbn) {
		for (int i = 0; i < bookCount; i++) {
			if (books[i].getIsbn() == isbn) {
				books[i] = books[--bookCount]; 
				books[bookCount] = null; 
				System.out.println("The book is removed");
				return;
			}
		}
		System.out.println("The book is not present in the library");
	}

	public Book searchBook(int isbn) {
		for (int i = 0; i < bookCount; i++) {
			if (books[i].getIsbn() == isbn) {
				return books[i];
			}
		}
		return null;
	}

	public void addMember(Member member) {
		for (int i = 0; i < memberCount; i++) {
			if (members[i].getMemberId() == member.getMemberId()) {
				System.out.println("The member is already present in the library");
				return;
			}
		}
		if (memberCount < MAX_SIZE) {
			members[memberCount++] = member;
			System.out.println("The new Member is added successfully");
		} else {
			System.out.println("The library is full, cannot add more members.");
		}
	}

	public void removeMember(int memberId) {
		for (int i = 0; i < memberCount; i++) {
			if (members[i].getMemberId() == memberId) {
				members[i] = members[--memberCount]; 
				members[memberCount] = null; 
				System.out.println("The member is removed");
				return;
			}
		}
		System.out.println("The member is not present in the library");
	}

	public Member searchMember(int memberId) {
		for (int i = 0; i < memberCount; i++) {
			if (members[i].getMemberId() == memberId) {
				return members[i];
			}
		}
		return null;
	}

	public void borrowBook(int isbn, int memberId) {
		Book book = searchBook(isbn);
		Member member = searchMember(memberId);
		if (book != null && member != null) {
			if (transactionCount < MAX_SIZE) {
				transactions[transactionCount++] = 
						new BorrowTransaction(member, book, LocalDate.now(), LocalDate.now().plusDays(14));
				System.out.println("Book borrowed successfully.");
			} else {
				System.out.println("The library cannot able to do more transactions.");
			}
		} else {
			System.out.println("The transaction is incomplete");
		}
	}

	public void returnBook(int isbn, int memberId) {
		BorrowTransaction transaction = null;
		for (int i = 0; i < transactionCount; i++) {
			if (transactions[i].getBook().getIsbn() == isbn && transactions[i].getMember().getMemberId() == memberId) {
				transaction = transactions[i];
				transactions[i] = transactions[--transactionCount]; 
				transactions[transactionCount] = null; 
				int dueFine = calculateFine(transaction);
				if (dueFine > 0) {
					System.out.println("Fine for late return: $" + dueFine);
				} else {
					System.out.println("Book returned successfully with no fine.");
				}
				break;
			}
			else {
				System.out.println("No matching borrow transaction found");
			}
		}
	}

	public int calculateFine(BorrowTransaction transaction) {
		LocalDate today = LocalDate.now();
		LocalDate dueDate = transaction.getDueDate();
		if (today.isAfter(dueDate)) {
			int daysLate = 0;
			LocalDate currentDate = dueDate;
			while (currentDate.isBefore(today)) {
				daysLate++;
				currentDate = currentDate.plusDays(1);
			}
			return daysLate * FINE_PER_DAY;
		}
		return 0;
	}

	public void generateOverDueReport() {
		LocalDate today = LocalDate.now();
		for (int i = 0; i < transactionCount; i++) {
			if (transactions[i].getDueDate().isBefore(today)) {
				System.out.println(transactions[i].getBook() + " borrowed by " +"\n"+ transactions[i].getMember());			}
		}
	}

	public void generateBorrowedReport() {
		for (int i = 0; i < transactionCount; i++) {
			System.out.println(transactions[i].getBook() + " borrowed by " +"\n"+ transactions[i].getMember());
		}
	}

	public void generateAvailableBooks() {
		for (int i = 0; i < bookCount; i++) {
			boolean available = true;
			for (int j = 0; j < transactionCount; j++) {
				if (books[i].getIsbn() == transactions[j].getBook().getIsbn()) {
					available = false;
					break;
				}
			}
			if (available) {
				System.out.println( books[i]);
			}
		}
	}
}
