package builtindatastructure;
import java.util.LinkedList;
public class BuiltInDataStructure {

    
    public static void main(String[] args) {
      LinkedList <String> JohnWick = new LinkedList<String>();
      JohnWick.add(0, "Ashik");
      JohnWick.add(1, "Abed");
      JohnWick.add(2, "Mekhala");
      JohnWick.add(3, "Mitu");
      JohnWick.add(4, "Fardin");
      
        System.out.println(JohnWick.get(3));
        System.out.println(JohnWick.size());
        System.out.println(JohnWick.isEmpty());
        System.out.println(JohnWick.set(1, "Ahanaf"));
        System.out.println(JohnWick.remove(4));
      
        System.out.println(JohnWick);
    }
    
}
