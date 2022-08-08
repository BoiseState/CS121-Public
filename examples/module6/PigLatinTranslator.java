import java.util.Scanner;

/**
 * Represents a translator from English to Pig Latin. Demonstrates 
 * method decomposition.
 * 
 * @author Java Foundations
 */
public class PigLatinTranslator
{
   /**
    * Translates a sentence of words into Pig Latin.
    * @param sentence The sentence to translate.
    * @return The translated sentence.
    */
   public static String translate (String sentence)
   {
      String result = "";

      sentence = sentence.toLowerCase();

      Scanner scan = new Scanner (sentence);

      while (scan.hasNext())
      {
         result += translateWord (scan.next());
         result += " ";
      }

      scan.close();
      
      return result;
   }

   /**
    * Translates one word into Pig Latin. If the word begins with a
    *  vowel, the suffix "yay" is appended to the word.  Otherwise,
    *  the first letter or two are moved to the end of the word,
    *  and "ay" is appended.
    * @param word The word to translate.
    * @return The translated word.
    */
   private static String translateWord (String word)
   {
      String result = "";

      if (beginsWithVowel(word))
      {
    	  // at --> atyay
    	  result = word + "yay";
      }
      else
      {
         if (beginsWithBlend(word))
         {
        	 // what -->  atwhay
        	 result = word.substring(2) + word.substring(0,2) + "ay";
         }
         else
         {
        	 // rabbit --> abbitray
        	 result = word.substring(1) + word.charAt(0) + "ay";
         }
      }

      return result;
   }

   /**
    * Determines if the specified word begins with a vowel.
    * @param word The word to check.
    * @return true if the word begins with a vowel, false otherwise.
    */
   private static boolean beginsWithVowel (String word)
   {
      String vowels = "aeiou";

      char letter = word.charAt(0);

      return (vowels.indexOf(letter) != -1);
   }

   /**
    * Determines if the specified word begins with a particular
    * two-character consonant blend.
    * @param word The word to check.
    * @return true if the word begins with a consonant blend, false
    * otherwise.
    */
   private static boolean beginsWithBlend (String word)
   {
      return ( word.startsWith ("bl") || word.startsWith ("sc") ||
               word.startsWith ("br") || word.startsWith ("sh") ||
               word.startsWith ("ch") || word.startsWith ("sk") ||
               word.startsWith ("cl") || word.startsWith ("sl") ||
               word.startsWith ("cr") || word.startsWith ("sn") ||
               word.startsWith ("dr") || word.startsWith ("sm") ||
               word.startsWith ("dw") || word.startsWith ("sp") ||
               word.startsWith ("fl") || word.startsWith ("sq") ||
               word.startsWith ("fr") || word.startsWith ("st") ||
               word.startsWith ("gl") || word.startsWith ("sw") ||
               word.startsWith ("gr") || word.startsWith ("th") ||
               word.startsWith ("kl") || word.startsWith ("tr") ||
               word.startsWith ("ph") || word.startsWith ("tw") ||
               word.startsWith ("pl") || word.startsWith ("wh") ||
               word.startsWith ("pr") || word.startsWith ("wr") ); 
   }
}
