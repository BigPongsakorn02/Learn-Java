public class Queue {
    int q[];
    int head;
    int tail;
    int size;
    int count;

    public Queue(int size) {
        this.size = size;
        q = new int[size];
        head = 0;
        tail = 0;
        count = 0;
    }

    public void enqueue(int x) {
        if (count == size) {
            System.out.println("Queue is full");
        } else {
            q[tail] = x;
            tail = (tail + 1) % size;
            count++;
        }
    }

    public int dequeue() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return 0;
        } else {
            int x = q[head];
            head = (head + 1) % size;
            count--;
            return x;
        }
    }

    //Show
    public void show() {
        for (int i = 0; i < count; i++) {
            System.out.println(q[(head + i) % size]);
        }
    }

    //Main
    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        //q.show();
    }
}
