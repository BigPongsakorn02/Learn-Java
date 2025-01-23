public class Stack extends MyBuffer{
    int top;

    public Stack(){
        super(10);
    }

    public Stack(int x){
        super(x);
        top = -1;
    }
    

}