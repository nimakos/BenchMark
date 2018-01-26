package version1;

public final class a extends Thread {

    public final void run() {
        int var1 = Main1.sda(false, 0);

        while(true) {
            boolean var3 = true;

            for(int var2 = 3; var2 * var2 <= var1; var2 += 2) {
                if(var1 % var2 == 0) {
                    var3 = false;
                    break;
                }
            }

            if(var3) {
                var1 = Main1.sda(true, var1);
            } else {
                var1 = Main1.sda(false, var1);
            }
        }
    }
}
