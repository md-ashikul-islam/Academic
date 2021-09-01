package recursion;

public class Recursion {

    public int StringLength(String s){
        if(s.equals(""))return 0;
        return 1+StringLength(s.substring(1));
    }
    public  int whatever(int a, int b){
        if(b==0) return a;
        return whatever(b, a%b);
    }
    public  int F(int n){
        if(n <10)return n;
        int m=0;
        while (n>0){
            m+=n%10;
            n=n/10;
        }
        return F(m);
        }
    public int Factorial(int n){
        if(n==1){
            return 1;
        }
        else{
          return n*Factorial(n-1); 
        }  
    }
    public int Fib(int n){
        if(n==0)return 0;
        if(n<=2) return 1;
        else{
            return Fib(n-1)+Fib(n-2);
        }
    }
   
    }
    

