/*
Surya Malik
This program is my threes
class, which extends my category class
and overwrites the abstract method
given in category.
*/

public class Threes extends Category
{
   /** evaluate is an overriden abstract method which sums all of the die of value 3
      @param d is a Dice object
      @return the sum of all die of value 3
   */
   @Override
   public int evaluate(Dice d)
   {
      int score = d.count(3) * 3;
      return score;
   }
}
