package linkedlist.template;


public class Node{
    Node next;
    Object elem;
    
    Node(Object e, Node n)
    {
        elem = e;
        next = n;
    }
    Node(Object e)
    {
        elem=e;
    }
    
    public String toString()
    {
        return elem.toString();
    }
    
}
