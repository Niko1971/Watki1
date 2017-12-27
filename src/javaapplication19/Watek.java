package javaapplication19;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Watek extends Thread {

    String name;
    int a = 0;

    Watek(int liczba) {
        this.a = liczba;
        System.out.println("Utworzono watek " + liczba);
    }

    public int generator() {
        String nowy = "";
        int nope = 0;
        Random generator = new Random();
        for (int j = 0; j < 1000; j++) {
            nope = generator.nextInt();
            nowy += nope;
        }
        return nope;
    }

    @Override
    public void run() {

        String filePath = "C:\\Users\\Bercik\\Desktop\\Bomba" + a;
        int number = generator();
        DataOutputStream outputStream = null;

        try {
            System.out.println(a + " wątek rozpoczyna prace");
            outputStream = new DataOutputStream(new FileOutputStream(filePath));
            for (int z = 0; z < 300000; z++) {
                outputStream.writeInt(number);
            }
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Przerwano prace watku " + name);
        } catch (IOException ex) {
            Logger.getLogger(Watek.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(Watek.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
