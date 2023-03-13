package Recap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HelloWorld extends A implements Serializable {
    private int quantity;
    private transient String name;

    public HelloWorld(int x, String n){
        super(20);
        this.quantity = x;
        this.name = n;
    }

    public String toString(){
        return name + " " + quantity + " " + age;
    }


    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(name);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        name = ((String)in.readObject()) + "_saved";
    }
}
