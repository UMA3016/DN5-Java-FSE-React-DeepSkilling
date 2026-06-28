public class SearchOperations {
 
     // Linear Search
     public static SearchProduct linearSearch(
             SearchProduct[] products,
             String name) {
 
         for (SearchProduct p : products) {
 
             if (p.getProductName().equalsIgnoreCase(name)) {
                 return p;
             }
         }
 
         return null;
     }
 
     // Binary Search
     public static SearchProduct binarySearch(
             SearchProduct[] products,
             String name) {
 
         int left = 0;
         int right = products.length - 1;
 
         while (left <= right) {
 
             int mid = left + (right - left) / 2;
 
             int result =
                     products[mid].getProductName()
                             .compareToIgnoreCase(name);
 
             if (result == 0) {
                 return products[mid];
             }
 
             if (result < 0) {
                 left = mid + 1;
             } else {
                 right = mid - 1;
             }
         }
 
         return null;
     }
 }