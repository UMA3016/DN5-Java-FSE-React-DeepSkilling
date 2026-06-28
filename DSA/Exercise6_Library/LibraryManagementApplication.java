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

        System.out.println("Linear Search for 'DSA':");
        Book resultLinear = LibrarySearch.linearSearch(books, "DSA");
        if(resultLinear != null) {
            System.out.println("Book Found: " + resultLinear.getTitle() + " by " + resultLinear.getAuthor());
        } else {
            System.out.println("Book Not Found");
        }

        System.out.println("\nSorting books by title for Binary Search...");
        java.util.Arrays.sort(books, java.util.Comparator.comparing(Book::getTitle));

        System.out.println("\nBinary Search for 'Java':");
        Book resultBinary = LibrarySearch.binarySearch(books, "Java");
        if(resultBinary != null) {
            System.out.println("Book Found: " + resultBinary.getTitle() + " by " + resultBinary.getAuthor());
        } else {
            System.out.println("Book Not Found");
        }
    }
}