package usmeni.test1.z2;

public class M1 {
    int id;
    M1 m1;
    M2 m2;
    char[] nizChar = new char[10_000_000];
    int[] nizInt = new int[5_000_000];
    M2 mArray[][] = new M2[3][2];

    public M1(int id) {
        System.out.println("M1: " + id);
        this.id = id;
    }

    public M1(M1 m1, int id, M2 m2) {
        System.out.println("M1: " + id);
        this.m1 = m1;
        this.m2 = m2;
        this.id = id;
    }

    @Override
    protected void finalize() {
        System.out.println(id + "finallize");
    }

    public static void main(String[] args) {
        M1 m10 = new M1(10);
        M2 m21 = new M2(m10, 21);
        M1 m11 = new M1(m10, 11, m21);
        M2 m22 = new M2(null, 22);
        M1 m12 = new M1(null, 12, m22);
        m12.mArray[0][0] = m22;
        m12.mArray[1][1] = new M2(23);
        m12.mArray[2][1] = new M2(24);
        m12.mArray[1] = null;
        System.gc();
        m10.mArray[1][0] = new M2(25);
        m11.m2 = m10.mArray[1][0];
        m11 = null;
        System.gc();
        m10.mArray[2][2] = new M2(new M1(1000), 26);
        System.gc(); // 1
    }
}

class M2 {
    float[] f = new float[2_500_000];
    M1 m1 = new M1(0);
    private int id2 = 0;

    public M2(M1 m1, int id2) {
        System.out.println("M2: " + id2);
        this.m1 = m1;
        this.id2 = id2;
    }

    public M2(int id2) {
        System.out.println("M2: " + id2);
        this.id2 = id2;
    }

    @Override
    protected void finalize() {
        System.out.println(id2 + "finallize");
    }
}