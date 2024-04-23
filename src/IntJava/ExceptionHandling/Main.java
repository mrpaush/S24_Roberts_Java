package IntJava.ExceptionHandling;

//public class Main {
//    public static void main(String[] args) {
//        try {
//            String s = "abc";
//            int x = Integer.parseInt(s);
//            int data = 50/0; //may throw exception
//        }
//        catch(Exception x) {
//            System.out.println("this is an error");
//        }
//        System.out.println("rest of the code");
//    }
//}

//public class Main{
//    void m(){
//        int data=50/0;
//    }
//    void n(){
//        m();
//    }
//    void p(){
//        try{
//            n();
//        }catch(Exception e){System.out.println("exception handled");}
//    }
//    public static void main(String args[]){
//        Main obj=new Main();
//        obj.p();
//        System.out.println("normal flow...");
//    }
//}

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            FileWriter writer = new FileWriter("blab.txt");
            writer.write("hello world");
            writer.close();
        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            System.out.println("File closed");
        }
    }
    
}

