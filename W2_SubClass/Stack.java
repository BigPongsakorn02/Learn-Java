//Extends MyBuffer inheritance to Stack
public class Stack extends MyBuffer{

    int top;

    public Stack(int x){
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