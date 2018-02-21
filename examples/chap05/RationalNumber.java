/**
 * Represents one rational number with a numerator and denominator.
 * 
 * @author Java Foundations
 */
public class RationalNumber
{
   private int numerator, denominator;

   /**
    * Constructor: Sets up the rational number by ensuring a nonzero
    * denominator and making only the numerator signed.
    * @param numer
    * @param denom
    */
   public RationalNumber(int numer, int denom)
   {
      if (denom == 0)
         denom = 1;

      // Make the numerator "store" the sign
      if (denom < 0)
      {
         numer = numer * -1;
         denom = denom * -1;
      }

      numerator = numer;
      denominator = denom;

      reduce();
   }

   /**
    *  Returns the numerator of this rational number.
    *  @return the numerator
    */
   public int getNumerator()
   {
      return numerator;
   }

   /**
    * Returns the denominator of this rational number.
    * @return the denominator
    */
   public int getDenominator()
   {
      return denominator;
   }

   /**
    * Returns the reciprocal of this rational number.
    * @return the result
    */
   public RationalNumber reciprocal()
   {
      return new RationalNumber(denominator, numerator);
   }

   /**
    * Adds this rational number to the one passed as a parameter.
    * A common denominator is found by multiplying the individual
    * denominators.
    * @param op2 the number to add this number to.
    * @return the result
    */
   public RationalNumber add(RationalNumber op2)
   {
      int commonDenominator = denominator * op2.getDenominator();
      int numerator1 = numerator * op2.getDenominator();
      int numerator2 = op2.getNumerator() * denominator;
      int sum = numerator1 + numerator2;

      return new RationalNumber(sum, commonDenominator);
   }

   /**
    * Subtracts the rational number passed as a parameter from this
    * rational number.
    * @param op2 the number to subtract from this number.
    * @return the result
    */
   public RationalNumber subtract(RationalNumber op2)
   {
      int commonDenominator = denominator * op2.getDenominator();
      int numerator1 = numerator * op2.getDenominator();
      int numerator2 = op2.getNumerator() * denominator;
      int difference = numerator1 - numerator2;

      return new RationalNumber(difference, commonDenominator);
   }

   /**
    * Multiplies this rational number by the one passed as a
    * parameter.
    * @param op2 the number to multiply by this number
    * @return the result
    */
   public RationalNumber multiply(RationalNumber op2)
   {
      int numer = numerator * op2.getNumerator();
      int denom = denominator * op2.getDenominator();

      return new RationalNumber(numer, denom);
   }

   /**
    * Divides this rational number by the one passed as a parameter
    * by multiplying by the reciprocal of the second rational.
    * 
    * @param op2 the number to divide this this number by.
    * @return the result
    */
   public RationalNumber divide(RationalNumber op2)
   {
      return multiply(op2.reciprocal());
   }

   /**
    * Determines if this rational number is equal to the one passed
    * as a parameter.  Assumes they are both reduced.
    * @param op2
    * @return true if they are equal, false otherwise.
    */
   public boolean isLike(RationalNumber op2)
   {
      return ( numerator == op2.getNumerator() &&
               denominator == op2.getDenominator() );
   }

   /**
    * Returns this rational number as a string.
    */
   public String toString()
   {
      String result;

      if (numerator == 0)
         result = "0";
      else
         if (denominator == 1)
            result = numerator + "";
         else
            result = numerator + "/" + denominator;
    
      return result;
   }

   /**
    * Reduces this rational number by dividing both the numerator
    * and the denominator by their greatest common divisor.
    */
   private void reduce()
   {
      if (numerator != 0)
      {
         int common = gcd(Math.abs(numerator), denominator);

         numerator = numerator / common;
         denominator = denominator / common;
      }
   }

   /**
    * Computes and returns the greatest common divisor of the two
    * positive parameters. Uses Euclid's algorithm.
    * @param num1
    * @param num2
    * @return
    */
   private int gcd(int num1, int num2)
   {
      while (num1 != num2) {
         if (num1 > num2) {
            num1 = num1 - num2;
         } else {
            num2 = num2 - num1;
         }
      }

      return num1;
   }
}
