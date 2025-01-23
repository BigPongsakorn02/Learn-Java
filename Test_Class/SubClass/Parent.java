package Test_Class.SubClass;

// Base Parent Class
public class Parent {

    String name;

    // Constructor
    public Parent(String name){
        this.name = name;
        System.out.println("Parent constructor called " + name);
    }

    // A method for all subclasses to inherit
    // A method to display the name of the parent
    public void displayInfo(){
        System.out.println("Parent : My name is " + name);  
    }
}
