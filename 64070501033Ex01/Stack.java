public class Stack {
    
    static int st[]; 
    static int top;
 
    static void init(int size) {
        st = new int[size]; //Create array
        top = 0; //Set top to 0
    }

    static void push(int x ) {
        if(top >= st.length){
            System.out.println("Stack is full");
        }
        else{
            st[top++] = x;
        }
    }

    static int pop() {
        if(top > 0){
            return st[--top];
        }
        System.out.println("Stack underflow");
        return 0;
    }

    static void pushPop(int time,boolean isPush){
        for(int i=0;i<time;i++){
            if(isPush){
                System.out.println("Pushing: " + i);
                push(i);
            }
            else{
                int poppedValue = pop();
                System.out.println("Popped: " + poppedValue);
            }
        }
    }

    public static void main(String[] args) {

        //System.out.println("Hello, World!");

        init(10);

        //System.out.println(st.length);//Check size of array

        pushPop(11,true);
        pushPop(11,false);

    }
}
