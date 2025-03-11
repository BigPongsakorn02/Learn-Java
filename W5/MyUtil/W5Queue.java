package MyUtil;
import java.util.Vector;

public class W5Queue<T> {
    private Vector<T> queue;

    public W5Queue() {
        queue = new Vector<>();
    }

    public void enqueue(T item) {
        queue.add(item);
        System.out.println("Enqueued: " + item);
    }

    public T dequeue() throws QueueEmptyException {
        if (queue.isEmpty()) {
            throw new QueueEmptyException("Queue underflow");
        }
        return queue.remove(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}

