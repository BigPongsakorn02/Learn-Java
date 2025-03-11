package MyUtil;
import java.util.ArrayList;

public class W5Stack<T> {
    private ArrayList<T> stack;

    public W5Stack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
        System.out.println("Pushed: " + item);
    }

    public T pop() throws StackEmptyException {
        if (stack.isEmpty()) {
            throw new StackEmptyException("Stack underflow");
        }
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
