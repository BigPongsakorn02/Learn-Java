public class MainAppException {
    
    public static void main(String[] args) {

        StackW2 s = new StackW2(5);
        
        for(int i=0;i<6;i++){
            s.push(i);
        }

        for(int i=0;i<6;i++){
            s.pop();
        }

        QueueW2 q = new QueueW2(5);

        for(int i=0;i<6;i++){
            q.enqueue(i);
        }

        for(int i=0;i<6;i++){
            q.dequeue();
        }

    }


}
