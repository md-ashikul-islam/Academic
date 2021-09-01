
package circulartolinear;


public class CircularToLinear {

  
    public static void main(String[] args) {
       int [] circular={40,50,0,0,0,0,0,0,10,20,30};
      //printForward(circular,8,5);
       circular=linearisation(circular,8,5);
        
        for(int i=0;i<circular.length;i++){
         
            System.out.print(" "+circular[i]);
        }
    
       
    }
    
    public static int[] linearisation(int[]c,int sIndex,int size){
        int[] temp=new int[c.length];
        int i=sIndex;
        
        for(int k=0;k<size;k++){
          temp[k]=c[i];  
        i=(++i)%c.length;
            
        }
        return temp;
    }
   
    
    
}
