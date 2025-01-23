public abstract class MyBuffer {
    final int items[];

    public MyBuffer() {
        this(10);
    }

    public MyBuffer(int x){
        items = new int[x];
        for(int i=0; i<x; i++)items[i] = 0;
    }

    void showBuffer(){
        System.out.printf("{");
        for(int i=0; i<items.length; i++){
            System.out.printf("%d",items[i]);
            System.out.println();
        }
    }

    double average(){
        double x=0;
        for(int i=0; i< items.length;i++) x+=items[i];
        return (items.length>0)?(x/items.length):0.0;}
}
