package ArcTan_approxiamtions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Erez on 12/9/2016.
 */

/**
 * using arcTan(1) = π/4
 *
 * arcTan(x) = SIGMA{{-1}^{n-1} * {x^{2n-1}} / {2n-1}}
 */
public class arcTanof_x_at_n
{
    private static int odd=1;
    private int n_value = 6;
    private BigDecimal x_value = new BigDecimal(0.5);
    private BigDecimal arcTan = BigDecimal.ONE;

    public arcTanof_x_at_n(int n, BigDecimal x)
    {
        this.n_value = n;
        this.x_value = x;
    }

    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();

        //calculatePi();
        //System.out.println("Pi is = "+getArcTan().multiply(BigDecimal.valueOf(4)));

        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }

    private void calculatePi()
    {
        /**
         * Declaring constants and variable needed
         */
        BigDecimal x = x_value;
        BigInteger n_one = BigInteger.valueOf(-1);
        BigInteger sign;
        BigDecimal numerator;
        BigInteger denominator;
        BigDecimal currentSigma = BigDecimal.ZERO;
        BigDecimal one = BigDecimal.ONE;
        BigDecimal temp;

        for(int i=1; i<=n_value; i++)
        {
            sign = exponent(n_one, i-1);
            numerator = exponent2(x, (2*i)-1);
            denominator = BigInteger.valueOf((2*i)-1);

            temp = new BigDecimal(sign).multiply(numerator).
                            divide(new BigDecimal(denominator), new
                                    MathContext(10000));
            currentSigma = currentSigma.add(temp);

            //System.out.println("Interation: " + i + " : "+ currentSigma);
        }

        /**
         * approximation for π/4 * 4 is an approximation for π
         */
        arcTan = currentSigma;
        //pi = BigDecimal.valueOf(4).multiply(currentSigma);

        //System.out.println("Pi is: " + pi);
    }

    /**
     * This method is synonomous to the Math.Pow method, except it takes better args
     * @param a
     * @param b
     * @return returns the value of a^b
     */
    public BigInteger exponent(BigInteger a, int b)
    {
        BigInteger answer=new BigInteger("1");

        for(int i=0;i<b;i++)
        {
            answer = answer.multiply(a);
        }

        return answer;
    }

    public BigDecimal exponent2(BigDecimal a, int b)
    {
        BigDecimal answer=new BigDecimal("1");

        for(int i=0;i<b;i++)
        {
            answer = answer.multiply(a);
        }

        return answer;
    }

    public BigDecimal getArcTan()
    {
        calculatePi();
        return arcTan;
    }
}
