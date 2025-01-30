package Week03;

public class Tank {
    private Wheel leftWheel = new Wheel();//Call the Wheel class to create a new object
    private Wheel rightWheel = new Wheel();//Call the Wheel class to create a new object

    private Engine engine = new Engine(rightWheel, leftWheel);//Call the Engine class to create a new object

    public void startTank()// 
    {
        engine.start();
    }

    public void driveTank() {
        engine.drive();
    }

    public void turnTank(boolean left) {
        if (left) {
            System.out.println("Turning left");
            leftWheel.stop("Left");
            rightWheel.rotate("Right");
            System.out.println();
        } else {
            System.out.println("Turning right");
            leftWheel.rotate("Left");
            rightWheel.stop("Right");
            System.out.println();
        }
    }
}
