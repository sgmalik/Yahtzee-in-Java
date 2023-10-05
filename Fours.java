/*
Surya Malik
CS110B
This program is my fours
class, which extends my category class
and overwrites the abstract method
given in category.
*/

public class Fours extends Category
{
   /** evaluate is an overriden abstract method which sums all of the die of value 4
      @param d is a dice object
      @return the sum of all die of value 4
   */
   @Override
   public int evaluate(Dice d)
   {
      int score = d.count(4) * 4;
      return score;
   }
}