
package cse221.lab05;

import java.util.Stack;
public class CSE221Lab05 {

 
    public static void main(String[] args) {
    System.out.println("-----------------------Problem1-----------------------");
        System.out.println();
        String one = "C D E F G A B C";   //given note
        String two = "C E F D A B G A C";  //played note by student
        String[] string1 = one.split(" ");
        String[] string2 = two.split(" ");
        int matrix[][] = new int[string1.length + 1][string2.length + 1];
        Stack<String> stack = LCS(matrix, string1, string2);
        while (stack.empty() == false) {
            System.out.print(stack.pop());
        }
        System.out.println("");
        double ac = (((float) matrix[string1.length][string2.length]) / string1.length) * 100;
        ac = Math.round(ac * 10.0) / 10.0;
        System.out.println(ac + "% PASSED");

        System.out.println();
        System.out.println("-----------------------Problem2-----------------------");
        System.out.println();
        String one1 = "M W C A D B O E";
        String two2 = "D M W C A R O P";
        String[] string3 = one1.split(" ");
        String[] string4 = two2.split(" ");
        int matrix1[][] = new int[string3.length + 1][string4.length + 1];
        Stack<String> stack1 = LCS(matrix1, string3, string4);
        System.out.println(stack1.size());
        while (stack1.empty() == false) {
            switch (stack1.pop()) {
                case "M":
                    System.out.print("monkeys");
                    break;
                case "W":
                    System.out.print("wearing");
                    break;
                case "C":
                    System.out.print("coats");
                    break;
                case "A":
                    System.out.print("are");
                    break;
                case "D":
                    System.out.print("doctors");
                case "B":
                    System.out.print("because");
                    break;
                case "E":
                    System.out.print("evolution");
                    break;
                case "O":
                    System.out.print("of");
                    break;
                case "R":
                    System.out.print("results");
                case "P":
                    System.out.print("eruption");
                    break;
            }
            System.out.print(" ");
        }
    }

    static Stack<String> LCS(int matrix[][], String string1[], String string2[]) {
        //finding the ongest common sequence
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                } else if (string1[i - 1].equals(string2[j - 1])) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        //finding the longest common subsequence
        //starting from the last right most conrner
        int i = string1.length;
        int j = string2.length;
        //to store the subsequence
        Stack<String> stack = new Stack<>();
        while (i > 0 && j > 0) {
            //if both aphabate matches then the are part of lcs sub sequence
            if (string1[i - 1].equals(string2[j - 1])) {
                stack.add(string1[i - 1]);
                //going to their prev index
                i--;
                j--;
            } //if not same then go towards larger direction
            else if (matrix[i - 1][j] > matrix[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return stack;
    }
}
