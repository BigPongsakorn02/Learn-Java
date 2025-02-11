public class Test_Exception {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        int[] number = {1,2,3,4,5};

        try {
            //  Block of code to try
            System.out.println(number[10]);//Error
          }
          catch(Exception e) {
            //  Block of code to handle errors
            System.out.println("Array index out of bounds");
          }
          finally {
            System.out.println("The 'try catch' is finished");
          }
        
        
    }
}