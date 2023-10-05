/*
Surya Malik
CS110B
This program is my Yahtzee
class, which extends my category class
and overwrites the abstract method
given in category.
*/

public class Yahtzee extends Category
{
   /** evaluate is an overriden abstract method which returns 50 for yahtzee
      @param d is a Dice object
      @return score 50
   */
   @Override
   public int evaluate(Dice d)
   {
      int score = 0;
      for (int count = 1; count < 7; count++)
      {
         if (d.count(count) == 5)
         {
            score = 50;
         }
      }
      return score;
   }
}