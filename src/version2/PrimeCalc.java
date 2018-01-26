package version2;

public class PrimeCalc extends Thread {


    public void run(){ //2 βημα

        int checkingNow = Main.IncrementPrimeCounter(false,0); // o πίνακας primeData θα γεμίζει από τον primeCounter
        int n,k;

        while (true) { //υπολογισμος πρώτων
            boolean isPrime=true;
            n = checkingNow;      //παίρνουμε τον υπό εξέταση αριθμό από τον γεμισμένο primedata
            k=3;
            while (k*k <=n)
            {
                if (n%k ==0)
                {
                    isPrime=false;
                    break;
                }
                k +=2;
            }
            if (isPrime) checkingNow=Main.IncrementPrimeCounter(true,n);
            else checkingNow = Main.IncrementPrimeCounter(false,n);
        }
    }
}
