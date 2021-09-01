package cse221_knapsack;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


public class Problem2 {

    
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\RHAPSODY\\Documents\\NetBeansProjects\\CSE221_Knapsack\\src\\cse221_knapsack\\prob2.txt");
            Scanner sc = new Scanner(file);
            int m = Integer.parseInt(sc.nextLine());
            int n = Integer.parseInt(sc.nextLine());
            String club[] = new String[n];
            double p[] = new double[n];
            int wt[] = new int[n];
            String trophy[] = new String[n];
            for (int i = 0; i < n; i++) {
                String[] StringArray1 = sc.nextLine().split(", ");
                club[i] = StringArray1[0];
                wt[i] = Integer.parseInt(StringArray1[1]);
                p[i] = Double.parseDouble(StringArray1[2]);
                trophy[i] = StringArray1[3];
            }
            
            double Profit = 0.0;
            //index is used to store the index number of best profit trophy
            int index = -1;
            for (int i = 0; i < n; i++) {
                if (trophy[i].equals("Champion’s League")) {
                    double temp = (p[i] / wt[i]) * 100;
                    if (temp > Profit) {
                        Profit = temp;
                        index = i;
                    }
                }
            }
            /*as we took the best option for champions League trophy in the bag 
            we are reducing the bag capacity with that trophy weight   */
            
            m = m - wt[index];
            /*in the next line, i just applied a simple trick so that knapsack algo
            will avoid that champions League index. am increasing the weight of
            that trophy so that knap sack ignores it. Maybe it could have done inside 
            of the loop with if condiotion.but i found it as an easier solve*/
            
            wt[index] = m;

            //Knapsack
            double k[][] = new double[n + 1][m + 1];
            for (int i = 0; i <= n; i++) {
                for (int w = 0; w <= m; w++) {
                    if (i == 0 || w == 0) {
                        k[i][w] = 0;
                    } else if (wt[i - 1] <= w) {
                        k[i][w] = Math.max(p[i - 1] + k[i - 1][w - wt[i - 1]], k[i - 1][w]);
                    } else {
                        k[i][w] = k[i - 1][w];
                    }
                }
            }
            
            Stack<String> stack = new Stack<>();
            int j = m;
            
            //printing the trophies
            for (int i = n; i > 0 && j > 0; i--) {
                if (k[i][j] == k[i - 1][j]) {
                    /*if my champions League index mathches with iterator then 
                    am printing it */
                    if (index == i - 1) {
                        stack.add(club[i - 1]);
                    }
                } else {
                    stack.add(club[i - 1]);
                    j = j - wt[i - 1];
                }
            }
            System.out.println("Name of clubs whose trophies were sold: ");
            while (stack.empty() == false) {
                System.out.print(stack.pop());
                if (stack.size() + 1 != 1) {
                    System.out.print(" --> ");
                }
            }
            //adding the price of selected champions league price with other ones.
            k[n][m] = k[n][m] + p[index];
            System.out.println("");
            System.out.println("Maximum money he earned: " + k[n][m] + " million");
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println("Add correct input text file directory");
        }
    }
}

