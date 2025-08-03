import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Library {
    ArrayList<String> Books = new ArrayList<>();
    String[] issuedBooks = new String[100];  // Adjust the size as needed
    int No_Of_Books;

    Library() {
        this.No_Of_Books = 0;
    }

    void AddBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the book name which to be Add: ");
        String book = sc.next();

        Books.add(book);
        No_Of_Books++;
        System.out.println(book + " book is added");
    }

    static int userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nLibrary System Menu:");
        System.out.println("1. Available books");
        System.out.println("2. Borrow a book");
        System.out.println("3. Return a book");
        System.out.println("4. Borrowed books");
        System.out.println("5. Add a book");
        System.out.println("6. Close Library");
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }

    void ShowAvailableBook() {
        System.out.println("Available Books are: ");
        int j = 1;
        for (String book : Books) {
            System.out.println((j++) + ". " + book);
        }
        if (j == 1) {
            System.out.println("No available book");
        }
    }

    void BorrowBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the book name which to be issued: ");
        String bookName = sc.next();

        int i = 0;
        while (i < Books.size() && !Objects.equals(bookName, Books.get(i))) {
            i++;
        }

        if (i == Books.size()) {
            System.out.println("\n" + bookName + " is not available in the library");
            return;
        }

        System.out.println("Book Issued");

        int j = 0;
        while (j < issuedBooks.length && issuedBooks[j] != null) {
            j++;
        }

        if (j < issuedBooks.length) {
            issuedBooks[j] = Books.remove(i);
        }
    }

    void returnBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the book name which to be submitted: ");
        String bookName = sc.next();

        for (int j = 0; j < issuedBooks.length; j++) {
            if (Objects.equals(issuedBooks[j], bookName)) {
                Books.add(issuedBooks[j]);
                issuedBooks[j] = null;
                System.out.println("\nBook Submitted.");
                return;
            }
        }

        System.out.println("\nThis book has not been issued from this library.");
    }

    void printIssuedBook() {
        int n = 1;
        for (String issuedBook : issuedBooks) {
            if (issuedBook != null) {
                System.out.println((n++) + ". " + issuedBook);
            }
        }
        if (n == 1) {
            System.out.println("No books issued yet!");
        }
    }

    public static void main(String[] args) {

        Library library = new Library();

        while (true) {
            int choice = userInput();
            switch (choice) {
                case 1:
                    library.ShowAvailableBook();
                    break;
                case 2:
                    library.BorrowBook();
                    break;
                case 3:
                    library.returnBook();
                    break;
                case 4:
                    library.printIssuedBook();
                    break;
                case 5:
                    library.AddBook();
                    break;
                case 6:
                    System.out.println("Library Closed!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input!");
            }
        }
    }
}
