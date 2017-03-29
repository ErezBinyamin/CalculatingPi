import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();

        double pi = 9;
        System.out.println(pi);

        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }
}
