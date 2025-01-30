package W3_BasicOOP;

public class Cat extends Animal {
   
    String name;

    public Cat(String name, int life) {
        super(name,life);
    }

    void talk() {
        meow();
    }
    
    void meow() {
        System.out.println("Meow Meow!");
    }
}
