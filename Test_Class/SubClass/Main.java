package Test_Class.SubClass;

public class Main {
    
    public static void main(String[] args) {
        
        // Example 1: Using Parent and Child
        Parent parent = new Parent("John");
        parent.displayInfo();

        Child child = new Child("Alice", 10);
        child.displayInfo();

    }
}
