
public class Sorting {
  public int[] bubbleSorting(int []A){
      Sorting sr=new Sorting();
      for(int i=A.length-1;i>=0;i--){
          for(int j=0;j<i;j++){
              if(A[j]>A[j+1]){
                  int temp=A[j];
                  A[j]=A[j+1];
                  A[j+1]=temp;
                 
              }
              sr.display(A);
          }
      }
      return A;
  }
  
  public int[] recursiveBubble(int []A,int size){
      if(size ==1){
          return A;
      }
      for(int i=0;i<size-1;i++){
         if(A[i]>A[i+1]){
                  int temp=A[i];
                  A[i]=A[i+1];
                  A[i+1]=temp; 
      }
  }
       return recursiveBubble(A,size-1);
  }
  
  public int[] selectionSort(int []A){
      int min,temp;
      for(int i=0;i<A.length;i++){
          min=A[i];
          for(int j=i+1;j<A.length;j++){
              if(A[j]<A[i]){
                  temp=A[j];
                  A[j]=A[i];
                  A[i]=temp;
                  
              }
          }
      }
      return A;
  }
    public int[] recursiveSelection(int []A,int size){
      int min,temp;
      if(size==1)return A;
      for(int i=0;i<size-1;i++){
          min=A[i];
          
              if(A[i+1]<A[i]){
                  temp=A[i+1];
                  A[i+1]=A[i];
                  A[i]=temp;
              }
          
      }
      return recursiveSelection(A,size-1);
  
    }

  
  
  
public void display(int []A){
    for(int i=0;i<A.length;i++){
        System.out.print(A[i]+" ");
    }
      System.out.println("");
}  
}
