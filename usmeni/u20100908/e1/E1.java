package usmeni.u20100908.e1;

public class E1 {
    static public void main(String[] args) {
        System.out.println("main 1");

        E3 e3 = new E3();
        E2 e2 = new E2(e3);

        e2.start();
        System.out.println("main 2");
    }

}

class E2 extends Thread {
    E3 e3;

    public E2(E3 e3) {
        this.e3 = e3;
        System.out.println("E2");
    }

    public void run() {
        for (int i = 1; i < 6; i++)
            System.out.println("E2 run");
    }

    public synchronized void start() {
        super.start();
        new Thread(e3).start();
    }
}

class E3 implements Runnable {
    public E3() {
        System.out.println("E3");
    }

    public void run() {
        for (int i = 1; i < 6; i++)
            System.out.println("E3 run");
    }

}
