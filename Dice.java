/*
Surya Malik
CS110B
This program is my Dice
class, containing different methods 
for completing different tasks
regarding a dice object which
will ultimately extend into my DiceRoll
class.
*/

import java.util.ArrayList;

public class Dice
{
   //Instance variables
   private ArrayList<Die> dice;
   final private int DEF_CAP = 5;
   
   
   /** Dice is a constructor that creates an array list with the default capacity constant
   */
   public Dice()
   {
      dice = new ArrayList<Die>(DEF_CAP);
   }
   
   /** Dice is a constructor that creates an array list with a given number
      @param num is an int set to the capacity of the array list
   */
   public Dice(int num)
   {
      dice = new ArrayList<Die>(num);
   }
   
   
   /** addDie adds a die object to the array list
      @param d is a Die object
   */
   public void addDie(Die d)
   {
      dice.add(d);
   }
   
   /** getNumDice returns the number of elements in the array list
      @return the size of the array list
   */
   public int getNumDice()
   {
      return dice.size();
   }
   
   /** getDie returns the die object at the given index
      @param i is an int for the index
      @return the die at the given index
   */
   public Die getDie(int i)
   {
      return dice.get(i);
   }
   
   /** removeDie removes the die object at the given index
      @param i is an int for the index
   */
   public void removeDie(int i)
   {
      dice.remove(i);
   }
   
   /** count returns the number of die that have a given value
      @param val is an int for the specified value
      @return count is the number of times the value was in the array list
   */
   public int count(int val)
   {
      int count = 0;
      for (Die d : dice)
      {
         if (d.getValue() == val)
         {
            count++;
         }
      }
      return count;
   }
   
   /** sum returns the total sum of all die in the array list
      @return total which is the overall sum
   */
   public int sum()
   {
      int total = 0;
      for (Die d : dice)
      {
         total += d.getValue();
      }
      return total;
   }
   
   /** contains returns a boolean as to whether or not the given value is in the array list
      @param val is an int for the specified value
      @return b is a boolean for the status of the value being contained in the array list
   */
   public boolean contains(int val)
   {
      boolean b = false;
      for (Die d : dice)
      {
         if (d.getValue() == val)
            b = true;
      }
      return b;
   }
   
   /** toString returns a formatted string
      @return formatted string with all info
   */
   
   //toString method
   @Override
   public String toString()
   {
      String s = "";
      for (int count = 0; count < dice.size(); count++)
      {
         s += String.format("\n%d: value " + dice.get(count), count + 1);
      }
      return s;
   }
}