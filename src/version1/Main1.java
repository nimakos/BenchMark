//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package version1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1 {

    private static Long startTime = System.nanoTime(); //επιστρεφει την τωρινη ωρα σε nanosec
    private static List a1 = new ArrayList();
    private static int b = 3;
    private static int c = 2;

    public static synchronized int sda(boolean var0, int var1)
    {
        if(c == 1000010) {
            Collections.sort(a1);
            double holeTime = ((double) System.nanoTime() - (double) startTime) / 1.0E9D;
            System.out.println("Ο εκατομμυριοστός πρώτος= " + a1.get(999997));
            System.out.println("Χρόνος υπολογισμού " + holeTime);
            System.exit(0);
        }

        int var2;
        if(c % 100000 == 0 && (var2 = c / 100000) > startTime) {
            System.out.println(c + " πρώτοι αριθμοί υπολογίστηκαν...");
            startTime =(long) var2;
        }

        if(var0) {
            a1.add(var1);
            ++c;
        }

        return b += 2;
    }

    public static void main(String[] var0) {
        int NumberOfCpu = Runtime.getRuntime().availableProcessors();
        System.out.println("Εντοπίστηκαν " + NumberOfCpu + " λογικοί επεξεργαστές...");

        for(int i = 1; i < NumberOfCpu - 1; ++i) {
            a var2 = new a();
            System.out.println("Έναρξη " + i + "ου νήματος...");
            var2.start();
        }

        System.out.println("Έναρξη υπολογισμού του εκατομμυριοστού Πρώτου αριθμού...");
    }
}