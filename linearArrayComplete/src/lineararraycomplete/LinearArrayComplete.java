
package lineararraycomplete;


public class LinearArrayComplete{

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 60};

        System.out.println("\n///// TEST 01: Copy Array example /////");
        int[] b = copyArray(a, a.length);
        printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 

        System.out.println("\n///// TEST 02: Print Reverse example /////");
        printArray(a); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
        printReverse(a); // This Should Print: { 60, 50, 40, 30, 20, 10 } 
        System.out.println("\n///// TEST 03: Reverse Array example /////");
        reverseArray(b);
        printArray(b); // This Should Print: { 60, 50, 40, 30, 20, 10 } 

        System.out.println("\n///// TEST 04: Shift Left k cell example /////");
        b = copyArray(a, a.length);
        b = shiftLeft(b, 3);
        printArray(b); // This Should Print: { 40, 50, 60, 0, 0, 0 } 

        System.out.println("\n///// TEST 05: Rotate Left k cell example /////");
        b = copyArray(a, a.length);
        printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
        b = rotateLeft(b, 3);
        printArray(b); // This Should Print: { 40, 50, 60, 10, 20, 30 } 

        System.out.println("\n///// TEST 06: Shift Right k cell example /////");
        b = copyArray(a, a.length);
        printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
        b = shiftRight(b, 3);
        printArray(b);  // This Should Print: { 0, 0, 0, 10, 20, 30 } 

        System.out.println("\n///// TEST 07: Rotate Right k cell example /////");
        b = copyArray(a, a.length);
        printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
        b = rotateRight(b, 3);
        printArray(b); // This Should Print: { 40, 50, 60, 10, 20, 30 } 

        System.out.println("\n///// TEST 08: Insert example 1 /////");

        b = copyArray(a, a.length);
        printArray(b);  // This Should Print: { 10, 20, 30, 40, 50, 60 } 
        boolean bol = insert(b, 6, 70, 2); // This Should Print: No space Left 
        System.out.println(bol); // This Should Print: false
        printArray(b);  // This Should Print: { 10, 20, 30, 40, 50, 60 } 

        System.out.println("\n///// TEST 09: Insert example 2 /////");
        int[] c = {10, 20, 30, 40, 50, 0, 0};
        printArray(c);  // This Should Print: { 10, 20, 30, 40, 50, 0, 0 }
        bol = insert(c, 5, 70, 2);  // This Should Print: Number of elements after insertion: 6
        System.out.println(bol); // This Should Print: true
        printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 0 } 

        System.out.println("\n///// TEST 10: Insert example 3 /////");
        printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 0 } 
        bol = insert(c, 6, 70, 6); // This Should Print: Number of elements after insertion: 7 
        System.out.println(bol); // This Should Print: true
        printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 

        System.out.println("\n///// TEST 11: Remove example 1 /////");

        printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 
        bol = removeAll(c, 7, 90);
        System.out.println(bol); // This Should Print: false
        printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 

        System.out.println("\n///// TEST 12: Remove example 2 /////");
        printArray(c);  // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 
        bol = removeAll(c, 7, 70);
        System.out.println(bol); // This Should Print: true
        printArray(c);  // This Should Print: { 10, 20, 30, 40, 50, 0, 0 } 
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println("");
    }

    public static int[] copyArray(int[] source, int len) {
        int temp[] = new int[len];
        for (int i = 0; i < source.length; i++) {
            temp[i] = source[i];
        }
        return temp;
    }

    public static void printReverse(int[] source) {
        for (int i = source.length - 1; i >= 0; i--) {
            System.out.print(source[i] + ",");
        }
        System.out.println("");
    }

    public static void reverseArray(int[] a) {    
        int i, k, t; 
        int n=a.length;
        for (i = 0; i < n/ 2; i++) { 
            t = a[i]; 
            a[i] = a[n - i - 1]; 
            a[n - i - 1] = t; 
    }
    }
    // Shifts all the elements of the source array to the left by 'k' positions
    // Returns the updated array
    public static int[] shiftLeft(int[] source, int k) {
        for (int c = 1; c <= k; c++) {
            for (int i = 0; i < source.length - 1; i++) {
                source[i] = source[i + 1];
            }
            source[source.length - 1] = 0;
        }
        return source; // remove this line    
    }

    // Rotates all the elements of the source array to the left by 'k' positions
    // Returns the updated array
    public static int[] rotateLeft(int[] source, int k) {
        for (int i = 0; i < k; i++) {
            int temp = source[0];
            for (int j = 0; j < source.length - 1; j++) {
                source[j] = source[j + 1];
            }
            source[source.length - 1] = temp;
        }
        return source; // remove this line    
    }

    // Shifts all the elements of the source array to the right by 'k' positions
    // Returns the updated array
    public static int[] shiftRight(int[] source, int k) {
        for (int c = 1; c <= k; c++) {
            for (int i = source.length - 1; i > 0; i--) {
                source[i] = source[i - 1];
            }
            source[0] = 0;
        }
        return source; // remove this line    
    }

    // Rotates all the elements of the source array to the right by 'k' positions
    // Returns the updated array
    public static int[] rotateRight(int[] source, int k) {
        for (int i = 0; i < k; i++) {
            int temp = source[source.length - 1];
            for (int j = source.length - 1; j > 0; j--) {
                source[j] = source[j - 1];
            }
            source[0] = temp;
        }
        return source;

    }

    public static boolean insert(int[] arr, int size, int elem, int index) {

        if (size != arr.length) {
            if (size <= arr.length) {

                for (int i = arr.length - 1; i > index; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[index] = elem;

                System.out.println("Insertion is done");
                return true;
            } else {
                System.out.println("invalid index");
                return false;
            }
        }
        return false;
        // remove this line    
    }

    /**
     * removes all the occurences of the given element
     *
     * @param arr the reference to the linear array
     * @param size the number of elements that exists in the array.
     * size<=arr.length @param elem the element to be removed @return true if
     * removal is successful; return fal se otherwise if removal is successful,
     * print the 'Number of elements after removal' is completed
     */
    public static boolean removeAll(int[] arr, int size, int elem) {
        int temp = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                temp = i;
                for (int j = temp; j < size - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[size - 1] = 0;
            }
        }
        if (temp > 0) {
            return true;
        } else {
            return false;
        }
    }

}