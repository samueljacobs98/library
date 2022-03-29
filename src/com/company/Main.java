package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 1. Create a new library for us to interact with
        ArrayList<Librarian> librarians = new ArrayList<Librarian>(0);
        ArrayList<Member> members = new ArrayList<Member>(0);
        ArrayList<BookItem> availableBooks = new ArrayList<BookItem>(0);
        ArrayList<BookItem> rentedBooks = new ArrayList<BookItem>(0);

        Library library = new Library( librarians, members, availableBooks,  rentedBooks);

        // 2. Populate some available books in our library
        BookItem bookItem1 = new BookItem("McChef","Billy Shakespeare",978316148);
        BookItem bookItem2 = new BookItem("McGeoff","Silly Bakespeare",978316149);
        BookItem bookItem3 = new BookItem("McBeff","Dilly Hakespeare",978316150);

        library.addAvailableBook(bookItem1);
        library.addAvailableBook(bookItem2);
        library.addRentedBook(bookItem3);

        // 3. Populate some members and a librarian in our library
        Member member1 = new Member(587329,"Luke","10 Borrowing Street", "luke@ggnoremail.com", new LibraryCard(true));
        Member member2 = new Member(587330,"Duke","11 Borrowing Street", "duke@ggnoremail.com", new LibraryCard(true));
        Member member3 = new Member(587331,"Snoop","12 Borrowing Street", "snoop@ggnoremail.com", new LibraryCard(false));

        library.addMember(member1);
        library.addMember(member2);
        library.addMember(member3);

        Librarian librarian1 = new Librarian(487329,"Shelly","10 Reading Street", "shelly@ggnoremail.com");
        Librarian librarian2 = new Librarian(487330,"Jelly","11 Reading Street", "jelly@ggnoremail.com");
        Librarian librarian3 = new Librarian(487331,"Kelly","12 Reading Street", "kelly@ggnoremail.com");

        library.addLibrarian(librarian1);
        library.addLibrarian(librarian2);
        library.addLibrarian(librarian3);

        // 4. (Scanner) Get an email, find a member matching this email
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email address.");
        String emailToLookFor = scanner.nextLine();

        Member memberByEmail = null;

        try {
            memberByEmail = library.getMemberByEmail(emailToLookFor);
            String memberName = memberByEmail.getName();
            System.out.println("Hi " + memberName + ".");
        } catch (Exception error) {
            System.out.println(error);
        }

        if (!memberByEmail.getIsActive()) {
            System.out.println("Sorry, your library card is no longer active. Would you like to re-instate it?");
            String reinstate = scanner.nextLine();
            if (!reinstate.toLowerCase().equals("yes")) {
                System.out.println("Maybe next time!");
                return;
            }
            memberByEmail.setIsActive(true);
            System.out.println("Your library card has been reinstated.");
        }

        // 5. (Scanner) Get a book name, find a book matching this name
        System.out.println("Enter the book you are looking for.");
        String bookTitleToLookFor = scanner.nextLine();

        BookItem bookByTitle = null;
        String wantedBookName = null;

        try {
            bookByTitle = library.getBookByTitle(bookTitleToLookFor);
            wantedBookName = bookByTitle.getName();
            String bookByTitleAuthor = bookByTitle.getAuthor();
            long bookByTitleISBN = bookByTitle.getISBN();
            System.out.println("The book you are looking for, " + wantedBookName + ", by " + bookByTitleAuthor + ", has ISBN " + bookByTitleISBN + ".");
        } catch (Exception error) {
            System.out.println(error);
        }

        boolean bookByTitleIsAvailable = library.isAvailable(bookByTitle);

        if (!bookByTitleIsAvailable) {
            System.out.println("Sorry, this book is unavailable.");
            return;
        }
        System.out.println(wantedBookName + " is available.");

        // 6. (Scanner) Confirm with the user that they would like to loan a book. Create a loan which moves
        //    a book from available to loaned
        System.out.println("Type 'Yes' and hit enter to confirm you would like to loan this book.");
        String confirm = scanner.nextLine();
        if (!confirm.toLowerCase().equals("yes")) {
            System.out.println("Maybe something else then!");
            return;
        }
        library.removeAvailableBook(bookByTitle);
        library.addRentedBook(bookByTitle);
        System.out.println("Thank you for renting " + wantedBookName);
        // 7. Great! Our first prototype has been built. What design problems have we introduced? How can we make this better?
    }
}
