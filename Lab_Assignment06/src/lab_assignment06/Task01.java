
package lab_assignment06;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Task01 {

   
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\Maymuna\\Documents\\MyProjects\\Lab_Assignment06\\src\\lab_assignment06\\t1.txt");
            Scanner sc = new Scanner(file);
            int mew = Integer.parseInt(sc.nextLine());
            int nobita = Integer.parseInt(sc.nextLine());
            String khelowar[] = new String[nobita];
            int p[] = new int[nobita];
            int bloop[] = new int[nobita];
            String jayga[] = new String[nobita];
            for (int orb = 0; orb < nobita; orb++) {
                String[] stringerdol = sc.nextLine().split(", ");
                khelowar[orb] = stringerdol[0];
                bloop[orb] = Integer.parseInt(stringerdol[1]);
                p[orb] = Integer.parseInt(stringerdol[2]);
                jayga[orb] = stringerdol[3];
            }
            //Knapsack
            int k[][] = new int[nobita + 1][mew + 1];
            for (int fleg = 0; fleg <= nobita; fleg++) {
                for (int w = 0; w <= mew; w++) {
                    if (fleg == 0 || w == 0) {
                        k[fleg][w] = 0;
                    } else if (bloop[fleg - 1] <= w) {
                        k[fleg][w] = Math.max(p[fleg - 1] + k[fleg - 1][w - bloop[fleg - 1]], k[fleg - 1][w]);
                    } else {
                        k[fleg][w] = k[fleg - 1][w];
                    }
                }
            }
            Stack<String> stack = new Stack<>();
            //printing the items
            int jamaica = mew;
            for (int ak = nobita; ak > 0 && jamaica > 0; ak--) {
                if (k[ak][jamaica] == k[ak - 1][jamaica]) {
                } else {
                    stack.add(khelowar[ak - 1]);
                    jamaica = jamaica- bloop[ak - 1];
                }
            }
            System.out.println("Bought Players: ");
            while (stack.empty() == false) {
                System.out.print(stack.pop());
                if (stack.size() + 1 != 1) {
                    System.out.print(" --> ");
                }
            }
            System.out.println("");
            System.out.println("Maximum summation of form: " + k[nobita][mew]);
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println("Wrong text file directory");
        }

    }
}

