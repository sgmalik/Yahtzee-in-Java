/*
Surya Malik
CS110B
This program is my Die
class, containing different methods 
for completing different tasks
regarding a die object which
will be used in my Dice class.
*/

import java.util.Random;

public class Die
{
   //Instance variables
   private int value;
   final private static int SIDES = 6;
   private static Random r = new Random();
   
   /** Die initializes the value of value to a random integer between 1 and SIDES
   */
   public Die()
   {
      value = r.nextInt(SIDES) + 1;
   }
   
   /** Roll changes the value of value to a random integer between 1 and SIDES
   */
   public void roll()
   {
      value = r.nextInt(SIDES) + 1;
   }
   
   /** getValue returns the value of the die
      @return value of the die
   */
   public int getValue()
   {
      return value;
   }
   
   /** toString returns a formatted string
      @return formatted string with all info
   */
   @Override
   public String toString()
   {
      return String.format("%d", value);
   }
}