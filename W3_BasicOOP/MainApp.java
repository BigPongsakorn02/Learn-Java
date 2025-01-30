package W3_BasicOOP;

public class MainApp {
        public static void main(String[] args){

            // Dog d = new Dog();
            // d.talk();

            Animal[] x;
            Dog d;
            Cat c;
            Human h;
            
            x = new Animal[3];
            x[0] = d = new Dog("Goofy", 50);
            x[1] = c = new Cat("Tom", 30);
            x[2] = h = new Human("John", 100);

            for (int i = 0; i < 3; i++) {
                x[i].talk();
            }
            System.out.println();

            // x[0].eat();//Because x[0] is Animal type not Dog type

            // d.eat();//Because eat() method in Dog class need Cat type

            //d.eat(c);//Because eat() method in Dog class need Cat type

            //((Dog)x[0]).eat(c);

            //((Dog) x[0]).bark();

            //x[0].bark();//Because x[0] is Animal type not Dog type

            //((Dog) x[1]).bark();//Because x[1] is Cat type not Dog type

            for(Animal a : x){
                a.showDetial();
                
                if(a instanceof Cat)((Cat)a).meow();
                else if(a instanceof Dog)((Dog)a).bark();
                else a.talk();
            }
            
        }
}
