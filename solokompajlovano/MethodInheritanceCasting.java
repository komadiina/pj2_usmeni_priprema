package usmeni.primjercici;

public class MethodInheritanceCasting {
    public static void main(String[] args) {
        B3 b3 = new B3();
        b3.metoda();
        B2 b2 = b3;
        b2.metoda();
        B1 b1 = b2;
        b1.metoda();
    }
}
abstract class B1 {
    B1() {
        super();
        System.out.println("B1()");
    }

    void metoda() {
        System.out.println("B1 metoda...");
    }
}
abstract class B2 extends B1 {
    B2() {
        System.out.println("B2()");
    }
    abstract void metoda();
    void metoda2() {
        System.out.println("B2 metoda...");
    }
}
final class B3 extends B2 {
    B3() {
        super();
        System.out.println("B3()");
    }
    void metoda() {
        System.out.println("B3 metoda...");
    }
}
