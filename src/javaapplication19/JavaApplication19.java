package javaapplication19;

public class JavaApplication19 {

    private static final int ILE = 10;

    public static void main(String args[]) throws InterruptedException {
        Watek[] watekPool = new Watek[ILE];

        for (int i = 0; i < ILE; i++) {
            watekPool[i] = new Watek(i);
            watekPool[i].start();
            watekPool[i].join();
        }

    }
}
