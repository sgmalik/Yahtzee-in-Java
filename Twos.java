/*
Surya Malik
This program is my twos
class, which extends my category class
and overwrites the abstract method
given in category.
*/

public class Twos extends Category
{
   /** evaluate is an overriden abstract method which sums all of the die of value 2
      @param d is a Dice object
      @return the sum of all die of value 2
   */
   @Override
   public int evaluate(Dice d)
   {
      int score = d.count(2) * 2;
      return score;
   }
}
