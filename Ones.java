/*
Surya Malik
CS110B
This program is my ones
class, which extends my category class
and overwrites the abstract method
given in category.
*/

public class Ones extends Category
{
   /** evaluate is an overriden abstract method which sums all of the die of value 1
      @param d is a Dice object
      @return the sum of all die of value 1
   */
   @Override
   public int evaluate(Dice d)
   {
      return d.count(1);
   }
}