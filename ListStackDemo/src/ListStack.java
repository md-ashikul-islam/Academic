
public class ListStack implements Stack {

    Node head;

    @Override
    public void push(Object e) {
        Node n = new Node(e, head);
        head = n;
       
    }

    @Override
    public Object peek() {
        if (head == null) {
            System.out.println("Stack under Flow");
            return null;
        }
        return head.element;
    }

    @Override
    public Object pop() {
        if (head == null) {
            System.out.println("Stack under Flow");
            return null;
        }
        Node remove = head;
        head = head.next;
        remove.next = null;
        return remove.element;
    }
    public void show(){
        for(Node n=head;n!=null;n=n.next){
            System.out.println(n.element+" ");
        }
    }

}
