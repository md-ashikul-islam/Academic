package cse221_knapsack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


public class problem1 {

    
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\RHAPSODY\\Documents\\NetBeansProjects\\CSE221_Knapsack\\src\\cse221_knapsack\\prob1.txt");
            Scanner sc = new Scanner(file);
            int m = Integer.parseInt(sc.nextLine());
            int n = Integer.parseInt(sc.nextLine());
            String players[] = new String[n];
            int p[] = new int[n];
            int wt[] = new int[n];
            String position[] = new String[n];
            for (int i = 0; i < n; i++) {
                String[] StringArray1 = sc.nextLine().split(", ");
                players[i] = StringArray1[0];
                wt[i] = Integer.parseInt(StringArray1[1]);
                p[i] = Integer.parseInt(StringArray1[2]);
                position[i] = StringArray1[3];
            }
            //Knapsack
            int k[][] = new int[n + 1][m + 1];
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
            //printing the items
            int j = m;
            for (int i = n; i > 0 && j > 0; i--) {
                if (k[i][j] == k[i - 1][j]) {
                } else {
                    stack.add(players[i - 1]);
                    j = j - wt[i - 1];
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
            System.out.println("Maximum summation of form: " + k[n][m]);
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println("Add correct input text file directory");
        }

    }
}
