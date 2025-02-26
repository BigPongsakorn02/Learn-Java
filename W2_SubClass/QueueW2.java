public class QueueW2 extends MyBuffer{ 
    int head;
    int tail;
    int count;

    public QueueW2(int x){
        super(x);
        head = 0;
        tail = 0;
        count = 0;
    }

    public void enqueue(int x){
        if(count == items.length){
            System.out.println("Queue is full");
        }
        else{
            items[tail] = x;
            tail = (tail+1)%items.length;
            count++;
        }
    }

    public int dequeue(){
        if(count > 0){
            int x = items[head];
            head = (head+1)%items.length;
            count--;
            return x;
        }
        else {
            System.out.println("Queue underflow");
            return -1;
        }
    }
}
