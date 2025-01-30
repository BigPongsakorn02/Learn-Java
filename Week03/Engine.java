package Week03;

public class Engine {
    private Wheel left;//Declare the left object of the Wheel class
    private Wheel right;//Declare the right object of the Wheel class
    private boolean started;

    public Engine(Wheel left, Wheel right) {
        // left = new Wheel();
        this.left = left;
        // right = new Wheel();
        this.right = right;
    }

    public void start() {
        started = true;
        System.out.println("Engine is started");
        System.out.println();
    }

    public void drive() {
        if (started) {
            left.rotate("Left");
            right.rotate("Right");
            System.out.println();
        } else {
            System.out.println("Engine is not started");
            
        }
    }
}
