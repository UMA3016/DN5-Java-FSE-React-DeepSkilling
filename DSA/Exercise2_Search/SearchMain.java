public class SearchMain {

    public static void main(String[] args) {

        // Array must be sorted by productName
        SearchProduct[] products = {

                new SearchProduct(
                        101,
                        "Keyboard",
                        "Electronics"),

                new SearchProduct(
                        102,
                        "Laptop",
                        "Electronics"),

                new SearchProduct(
                        103,
                        "Mobile",
                        "Electronics"),

                new SearchProduct(
                        104,
                        "Mouse",
                        "Electronics"),

                new SearchProduct(
                        105,
                        "Speaker",
                        "Electronics")
        };

        // Sort products by name to guarantee correct binary search operation
        java.util.Arrays.sort(products, java.util.Comparator.comparing(SearchProduct::getProductName));

        // Linear Search
        SearchProduct linearResult =
                SearchOperations.linearSearch(
                        products,
                        "Mobile");

        if (linearResult != null) {

            System.out.println(
                    "Linear Search Found:");

            System.out.println(linearResult);

        } else {

            System.out.println(
                    "Product Not Found");
        }

        System.out.println();

        // Binary Search
        SearchProduct binaryResult =
                SearchOperations.binarySearch(
                        products,
                        "Mouse");

        if (binaryResult != null) {

            System.out.println(
                    "Binary Search Found:");

            System.out.println(binaryResult);

        } else {

            System.out.println(
                    "Product Not Found");
        }
    }
}