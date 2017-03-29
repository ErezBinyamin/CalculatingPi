package ArcTan_approxiamtions;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Erez on 12/9/201n.
 */
public class Equations
{
    private static int n;
    private static BigDecimal x;
    private static final BigDecimal four = BigDecimal.valueOf(4);
    private static BigDecimal pi_1;
    private static BigDecimal pi_2;
    private static BigDecimal pi_3;
    private static BigDecimal pi_4;
    private static BigDecimal arcTan;

    private static long startA;
    private static long endA;
    private static long startB;
    private static long endB;
    private static long startC;
    private static long endC;
    private static long startD;
    private static long endD;
    private static long startArcTan;
    private static long endArcTan;

    public Equations(BigDecimal x, int n)
    {
        this.n = n;
        this.x = x;
    }

    public static void main(String[] args)
    {
        startA = System.currentTimeMillis();
        arcTanof_x_at_n equationA = new arcTanof_x_at_n(n, BigDecimal.valueOf(1));
        pi_1 = four.multiply(        //π/4 * 4 = π
                equationA.getArcTan());                          //arcTan(1)
        endA = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("A time is " + formatter.format((endA - startA) / 1000d) + " seconds");


        //π/4 * 4 = π
        //arcTan(1/2) +
        //arcTan(1/3)
        startB = System.currentTimeMillis();
        arcTanof_x_at_n equationB_1 = new arcTanof_x_at_n(n, BigDecimal.valueOf(0.5));
        arcTanof_x_at_n equationB_2 = new arcTanof_x_at_n(n, BigDecimal.valueOf(0.33333333333333333333333333333333));
        BigDecimal prod_1 = four.multiply(equationB_1.getArcTan());
        BigDecimal prod_2 = four.multiply(equationB_2.getArcTan());
        pi_2 = prod_1.add(prod_2);
        endB = System.currentTimeMillis();
        NumberFormat formatte = new DecimalFormat("#0.00000");
        System.out.println("B time is " + formatte.format((endB - startB) / 1000d) + " seconds");

        startC = System.currentTimeMillis();
        arcTanof_x_at_n equationC_1 = new arcTanof_x_at_n(n, BigDecimal.valueOf(0.2));
        arcTanof_x_at_n equationC_2 = new arcTanof_x_at_n(n, BigDecimal.valueOf(0.00418410041841004184100418410042));
        pi_3 = four.multiply(                              //π/4 * 4 = π
                (four.multiply(                                       //4 *
                        equationC_1.getArcTan())).subtract(           //arcTan(1/5) -
                        equationC_2.getArcTan()));                    //arcTan(1/239
        endC = System.currentTimeMillis();
        NumberFormat formatt = new DecimalFormat("#0.00000");
        System.out.println("C time is " + formatt.format((endC - startC) / 1000d) + " seconds");

        startD = System.currentTimeMillis();
        arcTanof_x_at_n equationD_1 = new arcTanof_x_at_n(n, BigDecimal.valueOf(0.05555555555555555555555555555556));
        arcTanof_x_at_n equationD_2 = new arcTanof_x_at_n(n, BigDecimal.valueOf(0.01754385964912280701754385964912));
        arcTanof_x_at_n equationD_3 = new arcTanof_x_at_n(n, BigDecimal.valueOf(0.00418410041841004184100418410042));
        pi_4 = four.multiply(                                                //π/4 * 4 = π
                (BigDecimal.valueOf(12).multiply(equationD_1.getArcTan()))                //12*arcTan(1/18)
                .add((BigDecimal.valueOf(8).multiply(equationD_2.getArcTan())))           //+ 8*arcTan(1/57)
                .subtract((BigDecimal.valueOf(5).multiply(equationD_3.getArcTan())))  );    //- 5*arcTan(1/239)
        endD = System.currentTimeMillis();
        NumberFormat forma = new DecimalFormat("#0.00000");
        System.out.println("D time is " + forma.format((endD - startD) / 1000d) + " seconds");

        startArcTan = System.currentTimeMillis();
        arcTanof_x_at_n customVal = new arcTanof_x_at_n(n,x);
        arcTan = customVal.getArcTan();
        endArcTan = System.currentTimeMillis();
        NumberFormat formatterS = new DecimalFormat("#0.00000");
        System.out.println("arcTan time is " + formatterS.format((endArcTan - startArcTan) / 1000d) + " seconds");

        System.out.println("Equation A: " + pi_1);
        System.out.println("Equation B: " + pi_2);
        System.out.println("Equation C: " + pi_3);
        System.out.println("Equation D: " + pi_4);

    }

    public BigDecimal getPi_1(){return pi_1;}
    public BigDecimal getPi_2(){return pi_2;}
    public BigDecimal getPi_3(){return pi_3;}
    public BigDecimal getPi_4(){return pi_4;}
    public BigDecimal getArcTan(){return arcTan;}
}
