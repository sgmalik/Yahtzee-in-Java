/*
Surya Malik
This program is my fives
class, which extends my category class
and overwrites the abstract method
given in category.
*/

public class Fives extends Category
{
   /** evaluate is an overriden abstract method which sums all of the die of value 5
      @param d is a dice object
      @return the sum of all die of value 5
   */
   @Override
   public int evaluate(Dice d)
   {
      int score = d.count(5) * 5;
      return score;
   }
}
