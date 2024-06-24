package libiaryManagmentSystem.DayNine;

import java.time.LocalDate;
import java.util.Date;

public class BorrowTransaction {

	private Member member;
	private Book book;
	private LocalDate borrowDate;
	private LocalDate dueDate;

	public BorrowTransaction(Member member, Book book, LocalDate borrowDate, LocalDate dueDate) {
		this.member = member;
		this.book = book;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
	}

	public Member getMember() {
		return member;
	}

	public Book getBook() {
		return book;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public  LocalDate getDueDate() {
		return dueDate;
	}

	@Override
	public String toString() {
		return "BorrowTransactiion [member=" + member + ", book=" + book + ", borrowDate=" + borrowDate + ", dueDate="
				+ dueDate + "]";
	}









}
