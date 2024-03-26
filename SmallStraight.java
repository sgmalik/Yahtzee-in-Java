/*
Surya Malik
This program is my SmallStraight
class, which extends my category class
and overwrites the abstract method
given in category.
*/

public class SmallStraight extends Category
{
   /** evaluate is an overriden abstract method which returns a score of 30 if there are 4 consecutive numbers
      @param d is a Dice object
      @return score of 30
   */
   @Override
   public int evaluate(Dice d)
   {
      int score = 0;
      if (d.contains(3) && d.contains(4))
      {
         if (d.contains(5) && d.contains(6))
         {
            score = 30;
         }
         else if (d.contains(1) && d.contains(2))
         {  
            score = 30;
         }
         
         else if (d.contains(2) && d.contains(5))
         {
            score = 30;
         }
      }
      
      return score;
   }
}
