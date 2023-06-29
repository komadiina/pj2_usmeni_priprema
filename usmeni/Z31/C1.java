package usmeni.Z31;

// C1.java

class C1 {

    C1() {
        System.out.println("C1()");
    }

    public static void main(String[] args) {
        C1 c1 = new C1();
        C3 c3 = new C3();
        try {
            System.out.println("main 1");
            c1.metoda();
            c3.metoda();
        } catch (CE2 e) {
            System.out.println("main 2: " + e);
        } catch (CE1 e) {
            System.out.println("main 3: " + e);
        } catch (Exception e) {
            System.out.println("main 4: " + e);
        } catch (Throwable e) {
            System.out.println("main 5: " + e);
        }
    }

    void metoda() throws Throwable {
        C2 c2 = new C2();
        try {
            c2.metoda();
            System.out.println("C1: metoda()");
        } finally {
            System.out.println("finally");
        }
    }
}

class C2 extends C1 {
    C2() {
        System.out.println("C2()");
    }

    void metoda() throws CE1 {
        try {
            C3 c3 = new C3();
            System.out.println("C2: metoda()");
            c3.metoda();
        } catch (CE2 ex) {
            throw new CE1("CE1");
        } finally {
            return;
        }

    }
}

class C3 extends C2 {
    C3() {
        System.out.println("C3()");
    }

    protected void metoda() throws CE1 {
        try {
            System.out.println("C3: metoda()");
            throw new CE2("CE2");
        } catch (CE1 ex) {
            System.out.println("catch 1...");
            throw new CE2("Rethrown");
        } finally {
            System.out.println("finally");
        }
    }
}

class CE1 extends Exception {
    String name;

    CE1(String s) {
        super(s);
        System.out.println("CE1: " + name);
    }
}

class CE2 extends CE1 {
    CE2(String s) {
        super(s);
        System.out.println("CE2: " + name);
    }
}