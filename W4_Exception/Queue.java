public class Queue {
    int q[];//Array to store elements
    int head;//Head of the queue
    int tail;//Tail of the queue
    int size;//Size of the queue
    int count;//Number of elements in the queue

    public Queue(int size) {
        this.size = size;
        q = new int[size];
        head = 0;
        tail = 0;
        count = 0;
    }

    // public void enqueue(int x) {
    //     if (count == size) {
    //         System.out.println("Queue is full");
    //     } else {
    //         q[tail] = x;
    //         tail = (tail + 1) % size;
    //         count++;
    //         System.out.println("Enqueued: " + x);
    //     }
    // }

    public void enqueue(int x) {
        try {
            if (count == size) {
                throw new QueueFullException("Queue is full");
            }
            q[tail] = x;
            tail = (tail + 1) % size;
            count++;
            System.out.println("Enqueued: " + x);
        } catch (QueueFullException e) {
            System.out.println(e.getMessage());
        }
    }

    // public void dequeue() {
    //     if (count == 0) {
    //         System.out.println("Queue is empty");
    //     } else {
    //         int x = q[head];
    //         head = (head + 1) % size;
    //         count--;
    //         System.out.println("Dequeued: " + x);
    //     }
    // }

    public void dequeue() {
        try {
            if(count == 0) {
                throw new QueueEmptyException("Queue is empty");
            }else{
                int x = q[head];
                head = (head + 1) % size;
                count--;
                System.out.println("Dequeued: " + x);
            }   
        }
        catch (QueueEmptyException e) {
            System.out.println(e.getMessage());
        }
    }

    //Show
    public void show() {
        for (int i = 0; i < count; i++) {
            System.out.println(q[(head + i) % size]);
        }
    }
}
