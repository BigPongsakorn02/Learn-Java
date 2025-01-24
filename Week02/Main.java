package Week02;

public class Main {
    public static void main(String[] args){
        
        //Inheritance = the process where one class acquires 
        //              the attributes and methods of another

        Car car = new Car();
        car.go();

        Bicycle bicycle = new Bicycle();
        bicycle.stop();

        System.out.println(car.Vehicletype + " is " + car.speed);
        System.out.println(bicycle.speed);

        System.out.println(car.wheels);
        System.out.println(bicycle.wheels);

        System.out.println(car.doors);
        System.out.println(bicycle.pedals);
    }
}
