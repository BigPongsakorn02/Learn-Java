package Test_Class;

public class Pokemon {
    
    String name;
    int level;

    Pokemon(String pName, int pLevel){
        name = pName;
        level = pLevel;
    }

    void attack(){
        System.out.println(name + "Attack!");
    }

}
