package Hospital;

public class WRM {

    Node head;
    Node tail = head;
    Node newNode;
    int size;
    int id;
    int regCapacity;

    public WRM() {
        regCapacity = 15;
        head = new Node(null, null, null);
        head.next = head.prev = head;
        size = 0;
        id = 100;
    }

    public void RegisterPatient(Patient p) {
        if (size == regCapacity) {
            System.out.println("Sorry,No more patient will be served today!");
        } else if (head.next == head) {
            newNode = new Node(p, null, null);
            newNode.next = head.next;
            newNode.prev = head;
            head.next = newNode;
            newNode.prev.next = newNode;
            tail = newNode;
            p.id = id;
            id++;
            size++;
            System.out.println("registration successful");
        } else {
            newNode = new Node(p, null, null);
            newNode.next = tail.next;
            newNode.prev = tail;
            tail.next = newNode;
            newNode.next.prev = newNode;
            tail = newNode;
            p.id = id;
            id++;
            size++;
            System.out.println("registration successful");
        }

    }

    public String ServePatient() {
        Node previous = null, nextNode = null, removeNode = null;
        Patient p2 = null;

        Patient p = (Patient) head.next.element;

        int min = p.id;
        int count = 0;

        for (Node n = head.next.next; n != head; n = n.next) {
            Patient pat = (Patient) n.element;

            if (min > pat.id) {

                count++;
                min = pat.id;
                p2 = (Patient) n.element;
                previous = n.prev;
                nextNode = n.next;

            }

        }
        if (count == 0) {
            previous = head.next.prev;
            nextNode = head.next.next;
            previous.next = nextNode;
            nextNode.prev = previous;
            size--;
            return p.Name;
        } else {
            previous.next = nextNode;
            nextNode.prev = previous;
            size--;
            return p2.Name;
        }
    }

    public void ShowAllPatient() {
        if(size==0){
            System.out.println("No Patient left");
        }
        for (Node n = head.next; n != head; n = n.next) {
            for (Node n2 = n.next; n2 != head; n2 = n2.next) {
                if (n.element != null && n2.element != null) {

                    Patient p = (Patient) n.element;
                    Patient p2 = (Patient) n2.element;

                    if (p.Name.compareTo(p2.Name) > 0) {

                        Patient sort = (Patient) n.element;
                        n.element = n2.element;
                        n2.element = sort;

                    }
                }
            }
        }
        for (Node n = head.next; n != head; n = n.next) {
            Patient p = (Patient) n.element;
            System.out.println(p.Name + "----" + p.age + "----" + p.BloodGroup + "----" + p.id);
        }
    }

    public boolean CanDoctorGoHome() {
        if (size == 0) {
            System.out.println("Yes,Doctor can go home");
            return true;
        } else {
            System.out.println("No,Doctor can't go home");
            return false;
        }
    }

    public void cancelAll() {
        Node store1, store2;
        if (head == null) {
            System.out.println("Failure");
            System.out.println("Your Patient List is already empty");
        } else {
            head = null;
            System.out.println("Success!");
            System.out.println("All appointments are cancelled");
        }
    }

}
