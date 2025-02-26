//Extends MyBuffer inheritance to Stack
public class StackW2 extends MyBuffer{

    int top;

    public StackW2(int x){
        super(x); 
        top = 0;
    }

    public void push(int x){
        if(top==items.length){
            System.out.println("Stack is full");
        }
        else{
            items[top++] = x;
        }
    }

    public int pop() {
        if(top > 0){
            return items[--top];
        }
        else {
            System.out.println("Stack underflow");
            return -1;
        }
    }
}