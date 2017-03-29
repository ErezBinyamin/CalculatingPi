package RamJan;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;


/**
 * using Ramanujans Sato-series
 *
 * 1/π = {{2*root{2}} / 9801} * SIGMA {{{4k!}*{1103+26390k}} / {{k!}^4 {396}^{4k} }}
 */

public class Ramanujan {

    private static int odd=1;
    private static int k_value=1;
    private static BigDecimal pi = BigDecimal.ONE;

    public Ramanujan(int k)
    {
        this.k_value = k;
    }

    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();

        calculatePi();

        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Ramanujan time is " + formatter.format((end - start) / 1000d) + " seconds");
    }
    public static void calculatePi()
    {
        /**
         * Declaring constants and variables to be defined
         */
        BigInteger firstFactorial;
        BigInteger secondFactorial;
        BigInteger firstMultiplication;
        BigInteger firstExponent;
        BigInteger secondExponent;
        int firstNumber = 1103;                  //The constant to be added within the SIGMA
        BigInteger firstAddition;
        BigDecimal currentSigma = BigDecimal.ZERO;
        BigDecimal one = BigDecimal.ONE;
        int secondNumber = 2;                    //the numerator component
        double thirdNumber = Math.sqrt(2.0);     //the numerator component
        int fourthNumber = 9801;                 //the denominator 99^2
        BigDecimal prefix = BigDecimal.ONE;
        BigDecimal temp;

        /**
         * For loop solving the SIGMA
         */
        for(int i=0;i<k_value;i++){
            firstFactorial = factorial(4*i);                         //4k!
            secondFactorial = factorial(i);                          //k!
            firstMultiplication = BigInteger.valueOf(26390*i);       //26390k
            firstExponent = exponent(secondFactorial, 4);            //{k!}^4
            secondExponent = exponent(BigInteger.valueOf(396),4*i);  //{396}^{4k}

            firstAddition = BigInteger.valueOf(firstNumber).         //{1103+26390k}
                    add(firstMultiplication);

            temp = new BigDecimal(firstFactorial.multiply(firstAddition))
                    .divide(new BigDecimal
                    (firstExponent.multiply(secondExponent)), new
                    MathContext(10000)); //{{{4k!}*{1103+26390k}} / {{k!}^4 {396}^{4k} }}
            currentSigma = currentSigma.add(temp);

            System.out.println("Interation: " + i);
        }

        /**
         * Calculation of the "prefix" of the SIGMA
         */
        prefix =new BigDecimal(secondNumber*thirdNumber);
        prefix = prefix.divide(new BigDecimal(fourthNumber), new MathContext(1000));

        /**
         * {{2*root{2}} / 9801} * SIGMA
         */
        currentSigma = currentSigma.multiply(prefix, new MathContext(1000));

        /**
         * 1/π = current pi so flip it to find π
         */
        pi = one.divide(currentSigma, new MathContext(1000));

        System.out.println("Pi is: " + pi);

        return;
    }

    /**
     * Factorial function n * (n-1) * (n-2) ... * 3 * 2 * 1
     * @param a
     * @return value of a!
     */
    public static BigInteger factorial(int a)
    {
        BigInteger result=new BigInteger("1");
        BigInteger smallResult = new BigInteger("1");
        long x=a;
        if (x==1) return smallResult;
        while(x>1)
        {
            result= result.multiply(BigInteger.valueOf(x));

            x--;
        }
        return result;
    }

    /**
     * This method is synonomous to the Math.Pow method, except it takes better args
     * @param a
     * @param b
     * @return returns the value of a^b
     */
    public static BigInteger exponent(BigInteger a, int b)
    {
        BigInteger answer=new BigInteger("1");

        for(int i=0;i<b;i++) {
            answer = answer.multiply(a);
        }

        return answer;
    }

    public BigDecimal getPi(){return pi;}
}