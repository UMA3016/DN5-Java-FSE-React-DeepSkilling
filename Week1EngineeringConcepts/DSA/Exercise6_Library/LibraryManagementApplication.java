public class LibraryManagementApplication {

    public static void main(String[] args) {

        Book[] books = {

                new Book(
                        101,
                        "DSA",
                        "Mark Allen"),

                new Book(
                        102,
                        "Java",
                        "James Gosling"),

                new Book(
                        103,
                        "Python",
                        "Guido")
        };

        Book result =
                LibrarySearch.linearSearch(
                        books,
                        "DSA");

        if(result != null) {

            System.out.println(
                    "Book Found: "
                    + result.title);
        }
    }
}