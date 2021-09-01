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
public class LinkedList {
    /**
     * Reference address holder that points to the first node of the list.
     * The address is null if the list does not have any element.
     */
    private Node head;
    
    /**
     * Reference address holder that points to the last node of the list.
     * The address is null if the list does not have any element.
     */
    private Node tail;
    
    
    private int size;
    
    
    /**
     * Default Constructor
     */
    LinkedList()
    {
        //to be completed
    }
    
    /**
     * Returns the number of element present in the linked list.
     * @return the number of element present in the linked list.
     */
    public int size()
    {
        int count=0;
       for(Node n=head;n!=null;n=n.next){
           count++;
       }
        return count;
    }
    
    /**
     * Returns a boolean expression indicating whether the linked list is empty 
     * or not.
     * 
     * Returns true if the list is empty or false otherwise.
     * @return Boolean expression.
     */
    public boolean isEmpty()
    {
        if(head==null){
        return true;
    }
        else{
            return false;
        }
    }
    
    /**
     * Adds data at the end of the linked list.
     * @param e the information to be added
     */
    public void add(Object e)
    {
       Node newNode=new Node(e);
       if(head==null){
           head=newNode;
       }
       else
       {
           Node n=head;
        while(n.next!=null){
            n=n.next;
        }
        n.next=newNode;
       
    }
    }
    
    /**
     * Adds data at the specified index of the linked list.
     * 
     * if the index is n, then the data is inserted between (n-1)'th and n'th 
     * data or element.
     * @param index
     * @param e 
     */
    public void add(int index, Object e)
    {
      if(index<0||index>size()){
          throw new IndexOutOfBoundsException();
       }
      Node newNode=new Node(e,null);
      if(index==0){
          newNode.next=head;
          head=newNode;
      }
      else{
          Node predNode=NodeAt(index-1,head);
          Node nextNode =predNode.next;
          newNode.next=nextNode;
          predNode.next=newNode;
      }
    }
    
    /**
     * Returns the element or data which is stored at the specified index.
     * @param index The specified index.
     * @return The element which is being returned.
     */
    public Object get(int index)
    {
        int count=0;
        for(Node n=head;n!=null;n=n.next){
            if(index==count){
               return n.elem;
            }
            count++;
        }
        return null;
    }
    
    /**
     * Removes the element or data of the specified index.
     * @param index The specified index whose element is to be removed.
     * @return The element which is being removed.
     */
    public Object remove(int index)
    {
        //to be completed
        return null;
    }
    public Node NodeAt(int index,Node head){
        int Count=0;
        if(index<0){
            return null;
        }
        for(Node n=head;n!=null;n=n.next){
            if(Count==index){
                return n;
            }
            Count++;
        }
        return null;
    }
    
    @Override
   public String toString(){
        String s = "";
        for (Node n =head; n != null; n = n.next) {
            s += (n.elem);

        }
        return s;
    }
   
   public void show(){
       for(Node n=head;n!=null;n=n.next){
           System.out.print(n.elem+" ");
       }
   }
    
}

