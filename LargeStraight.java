/*
Surya Malik
This program is my LargeStraight
class, which extends my category class
and overwrites the abstract method
given in category.
*/

public class LargeStraight extends Category
{
   /** evaluate is an overriden abstract method which returns a score of 40 if there are 5 consecutive numbers
      @param d is a Dice object
      @return score of 40
   */
   @Override
   public int evaluate(Dice d)
   {
      int score = 0;
      if (d.contains(2) && d.contains(3) && d.contains(4) && d.contains(5))
      {
         if (d.contains(1) || d.contains(6))
         {
            score = 40;
         }
      }
      return score;
   }
}
