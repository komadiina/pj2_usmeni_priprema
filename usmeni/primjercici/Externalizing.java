package usmeni.primjercici;

import java.io.*;

public class Externalizing {
    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Player1 b1 = new Player1();
        Player2 b2 = new Player2();
        ObjectOutputStream o = new ObjectOutputStream(new
                FileOutputStream("Players.out"));
        System.out.println("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();
        ObjectInputStream in = new ObjectInputStream(new
                FileInputStream("Players.out"));
        System.out.println("Recovering b1:");
        b1 = (Player1) in.readObject();
        // OOPS! izuzetak!!!
        //! System.out.println("Recovering b2:");
        //! b2 = (Player2)in.readObject();
    }
}

class Player1 implements Externalizable {
    public Player1() {
        System.out.println("Player1 Constructor");
    }
    public void writeExternal(ObjectOutput out)
            throws IOException {
        System.out.println("Player1.writeExternal");
    }
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        System.out.println("Player1.readExternal");
    }
}

class Player2 implements Externalizable {
    Player2() {
        System.out.println("Player2 Constructor");
    }
    public void writeExternal(ObjectOutput out)
            throws IOException {
        System.out.println("Player2.writeExternal");
    }
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        System.out.println("Player2.readExternal");
    }
}
