public class MainAppException {
    
    public static void main(String[] args) {

        Stack s = new Stack(5);
        
        for(int i=0;i<6;i++){
            s.push(i);
        }

        for(int i=0;i<6;i++){
            s.pop();
        }

        Queue q = new Queue(5);

        for(int i=0;i<6;i++){
            q.enqueue(i);
        }

        for(int i=0;i<6;i++){
            q.dequeue();
        }

    }


}
