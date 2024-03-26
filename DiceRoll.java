/*
Surya Malik
This program is my DiceRoll
class, containing different methods 
for completing different tasks
regarding a dice object which
extends my Dice class.
*/

public class DiceRoll extends Dice
{
   //Instance variables
   final private static int NUM_DIE = 5;
   
   /** DiceRoll is a constructor that creates an array list with the default capacity constant
      and adds Die objects to the array list
   */
   public DiceRoll()
   {
      super(NUM_DIE);
      addDie(new Die());
      addDie(new Die());
      addDie(new Die());
      addDie(new Die());
      addDie(new Die());
   }
   
   /** toss rolls all of the dice in the array list
   */
   public void toss()
   {
      for (int count = 0; count < getNumDice(); count++)
      {
         getDie(count).roll();
      }
   }
}
