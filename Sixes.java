/*
Surya Malik
This program is my sixes
class, which extends my category class
and overwrites the abstract method
given in category.
*/

public class Sixes extends Category
{
   /** evaluate is an overriden abstract method which sums all of the die of value 6
      @param d is a Dice object
      @return the sum of all die of value 6
   */
   @Override
   public int evaluate(Dice d)
   {
      int score = d.count(6) * 6;
      return score;
   }
}
