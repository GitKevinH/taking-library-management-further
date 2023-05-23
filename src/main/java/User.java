import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String libraryCardNumber;
    private List<Book> booksOnLoan;

    public User(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.booksOnLoan = new ArrayList<>();
    }

    public void addBookToLoan(Book book) {
        booksOnLoan.add(book);
    }

    public void removeBookFromLoan(Book book) {
        booksOnLoan.remove(book);
    }

    public boolean hasBookOnLoan(Book book) {
        return booksOnLoan.contains(book);
    }

    private int calculateWeeksOverdue(Book book) {
        LocalDate currentDate = LocalDate.now();
        LocalDate dueDate = book.getDueDate();
        return (int) (currentDate.until(dueDate).toTotalMonths() / 4.34524);
    }

    public double calculateLateFees(Book book) {
        int weeksOverdue = calculateWeeksOverdue(book);
        if (weeksOverdue <= 0) {
            return 0.0;
        }
        double lateFeePerWeek = 0.50;
        return lateFeePerWeek * weeksOverdue;
    }


}