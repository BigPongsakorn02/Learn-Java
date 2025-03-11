import MyUtil.*;

public class MainApp {
    public static void main(String[] args) {
        W5Stack<Integer> stack = new W5Stack<>();
        W5Queue<String> queue = new W5Queue<>();

        try {
            stack.push(10);
            stack.push(20);
            System.out.println("Popped: " + stack.pop());

            queue.enqueue("Apple");
            queue.enqueue("Banana");
            System.out.println("Dequeued: " + queue.dequeue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
