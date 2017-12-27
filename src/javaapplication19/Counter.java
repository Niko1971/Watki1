package javaapplication19;

public class Counter {

    private int c;

    Counter() {
        c = 0;
    }

    public void add() {
        c++;
    }

    public void rem() {
        c--;
    }

    public int ile() {
        return c;
    }
}
