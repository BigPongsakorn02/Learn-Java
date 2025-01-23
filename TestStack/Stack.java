package TestStack;

public class Stack {

    static int st[]; // Static array to represent the stack
    static int top;  // Static variable to track the top of the stack

    // Initialize the stack with a fixed size
    static void init(int size) {
        st = new int[size];
        top = 0; // Start with an empty stack
    }

    // Push method to add an element to the stack
    static void push(int x) {
        if (top >= st.length) {
            System.out.println("Stack is full");
        } else {
            st[top++] = x; // Add the element and increment top
        }
    }

    // Pop method to remove an element from the stack
    static int pop() {
        if (top > 0) {
            return st[--top]; // Decrement top and return the element
        }
        System.out.println("Stack underflow");
        return 0;
    }

    public static void main(String[] args) {
        // Initialize the stack to hold 10 elements
        init(10);

        // Loop 11 times to push values 0-10 into the stack
        for (int i = 0; i <= 10; i++) {
            System.out.println("Pushing: " + i);
            push(i);
        }

        // Loop 11 times to pop all elements from the stack
        for (int i = 0; i <= 10; i++) {
            int poppedValue = pop();
            System.out.println("Popped: " + poppedValue);
        }
    }
}
