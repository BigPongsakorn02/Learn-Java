package Test_Class;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        Pokemon p1 = new Pokemon("Pikachu",10);

        System.out.println(p1.name);
        p1.attack();
}
}