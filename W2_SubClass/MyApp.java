public class MyApp {
    public static void main(String[] args) {
        int i;
        Stack st = new Stack(10); //Call the Stack class with the size of 10
        Queue q = new Queue(10); //Call the Queue class with the size of 10

        st.showBufferWeek2();
        q.showBufferWeek2();
        //Test 01
        for(i=0; i<11; i++){
            st.push(i);
            q.enqueue(i);
        } 
        st.showBufferWeek2();
        q.showBufferWeek2();
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

