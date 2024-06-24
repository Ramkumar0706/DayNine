package libiaryManagmentSystem.DayNine;

import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;

        while (exit) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Add Member");
            System.out.println("5. Remove Member");
            System.out.println("6. Search Member");
            System.out.println("7. Borrow Book");
            System.out.println("8. Return Book");
            System.out.println("9. Generate Overdue Report");
            System.out.println("10. Generate Borrowed Books Report");
            System.out.println("11. Generate Available Books Report");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    int isbn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    library.addBook(new Book(isbn, title, author, publisher, year));
                    System.out.println("Book is added");
                    break;
                case 2:
                    System.out.print("Enter ISBN of book to remove: ");
                    isbn = scanner.nextInt();
                    library.removeBook(isbn);
                    break;
                case 3:
                    System.out.print("Enter ISBN of book to search: ");
                    isbn = scanner.nextInt();
                    Book book = library.searchBook(isbn);
                    if(book!=null)
                   System.out.println(book);
                    else
                    	System.out.println("book not found");
                    break;
                case 4:
                    System.out.print("Enter Member ID: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Contact: ");
                    long contact = scanner.nextLong();
                    scanner.nextLine();
                    library.addMember(new Member(memberId, name, address, contact));
                    break;
                case 5:
                    System.out.print("Enter Member ID to remove: ");
                    memberId = scanner.nextInt();
                    library.removeMember(memberId);
                    break;
                case 6:
                    System.out.print("Enter Member ID to search: ");
                    memberId = scanner.nextInt();
                    Member member = library.searchMember(memberId);
                    System.out.println(member);
                    break;
                case 7:
                    System.out.print("Enter ISBN of book to borrow: ");
                    isbn = scanner.nextInt();
                    System.out.print("Enter Member ID: ");
                    memberId = scanner.nextInt();
                    library.borrowBook(isbn, memberId);
                    break;
                case 8:
                    System.out.print("Enter ISBN of book to return: ");
                    isbn = scanner.nextInt();
                    System.out.print("Enter Member ID: ");
                    memberId = scanner.nextInt();
                    library.returnBook(isbn, memberId);
                    break;
                case 9:
                    library.generateOverDueReport();
                    break;
                case 10:
                    library.generateBorrowedReport();
                    break;
                case 11:
                    library.generateAvailableBooks();
                    break;
                case 12:
                    exit = false;
                    System.out.println("Exiting Library Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
