
public class MainMethod {

    public static void main(String[] args) {
        ListStack gg = new ListStack();

        gg.push("D");
        gg.push("0");
        gg.push("N");
        System.out.println("popped:"+ gg.pop());
        gg.push("0");
        gg.peek();
        gg.push("T");
         System.out.println("popped:"+ gg.pop());
         System.out.println("popped:"+ gg.pop());
        gg.push("P");
        gg.peek();
        gg.push("L");
        gg.peek();
        gg.push("A");
         System.out.println("popped:"+ gg.pop());
        gg.push("G");
         System.out.println("popped:"+ gg.pop());
         System.out.println("popped:"+ gg.pop());
        gg.push("I");
         System.out.println("popped:"+ gg.pop());
        gg.push("A");
        System.out.println("popped:"+ gg.pop());
        gg.push("R");
        gg.push("I");
        gg.peek();
        gg.push("Z");
         System.out.println("popped:"+ gg.pop());
         System.out.println("popped:"+ gg.pop());
        gg.peek();
        gg.push("E");
        gg.show();
        
        
        System.out.println(gg.peek());

    }
}
