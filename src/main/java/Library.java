import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<Book> onLoanBooks;

    public Library() {
        books = new ArrayList<>();
        onLoanBooks = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                return;
            }
        }
    }

    public List<Book> findBooksByPublicationYear(int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public Book findBookWithMostPages() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getPages))
                .orElse(null);
    }

    public List<Book> findBooksMoreThanPages(int pages) {
        return books.stream()
                .filter(book -> book.getPages() > pages)
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public void printAllTitles() {
        List<String> titles = books.stream()
                .map(Book::getTitle)
                .sorted()
                .collect(Collectors.toList());

        for (String title : titles) {
            System.out.println(title);
        }
    }

    public void loanBook(Book book, User user) {
        if (!book.isOnLoan()) {
            book.setOnLoan();
            book.setDueDate(LocalDate.now().plusWeeks(2));
            onLoanBooks.add(book);
            user.addBookToLoan(book);
            System.out.println("Book loaned successfully.");
        } else {
            System.out.println("Book is already on loan.");
        }
    }

    public void returnBook(Book book, User user) {
        if (book.isOnLoan() && user.hasBookOnLoan(book)) {
            book.setOffLoan();
            onLoanBooks.remove(book);
            user.removeBookFromLoan(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book is not on loan to this user.");
        }
    }
}