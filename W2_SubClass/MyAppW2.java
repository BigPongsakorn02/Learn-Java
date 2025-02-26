public class MyAppW2 {
    public static void main(String[] args) {
        int i;
        StackW2 st = new StackW2(10); //Call the Stack class with the size of 10
        QueueW2 q = new QueueW2(10); //Call the Queue class with the size of 10

        st.showBuffer();
        q.showBuffer();
        //Test 01
        for(i=0; i<11; i++){
            st.push(i);
            q.enqueue(i);
        } 
        st.showBuffer();
        q.showBuffer();
        for(i=0;i<10;i++){
            System.out.printf("%d,%d\n", st.pop(), q.dequeue());
        }

        //System.out.println("--------");//Separate the output
        st.showBuffer();
        q.showBuffer();

        //Test 02
        for(i=0; i<10; i++){
            st.push(i);
            q.enqueue(i);
        } 
        for(i=0;i<11;i++){
            System.out.printf("%d,%d\n", st.pop(), q.dequeue());
        }

    }
}

