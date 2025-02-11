

public class Stack {
    
    static int st[]; 
    static int top;
 
    public Stack(int size) {
        st = new int[size]; //Create array
        top = 0; //Set top to 0
    }

    public void push(int x) {
        try {
            if (top >= st.length) {
                throw new StackFullException("Stack is full");
            }
            st[top++] = x;
            System.out.println("Pushed: " + x);
        } catch (StackFullException e) {
            System.out.println(e.getMessage());
        }
    }

    public void pop() {
        try {
            if (top <= 0) {
                throw new StackEmptyException("Stack underflow");
            }
            System.out.println("Popped: " + st[--top]);
        } catch (StackEmptyException e) {
            System.out.println(e.getMessage());
        }
    }
}
