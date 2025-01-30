public abstract class Animal {
    int life;
    String name;

    public Animal() {
         this("unknown",100);
    }

    public Animal(String name,int x) {
        this.name = name;
        this.life = x;
    }

    abstract void talk();

    void showDetial() {
        System.out.println("Name: " + name);
        System.out.println("Life: " + life);
        System.out.println();
    }
}

