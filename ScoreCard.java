/*
Surya Malik
This program is my ScoreCard
class, containing different methods 
for completing different tasks
regarding a ScoreCard object.
*/

import java.util.ArrayList;

public class ScoreCard
{
   //Instance variables
   private ArrayList<Category> scorecard;
   private int yahtzeeBonus = 0;
   final private static int NUM_CATS = 13;
   
   /** ScoreCard creates a new array list of categories, creates an instance of each category and adds it to the array list
   */
   public ScoreCard()
   {
      Category ones = new Ones();
      Category twos = new Twos();
      Category threes = new Threes();
      Category fours = new Fours();
      Category fives = new Fives();
      Category sixes = new Sixes();
      Category threeOfAKind = new ThreeOfAKind();
      Category fourOfAKind = new FourOfAKind();
      Category fullHouse = new FullHouse();
      Category smallStraight = new SmallStraight();
      Category largeStraight = new LargeStraight();
      Category yahtzee = new Yahtzee();
      Category chance = new Chance();
      
      scorecard = new ArrayList<Category>(NUM_CATS);
      
      scorecard.add(ones);
      scorecard.add(twos);
      scorecard.add(threes);
      scorecard.add(fours);
      scorecard.add(fives);
      scorecard.add(sixes);
      scorecard.add(threeOfAKind);
      scorecard.add(fourOfAKind);
      scorecard.add(fullHouse);
      scorecard.add(smallStraight);
      scorecard.add(largeStraight);
      scorecard.add(yahtzee);
      scorecard.add(chance);
   }
   
   /** choose is a method that takes a given category and evaluates it
      @param cv is the given category value for evaluation
      @param d is a Dice object
   */
   public void choose(CategoryValue cv, Dice d)
   {
      if (cv == CategoryValue.YAHTZEE && getCategoryScore(CategoryValue.YAHTZEE) == 50)
      {
         yahtzeeBonus += 100;
      }
      
      else
      {
         Category choice = scorecard.get(cv.getValue());
         choice.addValue(d);
      }
   }
   
   /** getEvaluation returns the evaluation for the given category
      @param cv is the given category value for evaluation
      @param d is a Dice object
      @return the evaluation of the specified category
   */
   public int getEvaluation(CategoryValue cv, Dice d)
   {
      Category choice = scorecard.get(cv.getValue());
      return choice.evaluate(d);
   }
   
   /** checkScored returns true or false whether a given category has been used
      @param cv is the given category value for evaluation
      @return boolean whether or not the category has been used
   */
   public boolean checkScored(CategoryValue cv)
   {
      Category choice = scorecard.get(cv.getValue());
      return choice.getUsed();
   }
   
   /** getCategoryScore returns the score of the given category
      @param cv is the given category value for evaluation
      @return the score of the given category
   */
   public int getCategoryScore(CategoryValue cv)
   {
      Category choice = scorecard.get(cv.getValue());
      return choice.getScore();
   }
   
   /** scoreTop totals the top half of the scorecard
      @return total of the top half
   */
   public int scoreTop()
   {
      int total = 0;
      for (int count = 0; count < 6; count++)
      {
         total += scorecard.get(count).getScore();
      }
      return total;
   }
   
   /** scoreBottom totals the bottom half of the scorecard
      @return total of the bottom half
   */
   public int scoreBottom()
   {
      int total = 0;
      for (int count = 6; count < 13; count ++)
      {
         total += scorecard.get(count).getScore();
      }
      return total;
   }
   
   /** score totals the top and bottom of the scorecard as well as the yahtzee bonus
      @return total is the total score on the entirety of the players card
   */
   public int score()
   {
      int total = scoreTop() + scoreBottom() + yahtzeeBonus;
      return total;
   }
   
   /** toString returns a formatted string
      @return formatted string with all info
   */
   @Override
   public String toString()
   {
      String s = String.format("Current Scorecard:\n");
      for (int count = 0; count < scorecard.size(); count++)
      {
         s += String.format("%15s: %d\n", CategoryValue.values()[count], scorecard.get(count).getScore());
      }
      
      s += String.format("%15s: %d\n", "Upper total", scoreTop());
      s += String.format("%15s: %d\n", "Lower total", scoreBottom());
      s += String.format("%15s: %d\n", "Total", score());
      
      return s;
   }
}
