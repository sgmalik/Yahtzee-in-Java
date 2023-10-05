/*
Surya Malik
CS110B
This program is my Category
class, containing different methods 
for completing different tasks
regarding the various different categories
within yahtzee. This class is abstract and
contains one abstract method, evaluate which
is overwritten in each of the classes
that extend category
*/

public abstract class Category
{
   //Instance variables
   private int score;
   private boolean used;
   
   /** evaluate returns the value of the given evaluation based on the chosen category
      @param d is a dice object
      @return integer value for the score
   */
   public abstract int evaluate(Dice d);
   
   
   /** addValue utilizes the evaluate function to add the given evaluation to score
      @param d is a dice object
   */
   public void addValue(Dice d)
   {
      score += evaluate(d);
      getUsed();
      used = true;
   }
   
   /** getScore returns the score of the category
      @return score of the given category
   */
   public int getScore()
   {
      return score;
   }
   
   /** getScore returns true if the category has been used
      @return used is the status of the category, whether it has been used or not
   */
   public boolean getUsed()
   {
      return used;
   }
   
}