package com.company;
import java.util.ArrayList;
import java.util.Locale;

public class Library {
    private ArrayList<Librarian> librarians;
    private ArrayList<Member> members;
    private ArrayList<BookItem> availableBooks;
    private ArrayList<BookItem> rentedBooks;

//    Constructor
    public Library(ArrayList<Librarian> librarians, ArrayList<Member> members, ArrayList<BookItem> availableBooks, ArrayList<BookItem> rentedBooks) {
        this.librarians = librarians;
        this.members = members;
        this.availableBooks = availableBooks;
        this.rentedBooks = rentedBooks;
    }


//    Methods
    public boolean isAvailable(BookItem book) {
      return availableBooks.contains(book);
    }

    public void addAvailableBook(BookItem book) {
        availableBooks.add(book);
    }

    public void removeAvailableBook(BookItem book) {
        availableBooks.remove(book);
    }

    public void addRentedBook(BookItem book) {
        rentedBooks.add(book);
    }

    public void addMember(Member newMember) {
        members.add(newMember);
    }

    public void addLibrarian(Librarian newLibrarian) {
        librarians.add(newLibrarian);
    }

    public Member getMemberByEmail(String email) throws Exception {
        for (Member member : members) {
            if (member.getEmailAddress().toLowerCase().equals(email.toLowerCase())) {
                return member;
            }
        }
        throw new Exception("This email address doesn't match a member in our database.");
    }

    public BookItem getBookByTitle(String bookTitle) throws Exception {
        for (BookItem book : availableBooks) {
            if (book.getName().toLowerCase().equals(bookTitle.toLowerCase())) {
                return book;
            }
        }
        for (BookItem book : rentedBooks) {
            if (book.getName().toLowerCase().equals(bookTitle.toLowerCase())) {
                return book;
            }
        }
        throw new Exception("This book address doesn't match a member in our database.");
    }

}
