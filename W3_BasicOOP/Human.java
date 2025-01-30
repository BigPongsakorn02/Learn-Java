public class Human extends Animal {

    public Human(String name, int life) {
        super(name, life);
    }

    void talk() {
        Hello();
    }

    void Hello() {
        System.out.println("Hello!");
    }
}
