/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication43;

/**
 *
 * @author RHAPSODY
 */
public class Student {
     Student(){
        System.out.println("hello default student"); 
    }
     Student(String n){
        System.out.println("hello "+n);
}
    void quizcalc(int n){
        int cal= n/3;
        System.out.println("Your average quiz score is : "+cal );
        System.out.println("_ _ _ _ _ _ _ _");
    }
    void quizcalc(int n, int m){
        int cal= (n+m)/3;
        System.out.println("Your average quiz score is : "+cal );
        System.out.println("_ _ _ _ _ _ _ _");
    }
    void quizcalc(int n, int m, int o){
        int cal= (n+m+o)/3;
        System.out.println("Your average quiz score is : "+cal );
        System.out.println("_ _ _ _ _ _ _ _");
    }
}
