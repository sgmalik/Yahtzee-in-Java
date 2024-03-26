/*
Surya Malik
This program is my chance
class, which extends my category class
and overwrites the abstract method
given in category.
*/
public class Chance extends Category
{
   /** evaluate is an overriden abstract method which sums all of the die 
      @param d is a dice object
      @return the sum of all die
   */
   
   @Override
   public int evaluate(Dice d)
   {
      return d.sum();
   }
}
