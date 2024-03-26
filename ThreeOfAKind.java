/*
Surya Malik
This program is my ThreeOfAKind
class, which extends my category class
and overwrites the abstract method
given in category.
*/

public class ThreeOfAKind extends Category
{
   /** evaluate is an overriden abstract method which sums 3 die of the same value
      @param d is a Dice object
      @return the sum of all die
   */
   @Override
   public int evaluate(Dice d)
   {
      int score = 0;
      for (int count = 1; count < 7; count++)
      {
         if (d.count(count) == 3)
         {
            score = d.sum();
         }
      }
      return score;
   }
}
