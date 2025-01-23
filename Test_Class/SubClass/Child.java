package Test_Class.SubClass;

// Child class extends Parent
public class Child extends Parent {
    
    int age;

    public Child(String name, int age) {

        super(name); // Call Parent constructor

        this.age = age;
        
        System.out.println("Child Constructor Called: Age is " + age);
    }

}
