
package lab_assignment06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


public class Task02 {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\Maymuna\\Documents\\MyProjects\\Lab_Assignment06\\src\\lab_assignment06\\t2.txt");
            Scanner sc = new Scanner(file);
            int mew = Integer.parseInt(sc.nextLine());
            int nobita = Integer.parseInt(sc.nextLine());
            String club[] = new String[nobita];
            double p[] = new double[nobita];
            int bloop[] = new int[nobita];
            String trophy[] = new String[nobita];
            for (int i = 0; i < nobita; i++) {
                String[] StringArray1 = sc.nextLine().split(", ");
                club[i] = StringArray1[0];
                bloop[i] = Integer.parseInt(StringArray1[1]);
                p[i] = Double.parseDouble(StringArray1[2]);
                trophy[i] = StringArray1[3];
            }
           
            double Profit = 0.0;
            int index = -1;
            for (int i = 0; i < nobita; i++) {
                if (trophy[i].equals("Champion’s League")) {
                    double temp = (p[i] / bloop[i]) * 100;
                    if (temp > Profit) {
                        Profit = temp;
                        index = i;
                    }
                }
            }
         
            mew = mew - bloop[index];
           
            bloop[index] = mew;

            //Knapsack
            double k[][] = new double[nobita + 1][mew + 1];
            for (int i = 0; i <= nobita; i++) {
                for (int w = 0; w <= mew; w++) {
                    if (i == 0 || w == 0) {
                        k[i][w] = 0;
                    } else if (bloop[i - 1] <= w) {
                        k[i][w] = Math.max(p[i - 1] + k[i - 1][w - bloop[i - 1]], k[i - 1][w]);
                    } else {
                        k[i][w] = k[i - 1][w];
                    }
                }
            }
            
            Stack<String> stack = new Stack<>();
            int j = mew;
            
            //printing the trophies
            for (int i = nobita; i > 0 && j > 0; i--) {
                if (k[i][j] == k[i - 1][j]) {
                    
                    if (index == i - 1) {
                        stack.add(club[i - 1]);
                    }
                } else {
                    stack.add(club[i - 1]);
                    j = j - bloop[i - 1];
                }
            }
            System.out.println("Name of clubs whose trophies were sold: ");
            while (stack.empty() == false) {
                System.out.print(stack.pop());
                if (stack.size() + 1 != 1) {
                    System.out.print(" --> ");
                }
            }
           
            k[nobita][mew] = k[nobita][mew] + p[index];
            System.out.println("");
            System.out.println("Maximum money he earned: " + k[nobita][mew] + " million");
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println("Wrong text file directory");
        }

    }
}
    

