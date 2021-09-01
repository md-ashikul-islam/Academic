/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist.template;

/**
 *
 * @author RHAPSODY
 */
public class CodeRunner {
    public static void main(String[] args){
     LinkedList list=new LinkedList();
     list.add(5);
     list.add(10);
     list.add(15);
     list.add(20);
     list.add(4, 100);
     System.out.println(list.isEmpty());
     System.out.println(list.get(2));
     System.out.println(list.size());
     list.show();
    }
}
