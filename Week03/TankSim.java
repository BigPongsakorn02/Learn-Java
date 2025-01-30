package Week03;

public class TankSim {
    public void driver(Tank tank) {
        tank.driveTank();
        tank.startTank();
        
    }

    public static void main(String[] args) {
        Tank tank1 = new Tank();
        tank1.startTank();
        tank1.driveTank();
        tank1.turnTank(true);

        // Tank tank2 = new Tank();
        // tank2.startTank();
    }
}
