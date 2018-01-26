package version2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    private static int temp=0;
    static Long startTime = System.nanoTime(); // Η μεταβλητή startTime μας δίνει τον χρόνο έναρξης της μέτρησης
    /**
     * Δηλώνουμε λίστα ακεραίων που θα αποθηκευτούν οι πρώτοι
     * Αυτό γίνεται γιατί δεν μπορώ να ελέγξω πότε τελειώνει το κάθε thread υπολογισμού πρώτου
     * οπότε το output δεν θα ήταν απαραίτητα με την σειρά (καθώς τους χρόνους εκτέλεσης τους καθορίζει ο scheduler
     * Λύση που σκέφτηκα να τους βάζω χύμα σε list την οποία μετά ταξινομώ, οπότε μπορώ να βρω τον n-οστό πρώτο
     * Η λίστα είναι μεγαλύτερη από το 1.000.000 για να σιγουρευτώ ότι θα έχω τον εκατομμυριοστό πρώτο για τον παραπάνω λόγο
     */
    private static List<Integer> listOfPrimes = new ArrayList<>();
    private static int numberToCheck=3, howManyPrimesFound=2;



    public static synchronized int IncrementPrimeCounter(boolean primeFound, int whichNumber) { //3 βημα

        if (howManyPrimesFound == 1000050) {
           // Collections.sort(listOfPrimes);
            Long endTime = System.nanoTime(); // Χρόνος τέλους
            double duration = ((double)endTime-(double)startTime)/1000000000;       // Διαιρούμε με 1.000.000.000 για να μετατρέψουμε τη διαφορά τελικής και αρχίκής μέτρησης σε sec
            System.out.println("Ο εκατομμυριοστός πρώτος= " + listOfPrimes.get(999997)); // Η λίστα ξεκινάει από το 0 (οπότε -1) και έχουμε βρει τους δύο πρώτους (-2)
            System.out.println("Χρόνος υπολογισμού " + duration);
            System.exit(0);
        }
        if (howManyPrimesFound == temp+100000) {
            System.out.println(howManyPrimesFound + " πρώτοι αριθμοί υπολογίστηκαν...");
            temp = temp+100000;
        }
        if (primeFound){
            listOfPrimes.add(whichNumber);
            howManyPrimesFound += 1;
            numberToCheck += 2;
        }
        else numberToCheck += 2;

        return numberToCheck;
    }

    public static void main(String[] args) { //1 βημα

        int cpuCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Εντοπίστηκαν "+ cpuCount + " λογικοί επεξεργαστές...");
        for (int i=1;i <= cpuCount; i++){
            PrimeCalc p = new PrimeCalc();
            System.out.println("Έναρξη "+i+"ου νήματος...");
            p.start();
        }
        System.out.println("Έναρξη υπολογισμού του εκατομμυριοστού Πρώτου αριθμού...");
    }

}
