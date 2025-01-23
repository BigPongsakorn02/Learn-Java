public class MyApp {
    public static void main(String[] args) {
        int i;
        Stack st;
        Queue q;

        st = new Stack(10);
        q = new Queue(10);

        //Test 01
        for(i=0; i<11; i++){
            st.push(i);
            q.enqueue(i);
        } 
        for(i=0;i<10;i++){
            System.out.printf("%d,%d\n", st.pop(), q.dequeue());
        }

        //System.out.println("--------");//Separate the output

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

