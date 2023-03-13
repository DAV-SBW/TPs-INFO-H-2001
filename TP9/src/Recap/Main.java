package Recap;

import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        test_save();
        test_load();
    }


    public static void test_save() throws Exception{
        HelloWorld test = new HelloWorld(5, "Hello");
        HelloWorld test2 = new HelloWorld(6, "Hello2");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hello.serial"));
        oos.writeObject(test);
        oos.writeObject(test);
        oos.writeObject(test2);
        oos.close();
        System.out.println("Saving");
        System.out.println("Object saved: " + test);
        System.out.println("Object saved: " + test);
        System.out.println("Object saved: " + test2 + "\n");
    }

    public static void test_load() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hello.serial"));
        Object t;
        System.out.println("Loading");
        do {
            try {
                t = ois.readObject();
                HelloWorld o = (HelloWorld) t;
                System.out.println("Object loaded: " + o);
            } catch (EOFException e){
                t = null;
            }
        } while (t != null);

    }
}
