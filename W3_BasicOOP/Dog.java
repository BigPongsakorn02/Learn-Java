package W3_BasicOOP;

public class Dog extends Animal {
   
    String name;

    public Dog(String name, int life) {
        super(name,life);
    }

    void talk() {
        bark();
    }

    void bark() {
        System.out.println("Woof Woof!");
    }

    public void eat(Cat c) {
        System.out.println(name + " eats " + c.name);
    }
}
