import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import MyUtil.*;

class W5StackQueueTest {
    private W5Stack<Integer> stack;
    private W5Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        stack = new W5Stack<>();
        queue = new W5Queue<>();
    }

    // Stack Tests
    @Test
    void testStackPushPop() throws StackEmptyException {
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    void testStackUnderflow() {
        assertThrows(StackEmptyException.class, () -> {
            stack.pop();
        });
    }

    @Test
    void testStackSize() {
        assertEquals(0, stack.size());
        stack.push(5);
        stack.push(15);
        assertEquals(2, stack.size());
    }

    // Queue Tests
    @Test
    void testQueueEnqueueDequeue() throws QueueEmptyException {
        queue.enqueue(100);
        queue.enqueue(200);
        assertEquals(100, queue.dequeue());
        assertEquals(200, queue.dequeue());
    }

    @Test
    void testQueueUnderflow() {
        assertThrows(QueueEmptyException.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    void testQueueSize() {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
    }
}
