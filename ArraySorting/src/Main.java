
public class Main {
    public static void main(String[] args) {
        Sorting sort=new Sorting();
        int [] A={3,7,4,9,5,2,6,1};
        
        //int sorted[]=sort.bubbleSorting(A);
        
        System.out.println("Unsorted Array: ");
        sort.display(A);
        //sort.selectionSort(A);
        sort.recursiveBubble(A ,6);
        //sort.recursiveSelection(A,6);
        System.out.println("Sorted Array: ");
        sort.display(A);
    }
  
}
