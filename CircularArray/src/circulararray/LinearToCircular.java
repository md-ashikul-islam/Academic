
package circulararray;


public class LinearToCircular {

    
    public static void main(String[] args) {
      int []lArray ={10,20,30,40,50,0,0,0,0,0,0};
      lArray= arrayChange(lArray,8,5);
      for(int j=0;j<lArray.length;j++){
          System.out.print(" "+lArray[j]);
      }
     
    }
    
    
    public static int[] arrayChange(int []lA,int sIndex,int Size){
        int[] temp=new int[lA.length];
        int k =sIndex;
        for(int i=0;i<Size;i++){
            
            temp[k]=lA[i];
            k=(k+1)%lA.length;
            }
        return temp;
        }
        
    }
    

