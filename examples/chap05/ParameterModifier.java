/**
 * Demonstrates the effects of changing parameter values.
 * 
 * @author Java Foundations
 */
public class ParameterModifier
{
   /**
    * Modifies the parameters, printing their values before and
    * after making the changes.
    * @param f1
    * @param f2
    * @param f3
    */
   public void changeValues (int f1, Num f2, Num f3)
   {
      System.out.println ("Before changing the values:");
      System.out.println ("f1\tf2\tf3");
      System.out.println (f1 + "\t" + f2 + "\t" + f3 + "\n");

      f1 = 999;
      f2.setValue(888);
      f3 = new Num (777);

      System.out.println ("After changing the values:");
      System.out.println ("f1\tf2\tf3");
      System.out.println (f1 + "\t" + f2 + "\t" + f3 + "\n");
   }
}
