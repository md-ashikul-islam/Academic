package lineararray;

public class LinearArray {

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

    // Prints the contents of the source array
    public static void printArray(int[] source) {
        for (int c = 0; c < source.length; c++) {
            System.out.print(source[c] + " ");
        }
        System.out.println("");
    }

    // Prints the contents of the source array in reverse order
    public static void printReverse(int[] source) {
        for (int c = source.length - 1; c >= 0; c--) {
            System.out.print(source[c] + " ");
        }
    }

    // creates a copy of the source array and returns the reference of the newly created copy array
    public static int[] copyArray(int[] source, int len) {
        int[] cArray = new int[source.length];
        for (int c = 0; c < len; c++) {
            cArray[c] = source[c];
        }
        return cArray; 
    }

    // creates a reversed copy of the source array and returns the reference of the newly created reversed array
    public static void reverseArray(int[] source) {
        int[] temp = new int[source.length];
        int count = 0;
        for (int i = 0, j = source.length - 1; i <= 2 || j >= 3; i++, j--) {
            temp[count] = source[i];
            source[i] = source[j];
            source[j] = temp[count];
            count++;
        }
    }

    // Shifts all the elements of the source array to the left by 'k' positions
    // Returns the updated array
    public static int[] shiftLeft(int[] source, int k) {
        for (int c = 0; c < k; c++) {
            source[c] = source[c + k];
        }
        for (int j = source.length - 1; j >= k; j--) {
            source[j] = 0;
        }
        return source;
    }

    // Rotates all the elements of the source array to the left by 'k' positions
    // Returns the updated array
    public static int[] rotateLeft(int[] source, int k) {
        int[] temp = new int[k];
        int count = 0;
        for (int i = 0; i < k; i++) {
            temp[count] = source[i];
            source[i] = source[i + k];
            count++;
        }

        for (int i = 0; i < k; i++) {
            source[i + k] = temp[i];
        }
        return source;
    }

    // Shifts all the elements of the source array to the right by 'k' positions
    // Returns the updated array
    public static int[] shiftRight(int[] source, int k) {
        for (int c = source.length - 1; c >= k; c--) {
            source[c] = source[c - k];
        }
        for (int j = 0; j < k; j++) {
            source[j] = 0;
        }
        return source;
    }

    // Rotates all the elements of the source array to the right by 'k' positions
    // Returns the updated array
    public static int[] rotateRight(int[] source, int k) {
        int[] temp = new int[k];
        int counter = 0;
        for (int c = source.length - 1; c >= k; c--) {
            temp[counter] = source[c];
            source[c] = source[c - k];
            counter++;
        }
        for (int c = 0; c < k; c++) {
            source[c] = temp[k - c - 1];
        }

        return source;
    }

    public static boolean insert(int[] arr, int size, int elem, int index) {
        if (size == arr.length) {
            System.out.println("No Space Left");
            return false;
        }
        if (index < 0 || index > size) {
            System.out.println("Invalid Index");
            return false;
        }

        for (int c = size - 1; c >= index; c--) {
            arr[c + 1] = arr[c];
        }
        size = size + 1;
        System.out.println("Number of elements after insertion: " + size);
        arr[index] = elem;
        return true;
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
