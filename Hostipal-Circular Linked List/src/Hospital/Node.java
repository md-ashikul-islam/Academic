package Hospital;


public class Node {
        Node next;
	Node prev;
        Object element;
	
	public Node(Object e, Node n, Node p)
	{
		element=e;
		next=n;
		prev=p;
	}
}
