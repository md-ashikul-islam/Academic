package arraystackdemo;

public class ArrayStackDemo implements Stack {

    Object[] a;
    int size;

    public ArrayStackDemo() {
        a = new Object[5];
        size = 0;
    }

    @Override
    public void push(Object e) {
        if (size == a.length) {
            System.out.println(" Stack over Flow!");
            return;
        }
        a[size] = e;
        size++;
    }

    @Override
    public Object peek() {
        if (size == 0) {
            System.out.println("Stack Under Flow!");
            return null;
        }
        Object value = a[size - 1];
        return value;
    }

    @Override
    public Object pop() {
        if (size == 0) {
            System.out.println("Stack Under Flow!");
            return null;
        }
        Object value = a[size - 1];
        a[size - 1] = null;
        size--;
        return value;
    }
    public void show(){
        ArrayStackDemo f=new ArrayStackDemo();
        for(int i=a.length-1;i>=0;i--){
            System.out.print(a[i]+" ");
        }
    }

}
