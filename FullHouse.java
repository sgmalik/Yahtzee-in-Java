/*
Surya Malik
CS110B
This program is my FullHouse
class, which extends my category class
and overwrites the abstract method
given in category.
*/

public class FullHouse extends Category
{
   /** evaluate is an overriden abstract method which returns a score of 25
       if 3 die are equal and the remaining 2 are equal but a differing value
      @param d is a Dice object
      @return score of 25
   */
   @Override
   public int evaluate(Dice d)
   {
      int score = 0;
      int val = 0;
      boolean three = false;
      boolean two = false;
      for (int count = 1; count < 7; count++)
      {
         if (d.count(count) == 3)
         {
            val = count;
            three = true;
         }
      }
      
      for (int count = 1; count < 7; count++)
      {
         if (d.count(count) == 2 && count != val)
         {
            two = true;
         }
      }
      if (two && three)
      {
         score = 25;
      }
      
      return score;
   }
}