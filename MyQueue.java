import java.util.EmptyStackException;

public class MyQueue <T> {
    Node first;
    Node last;
    int size;

    MyQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue(T value) {
        Node n = new Node<>(value, null);
        if (last == null) {
            first = n;
            last = n;
        } else {
            last.setNext(n);
            last = n;
        }
        size++;
    }

    public Node dequeue() {
        if (size == 0) throw new EmptyStackException();
        if (size == 1) {
            Node f = first;
            first = null;
            last = null;
            size--;
            return f;
        } else {
            Node f = first;
            first = first.getNext();
            size--;
            return f;
        }
    }
    public String tostring() {
        if (size == 0) throw new EmptyStackException();
        else {
            String s = "[";
            Node cur = first;
            for (int i = 0; i < size; i++) {
                if (cur.getNext() == null) s += cur.getData() + "]";
                else {
                    s += cur.getData() + ",";
                    cur = cur.getNext();
                }
            }
            return s;
        }
    }

    public int size() {
        return size;
    }

    public boolean isempty() {
        return (first == null);
    }

    public T peek() {
        if (isempty()) throw new EmptyStackException();
        else
            return (T) first.getData();
    }

    public void addbyindex(T value, int index) {
        if (index < 0 || index > size) return;

        Node cur = first;
        int i = 0, c = size + 1;
        while (c-- != 0) {
            if (i == index) {
                this.enqueue(value);
                i++;
            } else {
                Node saved = cur;
                cur = cur.getNext();
                i++;
                this.dequeue();
                this.enqueue((T) saved.getData());

            }
        }
    }

    public T get(int x)
    {
        if( x<0 || x>=size)
            throw new ArrayIndexOutOfBoundsException("index not right");

        Node cur=first;
        while( x-- != 0)
        {
            cur=cur.getNext();
        }
        return (T) cur.getData();
    }
    public void deletebyindex(int index) {

        Node cur = first;
        Node node1 = cur;
        int i = 0;
        while (i <= size) {
            if (index == i) {
                node1 = cur;
                cur = cur.getNext();
                dequeue();
            } else {
                Node saved = cur;
                cur = cur.getNext();
                dequeue();
                enqueue((T)saved.getData());
            }
            i++;
        }
    }
}