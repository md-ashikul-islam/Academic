package cohensutherland;


import java.util.Scanner;

public class CohenSutherland {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Range of Window
        System.out.println("Enter Xmin & Ymin (Starting Point)");
        int Xmin = sc.nextInt();
        int Ymin = sc.nextInt();
        System.out.println("Enter Xmax & Ymax (Ending Point)");
        int Xmax = sc.nextInt();
        int Ymax = sc.nextInt();

        //Point of Line Given
        System.out.println("Enter X1 & Y1 of Your Point");
        float X1 = sc.nextFloat();
        float Y1 = sc.nextFloat();
        System.out.println("Enter X2 & Y2 of Your Point");
        float X2 = sc.nextFloat();
        float Y2 = sc.nextFloat();

        //Slope M
        float m = (Y2 - Y1) / (X2 - X1);

        //Outcode 
        int[] code1 = oppcode(X1, Y1, Ymax, Ymin, Xmax, Xmin);
        int[] code2 = oppcode(X2, Y2, Ymax, Ymin, Xmax, Xmin);
        //Print
        System.out.println();
        System.out.println("Outcode (X1,Y1): " + code1[0] + code1[1] + code1[2] + code1[3]);
        System.out.println("Outcode (X2,Y2): " + code2[0] + code2[1] + code2[2] + code2[3]);

        float x=0;
        float y=0;
        if (code1[0] == 1) {
            y = Ymax;
            x = X1 + ((1 / m) * (Ymax - Y1));
            code1 = oppcode(x, y, Ymax, Ymin, Xmax, Xmin);
            System.out.println();
            System.out.println("(X1',Y1'): (" + x + ", " + y + ")");
            System.out.println("Outcode (X1',Y1'): " + code1[0] + code1[1] + code1[2] + code1[3]);
        }
        if (code1[1] == 1) {
            y = Ymin;
            x = X1 + ((1 / m) * (Ymin - Y1));
            code1 = oppcode(x, y, Ymax, Ymin, Xmax, Xmin);
            System.out.println();
            System.out.println("(X1',Y1'): (" + x + ", " + y + ")");
            System.out.println("Outcode (X1',Y1'): " + code1[0] + code1[1] + code1[2] + code1[3]);
        }
        if (code1[2] == 1) {
            x = Xmax;
            y = Y1 + (m * (Xmax - X1));
            code1 = oppcode(x, y, Ymax, Ymin, Xmax, Xmin);
            System.out.println();
            System.out.println("(X1',Y1'): (" + x + ", " + y + ")");
            System.out.println("Outcode (X1',Y1'): " + code1[0] + code1[1] + code1[2] + code1[3]);
        }
        if (code1[3] == 1) {
            x = Xmin;
            y = Y1 + (m * (Xmin - X1));
            code1 = oppcode(x, y, Ymax, Ymin, Xmax, Xmin);
            System.out.println();
            System.out.println("(X1',Y1'): (" + x + ", " + y + ")");
            System.out.println("Outcode (X1',Y1'): " + code1[0] + code1[1] + code1[2] + code1[3]);
        }

        if (code2[0] == 1) {
            y = Ymax;
            x = X1 + ((1 / m) * (Ymax - Y1));
            code2 = oppcode(x, y, Ymax, Ymin, Xmax, Xmin);
            System.out.println();
            System.out.println("(X2',Y2'): (" + x + ", " + y + ")");
            System.out.println("Outcode (X2',Y2'): " + code2[0] + code2[1] + code2[2] + code2[3]);
        }
        if (code2[1] == 1) {
            y = Ymin;
            x = X1 + ((1 / m) * (Ymin - Y1));
            code2 = oppcode(x, y, Ymax, Ymin, Xmax, Xmin);
            System.out.println();
            System.out.println("(X2',Y2'): (" + x + ", " + y + ")");
            System.out.println("Outcode (X2',Y2'): " + code2[0] + code2[1] + code2[2] + code2[3]);
        }
        if (code2[2] == 1) {
            x = Xmax;
            y = Y1 + (m * (Xmax - X1));
            code2 = oppcode(x, y, Ymax, Ymin, Xmax, Xmin);
            System.out.println();
            System.out.println("(X2',Y2'): (" + x + ", " + y + ")");
            System.out.println("Outcode (X2',Y2'): " + code2[0] + code2[1] + code2[2] + code2[3]);
        }
        if (code2[3] == 1) {
            x = Xmin;
            y = Y1 + (m * (Xmin - X1));
            code2 = oppcode(x, y, Ymax, Ymin, Xmax, Xmin);
            System.out.println();
            System.out.println("(X2',Y2'): (" + x + ", " + y + ")");
            System.out.println("Outcode (X2',Y2'): " + code2[0] + code2[1] + code2[2] + code2[3]);
        }
    }

    //Oppcode
    public static int[] oppcode(float x, float y, int Ymax, int Ymin, int Xmax, int Xmin) {
        int[] code = new int[4];
        if (y > Ymax) {
            code[0] = 1;
        }
        if (y < Ymin) {
            code[1] = 1;
        }
        if (x > Xmax) {
            code[2] = 1;
        }
        if (x < Xmin) {
            code[3] = 1;
        }
        return code;
    }
}
