class Library:
    def __init__(self):
        self.books = []
        self.issued_books = [None] * 100
        self.no_of_books = 0

    def add_book(self):
        book = input("Enter the book name to be added: ")
        self.books.append(book)
        self.no_of_books += 1
        print(f"{book} book is added")

    def show_available_books(self):
        print("Available Books are: ")
        for i, book in enumerate(self.books, start=1):
            print(f"{i}. {book}")
        if not self.books:
            print("No available book")

    def borrow_book(self):
        book_name = input("Enter the book name to be issued: ")
        try:
            index = self.books.index(book_name)
            print("Book Issued")
            for j, issued_book in enumerate(self.issued_books):
                if issued_book is None:
                    self.issued_books[j] = self.books.pop(index)
                    break
        except ValueError:
            print(f"\n{book_name} is not available in the library")

    def return_book(self):
        book_name = input("Enter the book name to be submitted: ")
        for j, issued_book in enumerate(self.issued_books):
            if issued_book == book_name:
                self.books.append(self.issued_books[j])
                self.issued_books[j] = None
                print("\nBook Submitted.")
                return
        print("\nThis book has not been issued from this library.")

    def print_issued_books(self):
        print("Issued Books are: ")
        for i, issued_book in enumerate(self.issued_books, start=1):
            if issued_book is not None:
                print(f"{i}. {issued_book}")
                
        if all(issued_book is None for issued_book in self.issued_books):
            print("No books issued yet!")

    def main(self):
        while True:
            print("\nLibrary System Menu:")
            print("1. Available books")
            print("2. Add a book")
            print("3. Borrow a book")
            print("4. Return a book")
            print("5. Borrowed books")
            print("6. Close Library")
            choice = int(input("Enter your choice: "))
            if choice == 1:
                self.show_available_books()
            elif choice == 2:
                self.add_book()
            elif choice == 3:
                self.borrow_book()
            elif choice == 4:
                self.return_book()
            elif choice == 5:
                self.print_issued_books()
            elif choice == 6:
                print("Library Closed!")
                break
            else:
                print("Invalid Input!")


if __name__ == "__main__":
    library = Library()
    library.main()
