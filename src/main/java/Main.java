import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

         //NOTE ALL MY TESTING CODE BELOW IS TO SHOW THE FUNCTIONS WORK. USER INPUT NOT IMPLEMENTED. Thank you.

        Library library = new Library();

        //Generating books
        Book bookOne = new Book("Nineteen-Eighty-Four", "George Orwell", 1949, 328, "Non-Fiction(!!!)");
        Book bookTwo = new Book("To Kill A Mockingbird", "Harper Lee", 1988, 384, "Fiction");
        Book bookThree = new Book("The Giver", "Lois Lowry", 1993, 179, "Fiction");

        //Adding books to library
        library.addBook(bookOne);
        library.addBook(bookTwo);
        library.addBook(bookThree);

        //Find books by publication year
        List<Book> booksByPublicationYear = library.findBooksByPublicationYear(1949);
        System.out.println("Books published in 1949:");
        for (Book book : booksByPublicationYear) {
            System.out.println(book.getTitle());
        }

        System.out.println("-------------");

        //Find books by author
        List<Book> booksByAuthor = library.findBooksByAuthor("Lois Lowry");
        System.out.println("Books by the author: Lois Lowry");
        for (Book book : booksByAuthor) {
            System.out.println(book.getTitle());
        }

        System.out.println("-------------");

        //Find book with the most pages
        Book bookWithMostPages = library.findBookWithMostPages();
        System.out.println("The book with the most pages:");
        System.out.println(bookWithMostPages.getTitle());

        System.out.println("-------------");

        //Find books with more than n pages
        List<Book> booksMoreThanPages = library.findBooksMoreThanPages(300);
        System.out.println("Books with more than n pages:");
        for (Book book : booksMoreThanPages) {
            System.out.println(book.getTitle());
        }

        System.out.println("-------------");

        //Find books by category
        List<Book> booksByCategory = library.findBooksByCategory("Fiction");
        System.out.println("Books found under Fiction: ");
        for (Book book : booksByCategory) {
            System.out.println(book.getTitle());
        }

        System.out.println("-------------");

        //Print all sorted book titles
        System.out.println("Here's all the titles in the lib:");
        library.printAllTitles();

        System.out.println("-------------");

        //Register a user with the library
        User user = new User("Rick Grimes", "0000000001");



        //Loan a book to the user
        library.loanBook(bookOne, user);

        //Return a book from the user
        library.returnBook(bookOne, user);


        //Print late fees based on book checkout. Returns zero since book is checked out 'today'
        System.out.println(user.calculateLateFees(bookTwo));

    }
}